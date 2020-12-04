import { SortByPipe } from './pipes/sort-by.pipe';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';



@NgModule({
  declarations: [
    SortByPipe
  ],
  imports: [
    CommonModule
  ],
  exports: [
    SortByPipe
  ],
})
export class SharedModuleModule { }
