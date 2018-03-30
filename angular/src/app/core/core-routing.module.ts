import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {PageNotFoundComponent} from "./page-not-found/page-not-found.component";
import {LoginComponent} from "./login/login.component";
import {AuthGuard} from "./guards/auth.guard";
import {RegisterLibrarianComponent} from "./register-librarian/register-librarian.component";
import {UserProfileComponent} from "../user/user-profile.component";

const routes: Routes = [
  {
    path: 'librarian',
    canActivate: [AuthGuard],
    loadChildren: '../librarian/librarian.module#LibrarianModule'
  },
  {
    path: 'user',
    canActivate: [AuthGuard],
    loadChildren: '../user/user.module#UserModule'
  },
  {
    path: '',
    loadChildren: '../public/public.module#PublicModule'
  },
  {
    path: 'login',
    pathMatch: 'full',
    component: LoginComponent
  },
  {
    path: 'register-librarian',
    pathMatch: 'full',
    component: RegisterLibrarianComponent
  },
  { path: "**", component: PageNotFoundComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class CoreRoutingModule { }
