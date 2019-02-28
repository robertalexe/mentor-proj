import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MentorHomepageComponent } from './mentor-homepage.component';

describe('MentorHomepageComponent', () => {
  let component: MentorHomepageComponent;
  let fixture: ComponentFixture<MentorHomepageComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MentorHomepageComponent ]
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
