import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ExerciseService } from '../service/exercise.service';
import { Exercise } from '../model/exercise';

@Component({
  selector: 'app-exercise-form',
  templateUrl: './exercise-form.component.html',
  styleUrls: ['./exercise-form.component.css']
})
export class ExerciseFormComponent {


  exercise: Exercise;

  constructor(private route: ActivatedRoute, private router: Router, private exerciseService: ExerciseService) {
    this.exercise = new Exercise();
  }

  onSubmit() {

  //  console.log(this.exercise)
    this.exerciseService.save(this.exercise).subscribe(result => this.gotoExerciseList());
  }

  gotoExerciseList() {
    this.router.navigate(['/exercises']);
  }
}
