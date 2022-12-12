import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ComplaintAllComponent } from './complaint-all.component';

describe('ComplaintAllComponent', () => {
  let component: ComplaintAllComponent;
  let fixture: ComponentFixture<ComplaintAllComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ComplaintAllComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ComplaintAllComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
