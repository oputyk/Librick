import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {PageNotFoundComponent} from "./page-not-found/page-not-found.component";
import {LoginComponent} from "./login/login.component";
import {AuthGuard} from "./guards/auth.guard";

const routes: Routes = [
  {
    path: 'librarian',
    canActivate: [AuthGuard],
    loadChildren: '../librarian/librarian.module#LibrarianModule'
  },
  {
    path: '',
    loadChildren: '../public/public.module#PublicModule'
  },
  {
    path: 'login',
    component: LoginComponent
  },
  { path: "**", component: PageNotFoundComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class CoreRoutingModule { }
