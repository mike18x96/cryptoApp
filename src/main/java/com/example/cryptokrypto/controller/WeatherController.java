package com.example.cryptokrypto.controller;

import com.example.cryptokrypto.dto.WeatherDto;
import com.example.cryptokrypto.service.WeatherService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api")

@Slf4j
public class WeatherController {

    private WeatherService weatherService;

    public WeatherController(final WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/weathers")
    public List<WeatherDto> getAll() {
        log.info("getAll");
        return weatherService.getAllWeathers();
    }

    // /weathers/1
    // /weathers/99
    @GetMapping("/weathers/{id}")
    public ResponseEntity<WeatherDto>  getWeatherById(@PathVariable("id") Long id) {
        log.info("getWeatherById: [{}]", id);
        var result = weatherService.findWeatherById(id);

        if (result.isPresent()) {
            return new ResponseEntity<>(result.get(), HttpStatus.OK);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/weathers")
    public ResponseEntity<WeatherDto> createWeatherForecast(@RequestBody WeatherDto newWeather) {
        log.info("trying to create new weather forecast: [{}]", newWeather);
//        return new ResponseEntity<>(weatherService.createNewWeatherForecast(newWeather), HttpStatus.CREATED);
        var body = weatherService.createNewWeatherForecast(newWeather);

//        MultiValueMap<String, String> headers = new HttpHeaders();
//        headers.add(HttpHeaders.LOCATION, "/api/weathers/" + body.id());
//        new ResponseEntity<WeatherDto>(body, headers, HttpStatus.CREATED);

        return ResponseEntity.created(URI.create("/api/weathers/" + body.id())).body(body);
    }

}
