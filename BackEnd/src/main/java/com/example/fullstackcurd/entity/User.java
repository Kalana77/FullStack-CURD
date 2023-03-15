package com.example.fullstackcurd.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {

    @Id
    @Column(name = "p_Id",length = 45)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;

    private String email;

    private boolean activeStatus;

    public User(String name, String email, boolean activeStatus) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.activeStatus = activeStatus;
    }
}
