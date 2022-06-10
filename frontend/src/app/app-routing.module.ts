import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { BootstrapFormatComponent } from './bootstrap-format/bootstrap-format.component';
import { RegisterComponent } from './components/register/register.component';

const routes: Routes = [
  {path: '', component: BootstrapFormatComponent},
  {path: 'register', component : RegisterComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
