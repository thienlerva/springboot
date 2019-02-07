import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdatereimbursementComponent } from './updatereimbursement.component';

describe('UpdatereimbursementComponent', () => {
  let component: UpdatereimbursementComponent;
  let fixture: ComponentFixture<UpdatereimbursementComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UpdatereimbursementComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UpdatereimbursementComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
