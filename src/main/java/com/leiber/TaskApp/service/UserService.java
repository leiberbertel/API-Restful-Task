package com.leiber.TaskApp.service;

import com.leiber.TaskApp.exception.UserNotFoundException;
import com.leiber.TaskApp.persistence.entity.dto.User;
import com.leiber.TaskApp.persistence.entity.UserEntity;
import com.leiber.TaskApp.persistence.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User getUser(int id) throws UserNotFoundException {
        UserEntity userEntity = userRepository.findById(id).orElseThrow();
        User UserDto = new User();
        UserDto.setUsername(userEntity.getUsername());
        UserDto.setEmail(userEntity.getEmail());
        UserDto.setPassword(userEntity.getPassword());
        return UserDto;
    }

    @Transactional
    public void delete(int id) {
        if (!this.userRepository.existsById(id)) {
            throw new UserNotFoundException("User with id " + id + " not found");
        }
        this.userRepository.deleteById(id);
    }

}