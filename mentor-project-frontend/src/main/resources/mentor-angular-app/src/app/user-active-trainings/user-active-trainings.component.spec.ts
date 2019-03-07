import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UserActiveTrainingsComponent } from './user-active-trainings.component';

describe('UserActiveTrainingsComponent', () => {
  let component: UserActiveTrainingsComponent;
  let fixture: ComponentFixture<UserActiveTrainingsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UserActiveTrainingsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UserActiveTrainingsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  /*it('should create', () => {
    expect(component).toBeTruthy();
  });*/
});
