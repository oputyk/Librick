import {Component, Inject, OnInit} from '@angular/core';
import {MatDialogRef, MatFormField} from "@angular/material";
import {ChangePasswordDialogService} from "./change-password-dialog.service";

@Component({
  selector: 'app-change-password-dialog',
  templateUrl: './change-password-dialog.component.html',
  styleUrls: ['./change-password-dialog.component.scss'],
  providers: [ChangePasswordDialogService]
})
export class ChangePasswordDialogComponent implements OnInit {

  oldPassword: string = "";
  newPassword: string = "";
  repeatedNewPassword: string = "";

  constructor(public dialogRef: MatDialogRef<ChangePasswordDialogComponent>,
              private service: ChangePasswordDialogService) { }

  ngOnInit() {
  }

  changePasswordButtonPressed() {
    if(this.newPassword == this.repeatedNewPassword) {
      this.dialogRef.close(this.service.changePassword(this.oldPassword, this.newPassword));
    }
  }

}
