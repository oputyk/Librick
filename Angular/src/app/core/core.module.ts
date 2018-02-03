import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { CoreRoutingModule } from './core-routing.module';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';

@NgModule({
  imports: [
    CommonModule,
    CoreRoutingModule
  ],
  declarations: [
    HeaderComponent,
    FooterComponent,
    PageNotFoundComponent
  ],
  exports: [
    CoreRoutingModule,
    HeaderComponent,
    FooterComponent
  ]
})
export class CoreModule { }
