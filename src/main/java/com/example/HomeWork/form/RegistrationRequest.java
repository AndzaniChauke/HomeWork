package com.example.HomeWork.form;


import lombok.*;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
@NoArgsConstructor
@ToString
public class RegistrationRequest {
    @NotEmpty(message = "The email address cannot be empty!")
    private String email;

    @NotEmpty(message = "The first name cannot be empty!")
    private String firstName;


    @NotEmpty(message = "The last name  cannot be empty!")
    private String lastName;


    @NotEmpty(message = "The age cannot be empty!")
    private String age;

    @NotEmpty(message = "The password cannot be empty!")
    private String password;
}
