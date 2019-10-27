import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { AppComponent } from './app.component';
import { ExerciseListComponent } from './exercise-list/exercise-list.component';
import { ExerciseFormComponent } from './exercise-form/exercise-form.component';
import { ExerciseService } from './service/exercise.service';

@NgModule({
  declarations: [
    AppComponent,
    ExerciseListComponent,
    ExerciseFormComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [ExerciseService],
  bootstrap: [AppComponent]
})
export class AppModule { }
