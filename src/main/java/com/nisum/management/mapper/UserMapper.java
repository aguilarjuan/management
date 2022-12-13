package com.nisum.management.mapper;

import com.nisum.management.dto.request.UserRequestDTO;
import com.nisum.management.dto.response.UserResponseDTO;
import com.nisum.management.model.PhoneModel;
import com.nisum.management.model.UserModel;

import java.util.List;

public interface UserMapper {

    UserModel toModel(UserRequestDTO dto);

    UserResponseDTO toDto(UserModel model, List<PhoneModel> phone);

    UserResponseDTO toDto(UserModel model);


}
