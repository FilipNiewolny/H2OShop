import { Component, OnInit } from '@angular/core';
import { Exercise } from '../model/exercise';
import { ExerciseService } from '../service/exercise.service';

@Component({
  selector: 'app-exercise-list',
  templateUrl: './exercise-list.component.html',
  styleUrls: ['./exercise-list.component.css']
})
export class ExerciseListComponent implements OnInit {

  exercises: Exercise[];

  constructor(private exerciseService: ExerciseService) {

  }

  ngOnInit() {
    this.exerciseService.findAll().subscribe(data => {
      this.exercises = data;
    });
  }
}
