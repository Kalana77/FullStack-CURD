package com.example.fullstackcurd.service;

import com.example.fullstackcurd.dto.requestDTO.UserSaveRequestDTO;
import com.example.fullstackcurd.dto.responseDTO.UserSaveResponseDTO;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {
    String addUser(UserSaveRequestDTO userSaveRequestDTO);

    List<UserSaveResponseDTO> getUser();
}
