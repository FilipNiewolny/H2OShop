import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Exercise } from '../model/exercise';
import { Observable } from 'rxjs';

@Injectable()
export class ExerciseService {

  private exerciseUrl: string;

  constructor(private http: HttpClient) {
    this.exerciseUrl = 'http://localhost:8090/exercise';
  }

  public findAll(): Observable<Exercise[]> {
    return this.http.get<Exercise[]>(this.exerciseUrl);
  }

  public save(exercise: Exercise) {
    return this.http.post<Exercise>(this.exerciseUrl, exercise);
  }
}
