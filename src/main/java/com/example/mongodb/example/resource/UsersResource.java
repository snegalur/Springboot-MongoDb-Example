package com.example.mongodb.example.resource;

import com.example.mongodb.example.document.User;
import com.example.mongodb.example.model.UserDto;
import com.example.mongodb.example.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rest/users")
public class UsersResource {

    @Autowired
    private UserService service;

    @GetMapping("/all")
    public List<UserDto> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public UserDto getById(@PathVariable("id")int id){
        return service.getById(id);
    }

    @PostMapping("/adduser")
    public UserDto addUser(@RequestBody UserDto userdto){
        return service.addUser(userdto);
    }

    @DeleteMapping("/deleteall")
    public void deleteAll(){
       service.deleteAllUser();
    }
}
