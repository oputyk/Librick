import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BookStorageComponent } from './book-storage.component';

describe('BookStorageComponent', () => {
  let component: BookStorageComponent;
  let fixture: ComponentFixture<BookStorageComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BookStorageComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BookStorageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
