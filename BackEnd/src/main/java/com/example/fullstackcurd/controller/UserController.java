package com.example.fullstackcurd.controller;

import com.example.fullstackcurd.dto.requestDTO.UserSaveRequestDTO;
import com.example.fullstackcurd.dto.responseDTO.UserSaveResponseDTO;
import com.example.fullstackcurd.entity.User;
import com.example.fullstackcurd.exception.UserNotFoundException;
import com.example.fullstackcurd.repository.UserRepo;
import com.example.fullstackcurd.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("api/v1/CURD")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepo userRepo;

    @PostMapping(path = "/addUser")
    public String saveUser(@RequestBody UserSaveRequestDTO userSaveRequestDTO) {
        String id = userService.addUser(userSaveRequestDTO);
        return id;
    }

    @GetMapping(path = "/getUser")
    public List<UserSaveResponseDTO> getUser() {
        List<UserSaveResponseDTO> userSaveResponseDTO = userService.getUser();
        return userSaveResponseDTO;
    }

    @GetMapping("/user/{id}")
    User getUserById(@PathVariable int id) {
        return userRepo.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
    }

    @PutMapping("/user/{id}")
    User updateUser(@RequestBody User newUser, @PathVariable int id) {
        return userRepo.findById(id)
                .map(user -> {
                    user.setName(newUser.getName());
                    user.setEmail(newUser.getEmail());
                    return userRepo.save(user);

                }).orElseThrow(() -> new UserNotFoundException(id));
    }

    @DeleteMapping("/user/{id}")
    String deleteUser(@PathVariable int id) {
        if (!userRepo.existsById(id)) {
            throw new UserNotFoundException(id);
        }
        userRepo.deleteById(id);
        return "User with id " + id + " has been deleted success.";
    }
}
