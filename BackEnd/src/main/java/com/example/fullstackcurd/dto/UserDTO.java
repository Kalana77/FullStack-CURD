package com.example.fullstackcurd.dto;


import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserDTO {
    private int id;

    private String name;

    private String email;

    private boolean activeStatus;
}
