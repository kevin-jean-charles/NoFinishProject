import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LibraryListEditorComponent } from './library-list-editor.component';

describe('LibraryListEditorComponent', () => {
  let component: LibraryListEditorComponent;
  let fixture: ComponentFixture<LibraryListEditorComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ LibraryListEditorComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(LibraryListEditorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
