package com.JPA.onlineExam.controllertest;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

@RestController
@RequestMapping("/monitoring/")
public class MonitoringController {
    @Autowired
    private RequestMappingHandlerMapping requestMappingHandlerMapping;

    @GetMapping("endpoints")
    public ResponseEntity<List<String>> getEndpoints() {
        return new ResponseEntity<>(
                requestMappingHandlerMapping
                        .getHandlerMethods()
                        .keySet()
                        .stream()
                        .map(RequestMappingInfo::toString)
                        .collect(Collectors.toList()),
                HttpStatus.OK
        );
    }
   
    @GetMapping ( value = "endpointlink", produces = {MediaType.ALL_VALUE})
    public ResponseEntity<List<String>> getallEndpointshttps() {
    	return new ResponseEntity<>(
    	requestMappingHandlerMapping
        .getHandlerMethods()
        .keySet()
        .stream()
        .map(RequestMappingInfo::toString)
//        .forEach(x -> "<br>" + x + "br")
        .collect(Collectors.toList()),
        HttpStatus.OK
        );
    }
}