package com.software.examination.controller;

import com.software.examination.dto.SubjectDTO;
import com.software.examination.dto.UserDTO;
import com.software.examination.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author fsqiu
 * @date 2019/10/24 10:32
 */
//跨域问题解决注解
@CrossOrigin
@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private IUserService userService;

    @PostMapping(value = "/login")
    public Integer login(@RequestBody UserDTO userDTO){
        return userService.login(userDTO);
    }

    @PostMapping(value = "/register")
    public Integer register(@RequestBody UserDTO userDTO){
        return userService.register(userDTO);
    }

    @GetMapping(value = "/subject")
    public List<SubjectDTO> getAllSubject(){
        return userService.getAllSubject();
    }

    @PostMapping(value = "/validateUser")
    public Integer validateUser(@RequestBody UserDTO userDTO){
        return userService.validateUser(userDTO);
    }

    @PostMapping(value = "/changePassword")
    public Integer change(@RequestBody UserDTO userDTO){
        return userService.changePassword(userDTO);
    }
}
