import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AboutComponent } from './Components/core/about/about.component';
import { AuthorComponent } from './Components/core/author/author.component';
import { HomeComponent } from './Components/core/home/home.component';
import { DepartmanComponent } from './Components/departman/departman.component';
import { FakultetComponent } from './Components/fakultet/fakultet.component';
import { StatusComponent } from './Components/status/status.component';
import { StudentComponent } from './Components/student/student.component';

const routes: Routes = [

  { path: '', redirectTo: '/home', pathMatch: 'full' },
  { path: 'fakultet', component: FakultetComponent },
  { path: 'departman', component: DepartmanComponent },
  { path: 'status', component: StatusComponent },
  { path: 'student', component: StudentComponent },
  { path: 'home', component: HomeComponent },
  { path: 'about', component: AboutComponent },
  { path: 'author', component: AuthorComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
