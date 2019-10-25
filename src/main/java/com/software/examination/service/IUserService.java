package com.software.examination.service;

import com.software.examination.dto.SubjectDTO;
import com.software.examination.dto.UserDTO;

import java.util.List;

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
}
