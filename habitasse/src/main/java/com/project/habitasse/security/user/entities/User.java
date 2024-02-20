package com.project.habitasse.security.user.entities;

import com.project.habitasse.domain.common.SuperclassEntity;
import com.project.habitasse.domain.offer.entities.Offer;
import com.project.habitasse.security.person.entities.Person;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_usuarios")
public class User extends SuperclassEntity implements Serializable, UserDetails {

    @Column(name = "username", length = 255, nullable = false)
    private String username;

    @Column(name = "password", length = 255, nullable = false)
    private String password;

    @Column(name = "is_user_cd", length = 255)
    private boolean IsUserCD;

    @Column(name = "is_user_co", length = 255)
    private boolean IsUserCO;

    @Column(name = "email", length = 255, unique = true, nullable = false)
    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "person_id", referencedColumnName = "id")
    private Person person;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Offer> offers;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // Retorne as permissões do usuário, se necessário
        return Collections.emptyList();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
