package com.example.mongodb.example.services;

import com.example.mongodb.example.config.SequenceGenerator;
import com.example.mongodb.example.document.User;
import com.example.mongodb.example.model.UserDto;
import com.example.mongodb.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SequenceGenerator sequences;

    @Override
    public List<UserDto> findAll() {
        List<User> users = userRepository.findAll();
        List<UserDto> userDtos = new ArrayList<>();
        users.forEach(user -> {
            UserDto userDto = new UserDto();
            userDto.setId(user.getId());
            userDto.setName(user.getName());
            userDto.setDepartmentId(user.getDepartmentId());
            userDto.setTeamName(user.getTeamName());
            userDtos.add(userDto);
        });
        return userDtos;
    }

    @Override
    public UserDto getById(int id) {
       UserDto userDto =null;
        Optional<User> userOptional = userRepository.findById(id);
       if(userOptional.isPresent()){
           User user =userOptional.get();
           userDto = new UserDto();
           userDto.setId(user.getId());
           userDto.setName(user.getName());
           userDto.setTeamName(user.getTeamName());
           userDto.setDepartmentId(user.getDepartmentId());
       }
       return userDto;
    }

    @Override
    public UserDto addUser(UserDto userDto) {
        User user = new User();
        user.setId((int) sequences.generateSequence("userSequence"));
        user.setName(userDto.getName());
        user.setDepartmentId(userDto.getDepartmentId());
        user.setTeamName(userDto.getTeamName());
        userRepository.save(user);
        userDto.setId(user.getId());
        return userDto;
    }

    @Override
    public void deleteAllUser() {
        userRepository.deleteAll();
    }
}
