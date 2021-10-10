import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';

@Component({
  selector: 'app-weather-form',
  templateUrl: './weather-form.component.html',
  styleUrls: ['./weather-form.component.css']
})
export class WeatherFormComponent implements OnInit {
  weatherForm = new FormGroup({
    city: new FormControl(''),
    temp: new FormControl('')
  })

  constructor() { }

  ngOnInit(): void {
  }

  onSubmit() {
    console.log('submiting data to server...')
    console.log(this.weatherForm.value)
  }
}
