import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LibraryListPlayerComponent } from './library-list-player.component';

describe('LibraryListPlayerComponent', () => {
  let component: LibraryListPlayerComponent;
  let fixture: ComponentFixture<LibraryListPlayerComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ LibraryListPlayerComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(LibraryListPlayerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
