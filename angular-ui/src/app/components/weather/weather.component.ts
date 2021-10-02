import {Component, OnInit} from '@angular/core';
import {WeatherService} from "../../services/weather.service";

@Component({
  selector: 'app-weather',
  templateUrl: './weather.component.html',
  styleUrls: ['./weather.component.css']
})
export class WeatherComponent implements OnInit {
  name: string = ""
  response: any | null

  constructor(private weatherService: WeatherService) {
  }

  ngOnInit(): void {
    this.name = this.weatherService.myName()
    this.weatherService.readWeatherForecasts()
      .subscribe(value => {
        this.response = value
        console.log(`received value: ${value}`)
      })
    console.log('ngOnInit completed');
  }

}
