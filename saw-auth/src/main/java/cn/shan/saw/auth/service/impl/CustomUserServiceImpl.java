package cn.shan.saw.auth.service.impl;

import cn.shan.saw.auth.model.entity.AuthPermissionRole;
import cn.shan.saw.auth.model.entity.AuthRole;
import cn.shan.saw.auth.model.entity.AuthRoleUser;
import cn.shan.saw.auth.model.entity.AuthUser;
import cn.shan.saw.auth.service.AuthPermissionRoleService;
import cn.shan.saw.auth.service.AuthRoleService;
import cn.shan.saw.auth.service.AuthRoleUserService;
import cn.shan.saw.auth.service.AuthUserService;
import com.baomidou.mybatisplus.mapper.Condition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * Created by shanlehong on 2018/2/8.
 */
@Service
public class CustomUserServiceImpl implements UserDetailsService {

    @Autowired
    private AuthUserService authUserService;

    @Autowired
    private AuthRoleUserService authRoleUserService;

    @Autowired
    private AuthRoleService authRoleService;



    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        AuthUser authUser = authUserService.selectOne(Condition.create().eq("user_name","shanlehong"));
        if (authUser==null || authUser.getUserName()==null){
            throw new UsernameNotFoundException("用户名不存在");
        }

        List<AuthRoleUser> authRoleUserList =
                authRoleUserService.selectList(Condition.create().eq("auth_user_id",authUser.getAuthUserId()));

        List<String> roleIdList = authRoleUserList.stream().map(AuthRoleUser::getAuthRoleId).collect(Collectors.toList());

        List<AuthRole> authRoleList = authRoleService.selectBatchIds(roleIdList);

        List<GrantedAuthority> grantedAuthorities = new ArrayList <>();
        //用于添加用户的权限。只要把用户权限添加到authorities 就万事大吉。
        for (AuthRole authRole : authRoleList) {
            if (authRole != null && authRole.getName()!=null) {

                GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(authRole.getName());
                //1：此处将权限信息添加到 GrantedAuthority 对象中，在后面进行全权限验证时会使用GrantedAuthority 对象。
                grantedAuthorities.add(grantedAuthority);
            }
        }

        return new User(authUser.getUserName(), authUser.getPassword(), grantedAuthorities);
    } //自定义UserDetailsService 接口

    public static void main(String[] args) {
        for (int i=0;i<10;i++){
            System.out.println( UUID.randomUUID().toString().replace("-",""));
        }

    }
}
