package com.nisum.management.controller;

import com.nisum.management.aspect.LoggerMetric;
import com.nisum.management.dto.request.UserActiveRequestDTO;
import com.nisum.management.dto.response.UserResponseDTO;
import com.nisum.management.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@Slf4j
@RestController
@RequestMapping("api/v1/management")
@RequiredArgsConstructor
@PreAuthorize("authenticated")
public class UserController {

    private final UserService userService;

    @LoggerMetric
    @PutMapping(value = "/user/{uuid}/active", produces =  MediaType.APPLICATION_JSON_VALUE , consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<UserResponseDTO> active(@Valid @RequestBody UserActiveRequestDTO request,
                                           @PathVariable UUID uuid) {
        userService.active(request.getActive(), uuid);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
