import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { BootstrapFormatComponent } from './bootstrap-format/bootstrap-format.component';

const routes: Routes = [
  {path: '', component: BootstrapFormatComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
