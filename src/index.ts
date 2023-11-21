import { registerPlugin } from '@capacitor/core';

import type { DefaultGatewayPlugin } from './definitions';

const DefaultGateway = registerPlugin<DefaultGatewayPlugin>('DefaultGateway', {
  web: () => import('./web').then(m => new m.DefaultGatewayWeb()),
});

export * from './definitions';
export { DefaultGateway };
