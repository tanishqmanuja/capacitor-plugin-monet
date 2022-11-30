export interface MonetPlugin {
  echo(options: { value: string }): Promise<{ value: string }>;
}
