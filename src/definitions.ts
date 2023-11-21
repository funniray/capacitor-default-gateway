export interface DefaultGatewayPlugin {
  echo(options: { value: string }): Promise<{ value: string }>;
}
