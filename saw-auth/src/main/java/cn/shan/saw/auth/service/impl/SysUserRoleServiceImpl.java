package cn.shan.saw.auth.service.impl;

import cn.shan.saw.auth.model.entity.SysUserRole;
import cn.shan.saw.auth.mapper.SysUserRoleMapper;
import cn.shan.saw.auth.service.SysUserRoleService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户与角色对应关系 服务实现类
 * </p>
 *
 * @author shanlehong
 * @since 2018-03-07
 */
@Service
public class SysUserRoleServiceImpl extends ServiceImpl<SysUserRoleMapper, SysUserRole> implements SysUserRoleService {

}
