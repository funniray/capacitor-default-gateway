var capacitorDefaultGateway = (function (exports, core) {
	'use strict';

	const DefaultGateway = core.registerPlugin('DefaultGateway', {});
	const { gateway4async, gateway6async } = DefaultGateway;

	exports["default"] = DefaultGateway;
	exports.gateway4async = gateway4async;
	exports.gateway6async = gateway6async;

	Object.defineProperty(exports, '__esModule', { value: true });

	return exports;

})({}, capacitorExports);
//# sourceMappingURL=plugin.js.map
