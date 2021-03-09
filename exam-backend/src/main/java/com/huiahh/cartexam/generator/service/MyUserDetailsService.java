package com.huiahh.cartexam.generator.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.huiahh.cartexam.generator.entity.User;
import com.huiahh.cartexam.generator.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userDetailsService")
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserMapper userMapper;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //调用usersMapper方法，根据用户名查询数据库
        QueryWrapper<User> wrapper = new QueryWrapper();
        // where username=?
        wrapper.eq("username",username);
        User user = userMapper.selectOne(wrapper);
        System.out.println(user.toString());
        if (user == null) {
            throw  new UsernameNotFoundException("用户名不存在！");
        }
        List<GrantedAuthority> auths =
                AuthorityUtils.commaSeparatedStringToAuthorityList("user");
        //从查询数据库返回users对象，得到用户名和密码，返回
        return new org.springframework.security.core.userdetails.User(user.getUsername(),
                new BCryptPasswordEncoder().encode(user.getPassword()),auths);
    }
}
