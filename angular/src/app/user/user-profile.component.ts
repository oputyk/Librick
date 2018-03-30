import { Component, OnInit } from '@angular/core';
import {MatDialog, MatSnackBar} from "@angular/material";
import {ChangePasswordDialogComponent} from "./change-password-dialog/change-password-dialog.component";
import {isNullOrUndefined} from "util";
import {Observable} from "rxjs/Observable";

@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.scss']
})
export class UserProfileComponent implements OnInit {

  constructor(public dialog: MatDialog, public snackBar: MatSnackBar) { }

  ngOnInit() {
  }

  showChangePasswordDialog() {

    const dialogRef = this.dialog.open(ChangePasswordDialogComponent);

    dialogRef.afterClosed().subscribe((result: Observable<boolean>) => {
      if(!isNullOrUndefined(result)) {
        result.subscribe((ok: boolean) => {
          if(ok) {
            this.snackBar.open("Success!", "Change password", {
              duration: 2000
            });
          } else {
            this.snackBar.open("Failure", "Change password", {
              duration: 2000
            });
          }
        })
      }
    });
  }

}
