package org.danyuan.application.common;

import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.stereotype.Component;

/**
 * Created by wangyunfei on 2017/6/9.
 */
@Component
@EnableOAuth2Sso // 实现基于OAuth2的单点登录，建议跟踪进代码阅读以下该注解的注释，很有用
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
//	@Override
//	public void configure(HttpSecurity http) throws Exception {
//		http.antMatcher("/**")
//		        // 所有请求都得经过认证和授权
//		        .authorizeRequests().anyRequest().authenticated().and().authorizeRequests().antMatchers("/", "/login", "/dist/*/**").permitAll().and()
//		        // 这里之所以要禁用csrf，是为了方便。
//		        // 否则，退出链接必须要发送一个post请求，请求还得带csrf token
//		        // 那样我还得写一个界面，发送post请求
//		        .csrf().disable()
//		        // 退出的URL是/logout
//		        .logout().logoutUrl("/logout").permitAll()
//		        // 退出成功后，跳转到/路径。
//		        .logoutSuccessUrl("/login");
//	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		// 允许所有用户访问"/"和"/home"
		http.csrf().disable().authorizeRequests()
//		        // 不需要验证就可以访问的路径
		        .antMatchers("/dist/*/**", "/login**", "/info", "/oauth2/**").permitAll()
//		        // 限制所有请求都需要验证
		        .anyRequest().authenticated().and().formLogin()
//		        // 登录页
		        .defaultSuccessUrl("/index").loginPage("/login").failureUrl("/login?error").permitAll().and().logout().permitAll();
		
	}

}