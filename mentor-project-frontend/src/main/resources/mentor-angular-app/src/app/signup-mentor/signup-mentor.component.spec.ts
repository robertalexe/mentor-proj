import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SignupMentorComponent } from './signup-mentor.component';
import {ReactiveFormsModule} from "@angular/forms";
import {RouterModule} from "@angular/router";
import {HttpClientModule} from "@angular/common/http";
import {Directive} from "@angular/core";

describe('SignupMentorComponent', () => {
  let component: SignupMentorComponent;
  let fixture: ComponentFixture<SignupMentorComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SignupMentorComponent, MockMatTabGroupDirective,
        MockMatToolbarDirective, MockMatTabDirective, MockMatCardDirective ],
      imports: [ ReactiveFormsModule, RouterModule.forRoot([]), HttpClientModule ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SignupMentorComponent);
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
