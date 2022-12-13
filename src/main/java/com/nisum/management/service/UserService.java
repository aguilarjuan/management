package com.nisum.management.service;

import com.nisum.management.dto.request.UserRequestDTO;
import com.nisum.management.dto.response.UserResponseDTO;

import java.util.UUID;

public interface UserService {

    UserResponseDTO create(UserRequestDTO request);
    UserResponseDTO login(String email, String password);

    void active(Boolean active, UUID id);
}
