import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MentorDetailsComponent } from './mentor-details.component';
import {Directive} from "@angular/core";
import {HttpClientModule} from "@angular/common/http";

describe('MentorDetailsComponent', () => {
  let component: MentorDetailsComponent;
  let fixture: ComponentFixture<MentorDetailsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MentorDetailsComponent,
        MockMatTabGroupDirective,
      MockMatTabDirective,
      MockMatToolbarDirective,
        MockMatCardDirective],
      imports: [HttpClientModule]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MentorDetailsComponent);
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
  selector: 'mat-toolbar'
})
class MockMatToolbarDirective {
}

@Directive({
  selector: 'mat-card'
})
class MockMatCardDirective {
}
