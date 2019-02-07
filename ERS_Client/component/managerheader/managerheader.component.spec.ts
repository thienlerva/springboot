import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ManagerheaderComponent } from './managerheader.component';

describe('ManagerheaderComponent', () => {
  let component: ManagerheaderComponent;
  let fixture: ComponentFixture<ManagerheaderComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ManagerheaderComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ManagerheaderComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
