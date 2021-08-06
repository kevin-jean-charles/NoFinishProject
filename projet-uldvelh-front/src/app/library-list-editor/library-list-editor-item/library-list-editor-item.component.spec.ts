import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LibraryListEditorItemComponent } from './library-list-editor-item.component';

describe('LibraryListEditorItemComponent', () => {
  let component: LibraryListEditorItemComponent;
  let fixture: ComponentFixture<LibraryListEditorItemComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ LibraryListEditorItemComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(LibraryListEditorItemComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
