import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ReimbursementformComponent } from './reimbursementform.component';

describe('ReimbursementformComponent', () => {
  let component: ReimbursementformComponent;
  let fixture: ComponentFixture<ReimbursementformComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ReimbursementformComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ReimbursementformComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
