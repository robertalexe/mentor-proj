import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UserHomepageComponent } from './user-homepage.component';
import {TrainingsListComponent} from "../trainings-list/trainings-list.component";
import {UserActiveTrainingsComponent} from "../user-active-trainings/user-active-trainings.component";
import {MatFormField} from "@angular/material";
import {Directive} from "@angular/core";

describe('UserHomepageComponent', () => {
  let component: UserHomepageComponent;
  let fixture: ComponentFixture<UserHomepageComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UserHomepageComponent,
      MockAppTrainingsListDirective,
      MockAppActiveTrainingsListDirective]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UserHomepageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('should render title in a h1 tag', async(() => {
    const fixture = TestBed.createComponent(UserHomepageComponent);
    fixture.detectChanges();
    const compiled = fixture.debugElement.nativeElement;
    expect(compiled.querySelector('h1').textContent).toContain('Available Mentors & Trainings');
  }));

  it('should render the active trainings selector', async( () => {
    const fixture = TestBed.createComponent(UserHomepageComponent);
    fixture.detectChanges();
    const compiled = fixture.debugElement.nativeElement;
    expect(compiled.querySelector('app-user-active-trainings')).toBeTruthy();
  }));


});

@Directive({
  selector: 'app-trainings-list'
})
class MockAppTrainingsListDirective {
}

@Directive({
  selector: 'app-user-active-trainings'
})
class MockAppActiveTrainingsListDirective {
}
