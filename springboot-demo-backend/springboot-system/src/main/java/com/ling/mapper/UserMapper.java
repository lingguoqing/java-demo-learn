package com.ling.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ling.domain.entity.User;
import com.ling.domain.user.SelectPostUser;

/**
* @author 
* @description 针对表【user】的数据库操作Mapper
* @createDate 2024-10-30 14:00:04
* @Entity com.ling.domain.entity.User
*/
public interface UserMapper extends BaseMapper<User> {

    User selectByUser(SelectPostUser selectPostUser);
}




