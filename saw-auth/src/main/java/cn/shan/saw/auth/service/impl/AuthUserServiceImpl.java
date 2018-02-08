package cn.shan.saw.auth.service.impl;

import cn.shan.saw.auth.model.entity.AuthUser;
import cn.shan.saw.auth.mapper.AuthUserMapper;
import cn.shan.saw.auth.service.AuthUserService;
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
public class AuthUserServiceImpl extends ServiceImpl<AuthUserMapper, AuthUser> implements AuthUserService {

}
