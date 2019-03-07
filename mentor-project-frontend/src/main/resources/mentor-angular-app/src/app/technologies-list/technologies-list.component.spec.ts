import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TechnologiesListComponent } from './technologies-list.component';
import {Directive} from "@angular/core";
import {HttpClientModule} from "@angular/common/http";
import {RouterTestingModule} from "@angular/router/testing";

describe('TechnologiesListComponent', () => {
  let component: TechnologiesListComponent;
  let fixture: ComponentFixture<TechnologiesListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      imports: [
        RouterTestingModule,
        HttpClientModule
      ],
      declarations: [ TechnologiesListComponent, MockMatTabGroupDirective,
        MockMatToolbarDirective, MockMatTabDirective, MockMatCardDirective,
        MockParagraphDirective]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TechnologiesListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  /*it('should create', () => {
    expect(component).toBeTruthy();
  });*/
});

@Directive({
  selector: 'mat-tab-group'
})
class MockMatTabGroupDirective {
}

@Directive({
  selector: 'mat-selection-list'
})
class MockMatTabDirective {
}

@Directive({
  selector: 'mat-list-option'
})
class MockMatToolbarDirective {
}

@Directive({
  selector: 'mat-card'
})
class MockMatCardDirective {
}

@Directive({
  selector: 'p'
})
class MockParagraphDirective {
}
