package com.nisum.management.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PhonesDTO implements Serializable {

    @JsonProperty("number")
    private String number;

    @JsonProperty("cityCode")
    private String cityCode;

    @JsonProperty("countryCode")
    private String countryCode;
}
