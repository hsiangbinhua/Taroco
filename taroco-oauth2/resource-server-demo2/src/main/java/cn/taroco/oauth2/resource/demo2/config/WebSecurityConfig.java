package cn.taroco.oauth2.resource.demo2.config;

import cn.taroco.oauth2.config.AbstractResourceServerConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

/**
 * 资源服务器访问权限配置
 *
 * @author liuht
 * @date 2018/7/24 17:38
 */
@Configuration
public class WebSecurityConfig extends AbstractResourceServerConfig {

    @Override
    public void configure(HttpSecurity http) throws Exception {
        super.configure(http);
        http.authorizeRequests()
                //访问受保护资源 /res 的要求：客户端 Scope 为 read，用户本身角色为 USER
                .antMatchers("/res")
                .access("#oauth2.hasScope('read') and hasRole('USER')");
    }

}