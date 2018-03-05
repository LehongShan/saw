package cn.shan.saw.auth.service.impl;

import cn.shan.saw.auth.model.entity.AuthPermission;
import cn.shan.saw.auth.mapper.AuthPermissionMapper;
import cn.shan.saw.auth.service.AuthPermissionService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.UUID;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author shanlehong
 * @since 2018-02-07
 */
@Service
public class AuthPermissionServiceImpl extends ServiceImpl<AuthPermissionMapper, AuthPermission> implements AuthPermissionService {


    public static void main(String[] args) {


        for (int i=0;i<1000;i++){
            String uuid = UUID.randomUUID().toString().replace("-","");
            System.out.println(uuid);
        }
    }
}
