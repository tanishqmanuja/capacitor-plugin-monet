import { registerPlugin } from '@capacitor/core';

import type { MonetPlugin } from './definitions';

const Monet = registerPlugin<MonetPlugin>('Monet', {
  web: () => import('./web').then(m => new m.MonetWeb()),
});

export * from './definitions';
export { Monet };
