package cn.shan.saw.auth.service.impl;

import cn.shan.saw.auth.model.entity.SysUser;
import cn.shan.saw.auth.mapper.SysUserMapper;
import cn.shan.saw.auth.service.SysUserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 系统用户 服务实现类
 * </p>
 *
 * @author shanlehong
 * @since 2018-03-07
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {

}
