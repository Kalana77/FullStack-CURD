package com.example.fullstackcurd.service.impl;

import com.example.fullstackcurd.dto.requestDTO.UserSaveRequestDTO;
import com.example.fullstackcurd.dto.responseDTO.UserSaveResponseDTO;
import com.example.fullstackcurd.entity.User;
import com.example.fullstackcurd.repository.UserRepo;
import com.example.fullstackcurd.service.UserService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceIMPL implements UserService {

    @Autowired
    public UserRepo userRepo;

    @Autowired
    public ModelMapper modelMapper;

    @Override
    public String addUser(UserSaveRequestDTO userSaveRequestDTO) {
        User user = new User(
                userSaveRequestDTO.getName(),
                userSaveRequestDTO.getEmail(),
                true
        );

        userRepo.save(user);
        return user.getName()+" add user";
    }

    @Override
    public List<UserSaveResponseDTO> getUser() {
        List<User> users = userRepo.findAll();
        List<UserSaveResponseDTO> userSaveResponseDTO = modelMapper.map(users,new TypeToken<List<UserSaveResponseDTO>>() {}.getType());
        return userSaveResponseDTO;
    }
}
