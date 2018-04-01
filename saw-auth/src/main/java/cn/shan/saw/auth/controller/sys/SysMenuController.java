package cn.shan.saw.auth.controller.sys;


import cn.shan.saw.auth.model.entity.SysMenu;
import cn.shan.saw.auth.service.SysMenuService;
import cn.shan.saw.common.controller.BaseController;
import cn.shan.saw.common.utils.S;
import com.baomidou.mybatisplus.mapper.Condition;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import java.util.Map;

/**
 * <p>
 * 菜单管理 前端控制器
 * </p>
 *
 * @author shanlehong
 * @since 2018-03-07
 */
@RestController
@RequestMapping("/sys")
@Slf4j
public class SysMenuController extends BaseController {

    @Autowired
    private SysMenuService sysMenuService;
    @GetMapping("/menu")
    public S querySysMenuList(@RequestParam Map searchMap){
        return RS(sysMenuService.queryAll());

    }
    @Cacheable(value="testallCache")
    @GetMapping("/menu/redis/{menuId}")
    public SysMenu queryRedisMenu(@PathVariable("menuId") Integer menuId){
       return sysMenuService.selectOne(Condition.create().and("menu_id = "+menuId));
    }



}

