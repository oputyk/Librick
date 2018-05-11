import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EditAuthorDialogComponent } from './edit-author-dialog.component';

describe('EditAuthorDialogComponent', () => {
  let component: EditAuthorDialogComponent;
  let fixture: ComponentFixture<EditAuthorDialogComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EditAuthorDialogComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EditAuthorDialogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
