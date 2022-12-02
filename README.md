# capacitor-plugin-monet

Material You Monet Plugin for Capacitor

## Install

```bash
npm install @tanishqmanuja/capacitor-plugin-monet
npx cap sync
```

## Install (Android)

Add these lines to start of root build.gradle

```
allprojects {
  repositories {
    google()
    mavenCentral()
    maven { url 'https://jitpack.io' }
    maven { url "https://maven.pkg.jetbrains.space/public/p/compose/dev" }
  }
}
```

## API

<docgen-index>

* [`getSystemMonetPalette()`](#getsystemmonetpalette)
* [`generateMonetPalette(...)`](#generatemonetpalette)
* [Type Aliases](#type-aliases)

</docgen-index>

<docgen-api>
<!--Update the source file JSDoc comments and rerun docgen to update the docs below-->

### getSystemMonetPalette()

```typescript
getSystemMonetPalette() => Promise<MonetPalette | undefined>
```

Get the moent palette from native android system.

**Returns:** <code>Promise&lt;<a href="#monetpalette">MonetPalette</a>&gt;</code>

--------------------


### generateMonetPalette(...)

```typescript
generateMonetPalette(options: { seedColor: HexColor; }) => Promise<MonetPalette>
```

Generates Monet palette.

| Param         | Type                                      |
| ------------- | ----------------------------------------- |
| **`options`** | <code>{ seedColor: `#${string}`; }</code> |

**Returns:** <code>Promise&lt;<a href="#monetpalette">MonetPalette</a>&gt;</code>

--------------------


### Type Aliases


#### MonetPalette

<code>{ [palette in TonalPaletteNames]: <a href="#monettonalpalette">MonetTonalPalette</a>; }</code>


#### TonalPaletteNames

<code>'accent1' | 'accent2' | 'accent3' | 'neutral1' | 'neutral2'</code>


#### MonetTonalPalette

<code>{ [shade in TonalShadeNames]: <a href="#hexcolor">HexColor</a>; }</code>


#### TonalShadeNames

<code>0 | 10 | 50 | 100 | 200 | 300 | 400 | 500 | 600 | 700 | 800 | 900 | 1000</code>


#### HexColor

<code>`#${string}`</code>

</docgen-api>
