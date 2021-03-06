import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { DashboardComponent } from './dashboard/dashboard.component';
import {RouterModule, Routes} from "@angular/router";
import {BookStorageComponent} from "./book-storage/book-storage.component";
import {AuthorStorageComponent} from "./authors/author-storage.component";

const routes: Routes = [
  {
    path: '',
    pathMatch: 'full',
    redirectTo: 'dashboard'
  },
  {
    path: 'dashboard',
    pathMatch: 'full',
    component: DashboardComponent
  },
  {
    path: 'book-storage',
    pathMatch: 'full',
    component: BookStorageComponent
  },
  {
    path: 'authors',
    pathMatch: 'full',
    component: AuthorStorageComponent
  }
];

@NgModule({
  imports: [
    RouterModule.forChild(routes)
  ],
  exports: [
    RouterModule
  ]
})
export class LibrarianRoutingModule { }
