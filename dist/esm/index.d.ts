import type { DefaultGatewayPlugin } from './definitions';
declare const DefaultGateway: DefaultGatewayPlugin;
export * from './definitions';
export default DefaultGateway;
export declare const gateway4async: () => Promise<import("./definitions").Result<4>>, gateway6async: () => Promise<import("./definitions").Result<6>>;
