import { Capacitor } from '@capacitor/core';
import { getColorScheme } from '@tanishqmanuja/web-monet';

import type { Monet } from '.';
import type {
  AutoInjectStyleOptions,
  HexColor,
  MonetPalette,
} from './definitions';

const FALLBACK_STYLE_PREFIX = 'md3';
const FALLBACK_SEED_COLOR = '#3880ff';

const defaultOptions: Required<AutoInjectStyleOptions> = {
  prefix: FALLBACK_STYLE_PREFIX,
  fallbackSeedColor: FALLBACK_SEED_COLOR,
};

export class MonetController {
  constructor(private monet: typeof Monet) {}

  async autoInjectStyle(options?: AutoInjectStyleOptions): Promise<void> {
    const opts = { ...defaultOptions, ...options };

    if (Capacitor.getPlatform() === 'android') {
      const palette = await this.monet.getSystemMonetPalette();
      if (palette) {
        this.injectStyleRoot(palette, opts.prefix);
      } else {
        console.warn(
          `[CapacitorMonet]: Unable to get palette, unsupported android system.`,
        );
        const palette = getColorScheme(opts.fallbackSeedColor);
        this.injectStyleRoot(palette, opts.prefix);
      }
    } else {
      const ionicPrimaryColor = getComputedStyle(
        document.documentElement,
      ).getPropertyValue('--ion-color-primary') as HexColor;
      const palette = getColorScheme(
        ionicPrimaryColor || opts.fallbackSeedColor,
      );
      this.injectStyleRoot(palette, opts.prefix);
    }
  }

  injectStyleRoot(palette: MonetPalette, prefix: string): void {
    const res = Object.keys(palette).reduce(
      (style, tonalPaletteName) =>
        style +
        Object.keys((palette as Record<string, any>)[tonalPaletteName]).reduce(
          (line, shadeName) =>
            line +
            `--${prefix}-${
              tonalPaletteName.charAt(0) +
              tonalPaletteName.charAt(tonalPaletteName.length - 1)
            }-${shadeName}: ${
              (palette as Record<string, any>)[tonalPaletteName][shadeName]
            };`,
          '',
        ),
      '',
    );
    const css = `:root {${res}}}`;
    const headEl = document.getElementsByTagName('head')[0];
    // remove existing style element
    const existingStyleEl = headEl.querySelectorAll('style[data-monet]')?.[0];
    if (existingStyleEl) {
      existingStyleEl.remove();
    }
    const styleEl = document.createElement('style');
    styleEl.dataset.monet = '';
    styleEl.appendChild(document.createTextNode(css));
    headEl.appendChild(styleEl);
  }

  injectStyleElement(
    el: HTMLElement,
    palette: MonetPalette,
    prefix: string,
  ): void {
    const propMap = Object.entries(palette).reduce(
      (mainMap, [tonalPaletteName, tonalPalette]) => ({
        ...mainMap,
        ...Object.entries(tonalPalette).reduce(
          (tonalMap, [shadeName, hexColor]) => {
            const key = `--${prefix}-${tonalPaletteName.charAt(
              0,
            )}${tonalPaletteName.charAt(
              tonalPaletteName.length - 1,
            )}-${shadeName}`;
            return { ...tonalMap, [key]: hexColor };
          },
          {},
        ),
      }),
      {} as Record<string, string>,
    );

    Object.entries(propMap).forEach(([prop, val]) => {
      el.style.setProperty(prop, val);
    });
  }
}
