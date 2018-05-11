import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BookSelectorDialogComponent } from './book-selector-dialog.component';

describe('BookSelectorDialogComponent', () => {
  let component: BookSelectorDialogComponent;
  let fixture: ComponentFixture<BookSelectorDialogComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BookSelectorDialogComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BookSelectorDialogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
