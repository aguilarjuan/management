package com.nisum.management.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserCredentialRequestDTO implements Serializable {

    @JsonProperty("email")
    @NotBlank(message = "The email is required.")
    private String email;

    @JsonProperty("password")
    @NotBlank(message = "The password is required.")
    private String password;
}
