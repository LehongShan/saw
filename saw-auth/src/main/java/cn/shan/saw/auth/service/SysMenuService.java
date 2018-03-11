package cn.shan.saw.auth.service;

import cn.shan.saw.auth.model.entity.SysMenu;
import cn.shan.saw.common.exception.SAWException;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

/**
 * <p>
 * 菜单管理 服务类
 * </p>
 *
 * @author shanlehong
 * @since 2018-03-07
 */
public interface SysMenuService extends IService<SysMenu> {

    List<SysMenu> queryAll() throws SAWException;

}
