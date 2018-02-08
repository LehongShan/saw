package cn.shan.saw.auth.service.impl;

import cn.shan.saw.auth.model.entity.AuthRoleUser;
import cn.shan.saw.auth.mapper.AuthRoleUserMapper;
import cn.shan.saw.auth.service.AuthRoleUserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author shanlehong
 * @since 2018-02-07
 */
@Service
public class AuthRoleUserServiceImpl extends ServiceImpl<AuthRoleUserMapper, AuthRoleUser> implements AuthRoleUserService {

}
