export interface MonetPlugin {
  /**
   * Get the moent palette from native android system.
   *
   */
  getSystemMonetPalette(): Promise<MonetPalette | undefined>;

  /**
   * Generates Monet palette.
   *
   */
  generateMonetPalette(options: { seedColor: HexColor }): Promise<MonetPalette>;
}

export type TonalPaletteNames =
  | 'accent1'
  | 'accent2'
  | 'accent3'
  | 'neutral1'
  | 'neutral2';

export type TonalShadeNames =
  | 0
  | 10
  | 50
  | 100
  | 200
  | 300
  | 400
  | 500
  | 600
  | 700
  | 800
  | 900
  | 1000;

export type HexColor = `#${string}`;

export type MonetTonalPalette = {
  [shade in TonalShadeNames]: HexColor;
};

export type MonetPalette = {
  [palette in TonalPaletteNames]: MonetTonalPalette;
};

export interface AutoInjectStyleOptions {
  prefix?: string;
  fallbackSeedColor?: HexColor;
}
