import { WebPlugin } from '@capacitor/core';
import { getColorScheme } from '@tanishqmanuja/web-monet';

import type { HexColor, MonetPalette, MonetPlugin } from './definitions';

export class MonetWeb extends WebPlugin implements MonetPlugin {
  async getSystemMonetPalette(): Promise<MonetPalette | undefined> {
    throw new Error('Method not implemented.');
  }

  async generateMonetPalette(options: {
    seedColor: HexColor;
  }): Promise<MonetPalette> {
    return getColorScheme(options.seedColor);
  }
}
