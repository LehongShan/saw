package cn.shan.saw.auth.mapper;

import cn.shan.saw.auth.model.entity.SysUser;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 系统用户 Mapper 接口
 * </p>
 *
 * @author shanlehong
 * @since 2018-03-07
 */
public interface SysUserMapper extends BaseMapper<SysUser> {

    List<String> queryAllPerms(Long userId);

}
