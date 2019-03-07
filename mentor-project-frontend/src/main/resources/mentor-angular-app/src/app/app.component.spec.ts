import { TestBed, async } from '@angular/core/testing';
import { RouterTestingModule } from '@angular/router/testing';
import { AppComponent } from './app.component';
import {Directive} from "@angular/core";
import {HttpClientModule} from "@angular/common/http";

describe('AppComponent', () => {
  beforeEach(async(() => {
    TestBed.configureTestingModule({
      imports: [
        RouterTestingModule,
        HttpClientModule
      ],
      declarations: [
        AppComponent,
        MockMatTabGroupDirective,
        MockMatTabDirective,
        MockMatToolbarDirective
      ]
    }).compileComponents();
  }));

  it('should create the app', () => {
    const fixture = TestBed.createComponent(AppComponent);
    const app = fixture.debugElement.componentInstance;
    expect(app).toBeTruthy();
  });

  it(`should have as title 'mentor-angular-app'`, () => {
    const fixture = TestBed.createComponent(AppComponent);
    const app = fixture.debugElement.componentInstance;
    expect(app.title).toEqual('mentor-angular-app');
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
