package com.nisum.management.service.impl;

import com.nisum.management.dto.PhonesDTO;
import com.nisum.management.dto.request.UserRequestDTO;
import com.nisum.management.dto.response.UserResponseDTO;
import com.nisum.management.exception.EmailDuplicatedException;
import com.nisum.management.exception.UserNotFoundException;
import com.nisum.management.mapper.PhoneMapper;
import com.nisum.management.mapper.UserMapper;
import com.nisum.management.model.PhoneModel;
import com.nisum.management.model.UserModel;
import com.nisum.management.repository.PhoneRepository;
import com.nisum.management.repository.UserRepository;
import com.nisum.management.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final PhoneRepository phoneRepository;

    private final UserMapper userMapper;

    private final PhoneMapper phoneMapper;

    @Override
    public UserResponseDTO create(UserRequestDTO dto) {
        validateEmail(dto.getEmail());
        UserModel user = userRepository.save(userMapper.toModel(dto));
        List<PhoneModel> phone = persistencePhone(dto,user);
        return userMapper.toDto(user,phone);
    }

    @Override
    public UserResponseDTO login(String email, String password) {
        Optional<UserModel> optional = userRepository.findByEmailAndPassword(email, password);
        if(optional.isEmpty()){
            throw new UserNotFoundException("user not found");
        }
        UserModel model = optional.get();
        model.setLastLogin(LocalDate.now());
        userRepository.save(model);
        return userMapper.toDto(model);

    }

    @Override
    public void active(Boolean active, UUID id) {
     Optional<UserModel> optional = userRepository.findById(id);
        if(optional.isEmpty()){
            throw new UserNotFoundException("user not found");
        }
        UserModel model = optional.get();
        model.setIsActive(active);
        userRepository.save(model);
    }


    private void validateEmail(String email){
        if (userRepository.existsByEmail(email)) {
            throw new EmailDuplicatedException("The mail already registered");
        }
    }

    private List<PhoneModel> persistencePhone(UserRequestDTO dto, UserModel user) {
        List<PhoneModel> response = new ArrayList<>();
        for (PhonesDTO phone : dto.getPhones()){
            response.add( phoneRepository.save(phoneMapper.toModel(phone,user)));
        }
        return response;
    }
}
