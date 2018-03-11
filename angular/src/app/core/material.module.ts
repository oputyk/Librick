import { NgModule } from '@angular/core';
import {
  MatButtonModule, MatCardModule, MatFormFieldModule, MatIconModule, MatMenuModule,
  MatToolbarModule, MatInputModule, MatDividerModule
} from "@angular/material";
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";

@NgModule({
  imports: [
    MatButtonModule,
    MatMenuModule,
    MatToolbarModule,
    MatIconModule,
    MatCardModule,
    MatFormFieldModule,
    MatInputModule,
    BrowserAnimationsModule,
    MatDividerModule
  ],
  exports: [
    MatButtonModule,
    MatMenuModule,
    MatToolbarModule,
    MatIconModule,
    MatCardModule,
    MatFormFieldModule,
    MatInputModule,
    BrowserAnimationsModule,
    MatDividerModule
  ]
})
export class MaterialModule { }
