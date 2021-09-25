package com.example.cryptokrypto.service;


import com.example.cryptokrypto.dto.GithubRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
@Slf4j
public class GithubService implements CommandLineRunner {

    private final RestTemplate restTemplate;
    private final String githubUrl;

    public GithubService(RestTemplate restTemplate,
                         @Value("https://api.github.com/orgs/oracle/repos") String githubUrl) {
        this.restTemplate = restTemplate;
        this.githubUrl = githubUrl;

        log.info("github url: [{}]", githubUrl);
    }

    public List<GithubRepository> readGitHubRepos() {
        var responseFromServer = restTemplate.getForObject(githubUrl, GithubRepository[].class);
        var result = Arrays.asList(responseFromServer);
        log.info("result: {}", result);

        return result;
    }

    @Override
    public void run(String... args) throws Exception {
        readGitHubRepos();
    }
}
