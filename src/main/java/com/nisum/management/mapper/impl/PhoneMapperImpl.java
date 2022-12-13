package com.nisum.management.mapper.impl;

import com.nisum.management.dto.PhonesDTO;
import com.nisum.management.mapper.PhoneMapper;
import com.nisum.management.model.PhoneModel;
import com.nisum.management.model.UserModel;
import org.springframework.stereotype.Component;

@Component
public class PhoneMapperImpl implements PhoneMapper {


    @Override
    public PhoneModel toModel(PhonesDTO dto, UserModel user) {

        PhoneModel model = new PhoneModel();

        model.setNumber(dto.getNumber());
        model.setCountryCode(dto.getCountryCode());
        model.setCityCode(dto.getCityCode());

        model.setUser(user);

        return model;

    }

    @Override
    public PhonesDTO toDto(PhoneModel model) {

        PhonesDTO dto = new PhonesDTO();

        dto.setNumber(model.getNumber());
        dto.setCountryCode(model.getCountryCode());
        dto.setCityCode(model.getCityCode());

        return dto;
    }
}
