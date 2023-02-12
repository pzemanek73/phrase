package com.pz.phrase.cntrl;

import com.pz.phrase.model.dto.ProjectsRoot;
import com.pz.phrase.srvc.ProjectsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestAPIController {

    @Autowired
    private ProjectsService projectService;

    @GetMapping("/v1/projects")
    public ResponseEntity<ProjectsRoot> v1_Projects() {

        ProjectsRoot pr = projectService.getProjects();
        ResponseEntity<ProjectsRoot> response = new ResponseEntity<>(pr, HttpStatus.OK);

        return response;
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleErrors(Exception exception) {
        return new ResponseEntity<>(new RuntimeException(String.format("Application Error: %s, %s", exception.getMessage(), exception.getCause())), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
