import { registerPlugin } from '@capacitor/core';
const DefaultGateway = registerPlugin('DefaultGateway', {});
export * from './definitions';
export default DefaultGateway;
export const { gateway4async, gateway6async } = DefaultGateway;
//# sourceMappingURL=index.js.map