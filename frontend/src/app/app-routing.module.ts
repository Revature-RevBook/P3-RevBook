import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { BootstrapFormatComponent } from './bootstrap-format/bootstrap-format.component';
import { LoginComponent } from './login/login.component';

const routes: Routes = [
  {path: '', component: BootstrapFormatComponent},
    {path: 'login', component: LoginComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
