import { enableProdMode } from '@angular/core';
import { disableDebugTools } from '@angular/platform-browser';
import { platformBrowserDynamic } from '@angular/platform-browser-dynamic';

import { AppModule } from './app/app.module';
import { environment } from './environments/environment';


disableDebugTools();

platformBrowserDynamic().bootstrapModule(AppModule)
  .catch(err => console.error(err));
