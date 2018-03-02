import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { DashboardComponent } from './dashboard/dashboard.component';
import {LibrarianRoutingModule} from "./librarian-routing.module";
import {SharedModule} from "../shared/shared.module";

@NgModule({
  imports: [
    CommonModule,
    LibrarianRoutingModule,
    SharedModule
  ],
  declarations: [DashboardComponent]
})
export class LibrarianModule { }
