import { NgModule } from '@angular/core';
import {
  MatButtonModule, MatCardModule, MatFormFieldModule, MatIconModule, MatMenuModule,
  MatToolbarModule, MatInputModule, MatDividerModule, MatSidenavModule, MatDialogModule, MatSnackBarModule,
  MatTableModule, MatPaginatorModule, MatTooltipModule, MatDatepickerModule
} from "@angular/material";
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import {MatMomentDateModule} from "@angular/material-moment-adapter";

@NgModule({
  imports: [
    MatButtonModule,
    MatMenuModule,
    MatToolbarModule,
    MatIconModule,
    MatCardModule,
    MatFormFieldModule,
    MatInputModule,
    MatDividerModule,
    MatSidenavModule,
    MatDialogModule,
    MatSnackBarModule,
    MatTableModule,
    MatPaginatorModule,
    MatTooltipModule,
    MatDatepickerModule,
    MatMomentDateModule
  ],
  exports: [
    MatButtonModule,
    MatMenuModule,
    MatToolbarModule,
    MatIconModule,
    MatCardModule,
    MatFormFieldModule,
    MatInputModule,
    MatDividerModule,
    MatSidenavModule,
    MatDialogModule,
    MatSnackBarModule,
    MatTableModule,
    MatPaginatorModule,
    MatTooltipModule,
    MatDatepickerModule,
    MatMomentDateModule
  ]
})
export class MaterialModule { }
