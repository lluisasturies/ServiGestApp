import { SortByPipe } from './pipes/sort-by.pipe';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { UppercaseInputDirective } from './directives/uppercase-input.directive';



@NgModule({
  declarations: [
    SortByPipe, 
    UppercaseInputDirective
  ],
  imports: [
    CommonModule
  ],
  exports: [
    SortByPipe, 
    UppercaseInputDirective
  ],
})
export class SharedModuleModule { }
