import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { weatherApi } from '../models/links';

@Injectable({
  providedIn: 'root'
})
export class WeatherService {

  constructor(private http: HttpClient) { }

  myName(): string {
    return "artur"
  }

  readWeatherForecasts(): any {
    this.http.get(weatherApi)
  }
}
