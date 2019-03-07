import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminHomepageComponent } from './admin-homepage.component';
import {Directive} from "@angular/core";
import {MatTab, MatTabBody, MatTabGroup, MatTabHeader} from "@angular/material";

describe('AdminHomepageComponent', () => {
  let component: AdminHomepageComponent;
  let fixture: ComponentFixture<AdminHomepageComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AdminHomepageComponent,
        MockAppTTechnologiesListDirective,
        MockAppUsersListDirective,
        MockMatTabGroupDirective,
        MockMatTabDirective,
        MockMatToolbarDirective]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminHomepageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

@Directive({
  selector: 'app-technologies-list'
})
class MockAppTTechnologiesListDirective {
}

@Directive({
  selector: 'app-users-list'
})
class MockAppUsersListDirective {
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
