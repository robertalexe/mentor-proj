import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MentorProposalsComponent } from './mentor-proposals.component';

describe('MentorProposalsComponent', () => {
  let component: MentorProposalsComponent;
  let fixture: ComponentFixture<MentorProposalsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MentorProposalsComponent ]
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
