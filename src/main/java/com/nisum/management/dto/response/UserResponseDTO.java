package com.nisum.management.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nisum.management.dto.request.UserRequestDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserResponseDTO {

    @JsonProperty("id")
    private UUID id;

    @JsonProperty("user")
    private UserRequestDTO user;

    @JsonProperty("created")
    private LocalDate created;

    @JsonProperty("modified")
    private LocalDate modified;

    @JsonProperty("lastLogin")
    private LocalDate lastLogin;

    @JsonProperty("token")
    private String token;

    @JsonProperty("isActive")
    private Boolean isActive;
}
