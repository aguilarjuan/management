package com.nisum.management.mapper;

import com.nisum.management.dto.PhonesDTO;
import com.nisum.management.model.PhoneModel;
import com.nisum.management.model.UserModel;

public interface PhoneMapper {

    PhoneModel toModel(PhonesDTO dto, UserModel user);

    PhonesDTO toDto(PhoneModel model);

}
