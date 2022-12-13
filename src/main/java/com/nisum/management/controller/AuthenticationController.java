package com.nisum.management.controller;


import com.nisum.management.aspect.LoggerMetric;
import com.nisum.management.dto.request.UserRequestDTO;
import com.nisum.management.dto.response.UserResponseDTO;
import com.nisum.management.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping("api/v1/authentication")
@RequiredArgsConstructor
public class AuthenticationController {

    private final UserService userService;

    @LoggerMetric
    @PostMapping(value = "/signUp", produces =  MediaType.APPLICATION_JSON_VALUE , consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<UserResponseDTO> signUp(@Valid @RequestBody UserRequestDTO request) {
        UserResponseDTO response = userService.create(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @LoggerMetric
    @GetMapping(value = "/signIn", produces =  MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<UserResponseDTO> login(@RequestParam String email,
                                          @RequestParam String password) {
        UserResponseDTO response =  userService.login(email, password);
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }
}
