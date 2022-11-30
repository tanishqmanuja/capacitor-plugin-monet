import { WebPlugin } from '@capacitor/core';

import type { MonetPlugin } from './definitions';

export class MonetWeb extends WebPlugin implements MonetPlugin {
  async echo(options: { value: string }): Promise<{ value: string }> {
    console.log('ECHO', options);
    return options;
  }
}
