import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MentorHomepageComponent } from './mentor-homepage.component';
import {Directive} from "@angular/core";

describe('MentorHomepageComponent', () => {
  let component: MentorHomepageComponent;
  let fixture: ComponentFixture<MentorHomepageComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MentorHomepageComponent, MockMentorProposalsDirective,
        MockMatTabGroupDirective, MockMentorDetailsDirective,
      MockMatToolbarDirective, MockMatTabDirective, MockMatCardDirective]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MentorHomepageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

@Directive({
  selector: 'app-mentor-proposals'
})
class MockMentorProposalsDirective {
}

@Directive({
  selector: 'app-mentor-details'
})
class MockMentorDetailsDirective {
}

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
  selector: 'mat-toolbar'
})
class MockMatToolbarDirective {
}

@Directive({
  selector: 'mat-card'
})
class MockMatCardDirective {
}
