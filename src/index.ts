import { registerPlugin } from '@capacitor/core';

import type { DefaultGatewayPlugin } from './definitions';

const DefaultGateway = registerPlugin<DefaultGatewayPlugin>('DefaultGateway', {});

export * from './definitions';
export default DefaultGateway;
export const {gateway4async, gateway6async} = DefaultGateway;
