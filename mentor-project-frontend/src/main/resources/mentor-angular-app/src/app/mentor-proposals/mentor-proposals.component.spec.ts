import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MentorProposalsComponent } from './mentor-proposals.component';
import {Directive} from "@angular/core";
import {HttpClientModule} from "@angular/common/http";
import {MatSnackBar, MatSnackBarModule} from "@angular/material";

describe('MentorProposalsComponent', () => {
  let component: MentorProposalsComponent;
  let fixture: ComponentFixture<MentorProposalsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MentorProposalsComponent,
        MockMatTabGroupDirective,
        MockMatToolbarDirective, MockMatTabDirective, MockMatCardDirective],
      imports: [HttpClientModule, MatSnackBarModule]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MentorProposalsComponent);
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
