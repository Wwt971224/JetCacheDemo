package com.lexue.demo.service.impl;

import com.alicp.jetcache.anno.CacheType;
import com.alicp.jetcache.anno.Cached;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.additional.query.impl.LambdaQueryChainWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lexue.demo.dao.UserDAO;
import com.lexue.demo.domain.UserDTO;
import com.lexue.demo.domain.UserVO;
import com.lexue.demo.entity.UserEntity;
import com.lexue.demo.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 测试表 服务实现类
 * </p>
 *
 * @author wentai
 * @since 2020-10-18
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserDAO, UserEntity> implements IUserService {

    @Cached(name = "retcache:userCache:userId:", key = "#userId", expire = 360, cacheType = CacheType.REMOTE)
    @Override
    public UserVO getUserById(Long userId) {
        UserVO userVO = new UserVO();
        UserEntity userEntity = this.getById(userId);
        BeanUtils.copyProperties(userEntity, userVO);
        return userVO;
    }

    @Cached(name = "retcache:userCache:leId:", key = "#leId", expire = 360, cacheType = CacheType.REMOTE)
    @Override
    public UserVO getUserByLeId(String leId) {
        UserVO userVO = new UserVO();
        LambdaQueryWrapper<UserEntity> queryChainWrapper = new LambdaQueryWrapper<>();
        queryChainWrapper.eq(UserEntity::getLeId, leId);
        UserEntity userEntity = this.getOne(queryChainWrapper);
        BeanUtils.copyProperties(userEntity, userVO);
        return userVO;
    }

    @Cached(name = "retcache:userCache:mobile:", key = "#mobile", expire = 360, cacheType = CacheType.REMOTE)
    @Override
    public UserVO getUserByMobile(String mobile) {
        UserVO userVO = new UserVO();
        LambdaQueryWrapper<UserEntity> queryChainWrapper = new LambdaQueryWrapper<>();
        queryChainWrapper.eq(UserEntity::getUserMobile, mobile);
        UserEntity userEntity = this.getOne(queryChainWrapper);
        BeanUtils.copyProperties(userEntity, userVO);
        return userVO;
    }

    @Override
    public void saveUser(UserDTO userDTO) {
        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(userDTO, userEntity);
        this.save(userEntity);
    }

    @Override
    public void updateUser(UserDTO userDTO) {
        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(userDTO, userEntity);
        this.updateById(userEntity);
    }

    @Override
    public void deleteUser(UserDTO userDTO) {
        this.removeById(userDTO.getUserId());
    }

}
