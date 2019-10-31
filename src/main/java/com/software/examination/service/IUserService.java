package com.software.examination.service;

import com.software.examination.dto.SubjectDTO;
import com.software.examination.dto.UserDTO;
import com.software.examination.enity.UserDO;

import java.util.List;
import java.util.Map;

/**
 * @author fsqiu
 * @date 2019/10/24 10:47
 */
public interface IUserService {
    Integer login(UserDTO userDTO);

    Integer register(UserDTO userDTO);

    List<SubjectDTO> getAllSubject();

    Integer validateUser(UserDTO userDTO);

    Integer changePassword(UserDTO userDTO);

    UserDTO getUserInfo(UserDTO userDTO);

    List<UserDTO> getAllUser(Map<String,Integer> myData);

    Integer updatePermission(UserDTO userDTO);

    Integer deleteUser(UserDTO userDTO);

    Integer getUserCount();
}
