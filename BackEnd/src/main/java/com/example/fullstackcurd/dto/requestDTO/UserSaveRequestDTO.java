package com.example.fullstackcurd.dto.requestDTO;

import lombok.*;

@Setter
@Getter
//@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserSaveRequestDTO {



      //  private int id;

        private String name;

        private String email;

    //    private boolean activeStatus;


        public UserSaveRequestDTO(String name, String email) {
                this.name = name;
                this.email = email;
        }
}
