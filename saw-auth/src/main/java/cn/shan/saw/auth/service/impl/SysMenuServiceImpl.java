package cn.shan.saw.auth.service.impl;

import cn.shan.saw.auth.model.entity.SysMenu;
import cn.shan.saw.auth.mapper.SysMenuMapper;
import cn.shan.saw.auth.service.SysMenuService;
import cn.shan.saw.common.exception.SAWException;
import com.baomidou.mybatisplus.mapper.Condition;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 菜单管理 服务实现类
 * </p>
 *
 * @author shanlehong
 * @since 2018-03-07
 */
@Service
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper, SysMenu> implements SysMenuService {
    @Autowired
    private SysMenuMapper sysMenuMapper;

    @Override
    public List<SysMenu> queryAll() throws SAWException{

        List<SysMenu> sysMenuList = sysMenuMapper.selectList(Condition.create().and("1=1"));
        return sysMenuList;
    }
}
