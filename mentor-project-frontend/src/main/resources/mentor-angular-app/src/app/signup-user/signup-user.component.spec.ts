import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SignupUserComponent } from './signup-user.component';
import {SignupMentorComponent} from "../signup-mentor/signup-mentor.component";
import {ReactiveFormsModule} from "@angular/forms";
import {RouterModule} from "@angular/router";
import {HttpClientModule} from "@angular/common/http";
import {Directive} from "@angular/core";

describe('SignupUserComponentComponent', () => {
  let component: SignupUserComponent;
  let fixture: ComponentFixture<SignupUserComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SignupUserComponent, MockMatTabGroupDirective,
        MockMatToolbarDirective, MockMatTabDirective, MockMatCardDirective ],
      imports: [ ReactiveFormsModule, RouterModule.forRoot([]), HttpClientModule ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SignupUserComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

@Directive({
  selector: 'mat-tab-group'
})
class MockMatTabGroupDirective {
}

@Directive({
  selector: 'mat-tab'
})
class MockMatTabDirective {
}

@Directive({
  selector: 'mat-divider'
})
class MockMatToolbarDirective {
}

@Directive({
  selector: 'mat-card'
})
class MockMatCardDirective {
}

