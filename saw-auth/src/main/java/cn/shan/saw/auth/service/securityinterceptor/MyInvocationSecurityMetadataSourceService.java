package cn.shan.saw.auth.service.securityinterceptor;

import cn.shan.saw.auth.model.entity.AuthResource;
import cn.shan.saw.auth.model.entity.AuthRole;
import cn.shan.saw.auth.model.entity.AuthRoleResource;
import cn.shan.saw.auth.service.AuthResourceService;
import cn.shan.saw.auth.service.AuthRoleResourceService;
import cn.shan.saw.auth.service.AuthRoleService;
import com.baomidou.mybatisplus.mapper.Condition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by shanlehong on 2018/2/9.
 */
@Service
public class MyInvocationSecurityMetadataSourceService implements
        FilterInvocationSecurityMetadataSource {

    @Autowired
    private AuthRoleService authRoleService;
    @Autowired
    private AuthRoleResourceService authRoleResourceService;
    @Autowired
    private AuthResourceService authResourceService;


    private HashMap<String, Collection<ConfigAttribute>> map =null;

    /**
     * 加载权限表中所有权限
     */
    public void loadResourceDefine(){
        map = new HashMap<>();
        Collection<ConfigAttribute> array;
        ConfigAttribute cfg;
        List<AuthRole> authRoleList = authRoleService.selectList(Condition.create().eq("1",1));
        for(AuthRole authRole : authRoleList) {
            array = new ArrayList<>();
            cfg = new SecurityConfig(authRole.getName());
            List<AuthRoleResource>  authRoleResourceList =
                    authRoleResourceService.selectList(Condition.create().eq("auth_role_id",authRole.getAuthRoleId()));
            List<String> authResourceIdList =  authRoleResourceList.stream().map(AuthRoleResource::getAuthResourceId).collect(Collectors.toList());
            List<AuthResource> authResourceList =  authResourceService.selectBatchIds(authResourceIdList);

            //此处只添加了用户的名字，其实还可以添加更多权限的信息，例如请求方法到ConfigAttribute的集合中去。此处添加的信息将会作为MyAccessDecisionManager类的decide的第三个参数。
            array.add(cfg);
            //用权限的getUrl() 作为map的key，用ConfigAttribute的集合作为 value，
            for (AuthResource authResource:authResourceList){
                String url = authResource.getUrl();
                if (map.containsKey(url)){
                    Collection<ConfigAttribute> configAttributes = map.get(url);
                    configAttributes.add(cfg);

                }else {
                    map.put(url, array);
                }

            }

        }

    }

    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
        if(map ==null) loadResourceDefine();
        //object 中包含用户请求的request 信息
        HttpServletRequest request = ((FilterInvocation) object).getHttpRequest();
        AntPathRequestMatcher matcher;
        String resUrl;
        for(Iterator<String> iter = map.keySet().iterator(); iter.hasNext(); ) {
            resUrl = iter.next();
            matcher = new AntPathRequestMatcher(resUrl);
            if(matcher.matches(request)) {
                return map.get(resUrl);
            }
        }
        return null;
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
