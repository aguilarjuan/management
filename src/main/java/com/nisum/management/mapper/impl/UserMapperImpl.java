package com.nisum.management.mapper.impl;

import com.nisum.management.dto.PhonesDTO;
import com.nisum.management.dto.request.UserRequestDTO;
import com.nisum.management.dto.response.UserResponseDTO;
import com.nisum.management.mapper.PhoneMapper;
import com.nisum.management.mapper.UserMapper;
import com.nisum.management.model.PhoneModel;
import com.nisum.management.model.UserModel;
import com.nisum.management.service.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class UserMapperImpl implements UserMapper {

    private final PhoneMapper phoneMapper;

    private final JwtService jwtService;

    private final String ROLE = "USER";

    @Override
    public UserModel toModel(UserRequestDTO dto) {

        UserModel model = new UserModel();

        model.setName(dto.getName());
        model.setEmail(dto.getEmail());
        model.setPassword(dto.getPassword());

        model.setIsActive(true);

        model.setLastLogin(LocalDate.now());

        model.setToken(jwtService.create(dto.getEmail()));

        model.setRole(ROLE);

        return model;
    }

    @Override
    public UserResponseDTO toDto(UserModel model, List<PhoneModel> phone) {

        UserResponseDTO dto = new UserResponseDTO();

        dto.setId(model.getId());

        dto.setToken(model.getToken());
        dto.setIsActive(model.getIsActive());
        dto.setCreated(model.getCreated());
        dto.setModified(model.getModified());
        dto.setLastLogin(model.getLastLogin());

        UserRequestDTO userDto = new UserRequestDTO();

        userDto.setName(model.getName());
        userDto.setEmail(model.getEmail());
        userDto.setPassword(model.getPassword());
        userDto.setPhones(phonesDTOS(phone));

        dto.setUser(userDto);

        return dto;
    }

    @Override
    public UserResponseDTO toDto(UserModel model) {

        UserResponseDTO dto = new UserResponseDTO();

        dto.setId(model.getId());

        dto.setToken(model.getToken());
        dto.setIsActive(model.getIsActive());
        dto.setCreated(model.getCreated());
        dto.setModified(model.getModified());
        dto.setLastLogin(model.getLastLogin());

        UserRequestDTO userDto = new UserRequestDTO();

        userDto.setName(model.getName());
        userDto.setEmail(model.getEmail());
        userDto.setPassword(model.getPassword());
        userDto.setPhones(phonesDTOS(model.getPhone()));

        dto.setUser(userDto);

        return dto;
    }

    private List<PhonesDTO> phonesDTOS(List<PhoneModel> models){
        List<PhonesDTO> dtoList = new ArrayList<>();
        models.forEach(model -> dtoList.add(phoneMapper.toDto(model)));
        return dtoList;
    }
}
