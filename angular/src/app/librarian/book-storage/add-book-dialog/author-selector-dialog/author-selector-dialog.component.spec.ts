import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AuthorSelectorDialogComponent } from './author-selector-dialog.component';

describe('AuthorSelectorDialogComponent', () => {
  let component: AuthorSelectorDialogComponent;
  let fixture: ComponentFixture<AuthorSelectorDialogComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AuthorSelectorDialogComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AuthorSelectorDialogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
