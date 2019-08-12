package com.ctest.core.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ctest.helpers.ResponseCanonical;

@RestController
public class RootController {
	@GetMapping(path="/heart-beat", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseCanonical<String> heartBeat() {
        return new ResponseCanonical<String>("OK");
    }
}
