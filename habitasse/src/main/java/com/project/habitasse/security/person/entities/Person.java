package com.project.habitasse.security.person.entities;

import com.project.habitasse.domain.common.SuperclassEntity;
import com.project.habitasse.security.user.entities.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_person")
public class Person extends SuperclassEntity implements Serializable {

    @Column(name = "nome", length = 255, nullable = false)
    private String name;

    @Column(name = "birthday", length = 255)
    private Date birthday;

    @Column(name = "phone", length = 255)
    private String phone;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
}
