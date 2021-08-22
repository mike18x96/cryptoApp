package com.example.cryptokrypto.service;

import com.example.cryptokrypto.dto.WeatherDto;
import com.example.cryptokrypto.entity.Weather;
import com.example.cryptokrypto.mapper.WeatherMapper;
import com.example.cryptokrypto.repository.WeatherRepository;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j

public class WeatherService {

    //private static final Logger logg = LoggerFactory.getLogger(WeatherService.class); // to samo co @Slf4j

    private WeatherRepository weatherRepository;
    private WeatherMapper mapper;

    public WeatherService(final WeatherRepository weatherRepository,
                          final WeatherMapper mapper) {
        this.weatherRepository = weatherRepository;
        this.mapper=mapper;
    }

    //CRUD
    public List<WeatherDto> getAllWeather(){
        var objectFromRepo=weatherRepository.findAll();
        log.info("weathers from repo: {}", objectFromRepo);

        return objectFromRepo
                .stream()
                .map(weather -> mapper.fromEntityToDto(weather))
                .collect(Collectors.toList());
    }
}
