package com.project.habitasse.security.user.service;

import com.project.habitasse.security.person.entities.Person;
import com.project.habitasse.security.person.repository.PersonRepository;
import com.project.habitasse.security.user.entities.User;
import com.project.habitasse.security.user.entities.request.RegisterDto;
import com.project.habitasse.security.user.repository.UserRepository;
import com.project.habitasse.utils.Utils;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository usuarioRepository;
    @Autowired
    private PersonRepository pessoaRepository;

    public RegisterDto save(RegisterDto request) {
        User user = new User();
        Person person = new Person();

        user.setPassword(request.getPassword());
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        usuarioRepository.save(user);

        person.setName(request.getEmail());
        person.setBirthday(Utils.dateToSave(request.getBirthday()));
        person.setUser(user);
        pessoaRepository.save(person);
        return request;
    }

    public User findById(Long id) {
        User usuario = usuarioRepository.findById(id).get();
        if (usuario == null) {
            throw new UsernameNotFoundException("Usuário não encontrado com o id: " + id);
        }
        return usuario;
    }

    public User findByEmail(String email) {
        User usuario = usuarioRepository.findByEmail(email).get();
        if (usuario == null) {
            throw new UsernameNotFoundException("Usuário não encontrado com o email: " + email);
        }
        return usuario;
    }

    public User findByUsername(String username) throws UsernameNotFoundException {
        User usuario = usuarioRepository.findByUsername(username).get();
        if (usuario == null) {
            throw new UsernameNotFoundException("Usuário não encontrado com o nome: " + username);
        }
        return usuario;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User usuario = usuarioRepository.findByUsername(username).get();
        if (usuario == null) {
            throw new UsernameNotFoundException("Usuário não encontrado com o nome: " + username);
        }
        return usuario;
    }
}
