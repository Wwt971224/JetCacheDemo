package com.lexue.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lexue.demo.domain.UserDTO;
import com.lexue.demo.domain.UserVO;
import com.lexue.demo.entity.UserEntity;

/**
 * <p>
 * 测试表 服务类
 * </p>
 *
 * @author wentai
 * @since 2020-10-18
 */
public interface IUserService extends IService<UserEntity> {

    UserVO getUserById(Long userId);

    UserVO getUserByLeId(String leId);

    UserVO getUserByMobile(String mobile);

    void saveUser(UserDTO userDTO);

    void updateUser(UserDTO userDTO);

    void deleteUser(UserDTO userDTO);
}
