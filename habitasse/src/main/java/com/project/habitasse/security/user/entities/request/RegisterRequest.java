package com.project.habitasse.security.user.entities.request;

import com.project.habitasse.security.person.entities.Person;
import com.project.habitasse.utils.Utils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequest {

    private Long id;
    private String name;
    private String birthday;
    private String username;
    private String password;
    private String email;

    public static Person mapRequestToEntity(RegisterRequest request) {
        Date birthday = null;
        if (request.getBirthday() != null || request.getBirthday() == "''") {
            birthday = Utils.dateToSave(request.getBirthday());
        }
        Person person = new Person();
        person.setId(request.getId());
        person.setName(request.getName());
        person.setBirthday(birthday);
        return person;
    }



}
