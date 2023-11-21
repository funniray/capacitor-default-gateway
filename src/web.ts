import { WebPlugin } from '@capacitor/core';

import type { DefaultGatewayPlugin } from './definitions';

export class DefaultGatewayWeb extends WebPlugin implements DefaultGatewayPlugin {
  async echo(options: { value: string }): Promise<{ value: string }> {
    console.log('ECHO', options);
    return options;
  }
}
