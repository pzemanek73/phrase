package com.pz.phrase.srvc;

import com.pz.phrase.model.dto.ProjectsRoot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ProjectsServiceImpl implements ProjectsService {

    Logger logger = LoggerFactory.getLogger(ProjectsServiceImpl.class);

    @Autowired
    TokenProvider tokenProvider;

    @Value("${phrase.projects.url}")
    private String projectsUrl;

    @Override
    public ProjectsRoot getProjects() {
        String token = tokenProvider.getToken();

        logger.info("Attempting to get projects");
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.AUTHORIZATION, "ApiToken " + token);
        HttpEntity<Object> entity = new HttpEntity<>(headers);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<ProjectsRoot> response = restTemplate.exchange(projectsUrl, HttpMethod.GET, entity, ProjectsRoot.class);

        return response.getBody();
    }
}
