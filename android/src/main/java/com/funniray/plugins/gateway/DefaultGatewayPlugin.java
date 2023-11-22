package com.funniray.plugins.gateway;

import android.Manifest;
import android.annotation.SuppressLint;
import android.net.ConnectivityManager;
import android.net.LinkProperties;
import android.net.RouteInfo;
import com.getcapacitor.*;
import com.getcapacitor.annotation.CapacitorPlugin;
import com.getcapacitor.annotation.Permission;
import com.getcapacitor.annotation.PermissionCallback;

import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;

@CapacitorPlugin(
    name = "DefaultGateway",
    permissions = {
        @Permission(alias = "network_state", strings = {Manifest.permission.ACCESS_NETWORK_STATE})
    }
)
public class DefaultGatewayPlugin extends Plugin {

    @PluginMethod
    public void gateway4async(PluginCall call) {
        call.getData().put("version", 4);
        getGateway(call);
    }

    @PluginMethod
    public void gateway6async(PluginCall call) {
        call.getData().put("version", 6);
        getGateway(call);
    }

    private void getGateway(PluginCall call) {
        if (android.os.Build.VERSION.SDK_INT < android.os.Build.VERSION_CODES.M) {
            call.reject("Requires SDK 23");
            return;
        }

        if (getPermissionState("network_state") != PermissionState.GRANTED) {
            requestPermissionForAlias("network_state", call, "networkPermsCallback");
        } else {
            doGatewayCalc(call);
        }
    }

    @PermissionCallback
    public void networkPermsCallback(PluginCall call) {
        if (getPermissionState("network_state") == PermissionState.GRANTED) {
            doGatewayCalc(call);
        } else {
            call.reject("Network permission denied");
        }
    }

    @SuppressLint("MissingPermission")
    private void doGatewayCalc(PluginCall call) {
        if (android.os.Build.VERSION.SDK_INT < android.os.Build.VERSION_CODES.M) {
            call.reject("Requires SDK 23");
            return;
        }

        ConnectivityManager connectivityManager = getActivity().getSystemService(ConnectivityManager.class);
        LinkProperties link = connectivityManager.getLinkProperties(connectivityManager.getActiveNetwork());

        int version = call.getInt("version", 4);

        if (version != 4 && version != 6) {
            call.reject("IP version must be 4 or 6");
        }

        for (RouteInfo routeInfo: link.getRoutes()) {
            InetAddress gateway = routeInfo.getGateway();
            if (gateway == null || gateway.isAnyLocalAddress() || (version != 4 && gateway instanceof Inet4Address) ||  (version != 6 && gateway instanceof Inet6Address)) continue;

            call.resolve(new JSObject()
                    .put("gateway", gateway.getHostAddress())
                    .put("version", version)
                    .put("int", link.getInterfaceName()));

            return;
        }

        call.resolve();
    }
}
