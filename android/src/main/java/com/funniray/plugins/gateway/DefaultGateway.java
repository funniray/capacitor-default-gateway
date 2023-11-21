package com.funniray.plugins.gateway;

import android.util.Log;

public class DefaultGateway {

    public String echo(String value) {
        Log.i("Echo", value);
        return value;
    }
}
