import { registerPlugin } from '@capacitor/core';

import { MonetController } from './controller';
import type { MonetPlugin } from './definitions';

const Monet = registerPlugin<MonetPlugin>('Monet', {
  web: () => import('./web').then(m => new m.MonetWeb()),
});

const controller = new MonetController(Monet);

export * from './definitions';
export { Monet };
export { controller as MonetController };
