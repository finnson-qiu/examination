package com.software.examination.mapper;

import com.software.examination.dto.SubjectDTO;
import com.software.examination.dto.UserDTO;
import com.software.examination.enity.UserDO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author fsqiu
 * @date 2019/10/24 10:32
 */
@Mapper
@Component
public interface IUserMapper {
    Integer selectCount(String userName);

    UserDTO selectUser(String userName);

    Integer addOneUser(UserDO userDO);

    List<SubjectDTO> getAllSub();

    Integer updatePassword(UserDO userDO);
}
