import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EditBookDialogComponent } from './edit-book-dialog.component';

describe('EditBookDialogComponent', () => {
  let component: EditBookDialogComponent;
  let fixture: ComponentFixture<EditBookDialogComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EditBookDialogComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EditBookDialogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
