import { ComponentFixture, TestBed } from '@angular/core/testing';

import { IscoControls } from './isco-controls';

describe('IscoControls', () => {
  let component: IscoControls;
  let fixture: ComponentFixture<IscoControls>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [IscoControls]
    })
    .compileComponents();

    fixture = TestBed.createComponent(IscoControls);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
