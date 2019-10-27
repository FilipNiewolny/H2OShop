import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ExerciseListComponent } from './exercise-list/exercise-list.component';
import { ExerciseFormComponent } from './exercise-form/exercise-form.component';

const routes: Routes = [
  { path: 'exercises', component: ExerciseListComponent },
  { path: 'addexercise', component: ExerciseFormComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})

export class AppRoutingModule { }
