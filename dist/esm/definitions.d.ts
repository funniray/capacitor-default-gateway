export interface Result<Family extends 4 | 6> {
    /**
     * The IP address of the default gateway.
     */
    gateway: string;
    /**
     * The IP address version of `gateway`.
     */
    version: Family;
    /**
     * Name of the interface.
     * On Windows, this is the network adapter name.
     * This can be `null` if it cannot be determined.
     */
    int: string | null;
}
export interface DefaultGatewayPlugin {
    gateway4async(): Promise<Result<4>>;
    gateway6async(): Promise<Result<6>>;
}
