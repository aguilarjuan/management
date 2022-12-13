package com.nisum.management.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nisum.management.annotation.Password;
import com.nisum.management.dto.PhonesDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserRequestDTO implements Serializable {

    @JsonProperty("name")
    @NotBlank(message = "The name is required.")
    private String name;

    @JsonProperty("email")
    @NotBlank(message = "The email is required.")
    @Email(message = "The email address is invalid.", flags = { Pattern.Flag.CASE_INSENSITIVE })
    private String email;

    @JsonProperty("password")
    @NotBlank(message = "The password is required.")
    @Password
    private String password;

    @JsonProperty("phones")
    private List<PhonesDTO> phones;
}
