import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TrainingsListComponent } from './trainings-list.component';
import {Directive} from "@angular/core";

describe('TrainingsListComponent', () => {
  let component: TrainingsListComponent;
  let fixture: ComponentFixture<TrainingsListComponent>;
  let mockDatasource;

  beforeEach(async(() => {
    mockDatasource = [];
    TestBed.configureTestingModule({
      declarations: [ TrainingsListComponent, MockMatTabGroupDirective,
        MockMatToolbarDirective, MockMatTabDirective, MockMatCardDirective ],
      providers: [{dataSource: mockDatasource}]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TrainingsListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  /*it('should create', () => {
    expect(component).toBeTruthy();
  });*/
});

@Directive({
  selector: 'mat-form-field'
})
class MockMatTabGroupDirective {
}

@Directive({
  selector: 'mat-table'
})
class MockMatTabDirective {
}

@Directive({
  selector: 'mat-paginator'
})
class MockMatToolbarDirective {
}

@Directive({
  selector: 'mat-card'
})
class MockMatCardDirective {
}
