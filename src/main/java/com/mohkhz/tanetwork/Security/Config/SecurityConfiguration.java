package com.mohkhz.tanetwork.Security.Config;

import com.mohkhz.tanetwork.Impl.UserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static com.mohkhz.tanetwork.Security.Role.AppRole.*;
import static com.mohkhz.tanetwork.Security.Role.UserPermission.*;

/**
 * @author Mohammad mehdi khajhezadeh
 * @project TA-network
 * @email_support eng.khajhezadeh@gmail.com
 * @create 21 October 2022 at 1:15 AM
 */

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    UserDetailService userDetailsService;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/register", "/login", "/Images/**").permitAll()
                .antMatchers("/list/file", "/file/**", "/list/github.png")
                .hasAnyAuthority(ADMIN.name(), STD.name(), TA_WORKSHOP.getPermission(), STD_WORKSHOP.getPermission())
                .antMatchers("/new/file", "/list/user" , "/manage/**")
                .hasAnyAuthority(ADMIN.name(), TA_WORKSHOP.getPermission())
                .antMatchers("/new/user", "/update/**" , "/delete/**").hasAuthority(ADMIN.name())
                .anyRequest().authenticated()
                .and()
                .formLogin().loginPage("/login")
                .loginProcessingUrl("/login")
                .defaultSuccessUrl("/list/file").failureUrl("/login?error")
                .and()
                .exceptionHandling().accessDeniedPage("/accessDenied")
        ;

    }

    @Bean
    DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
        auth.setUserDetailsService(userDetailsService);
        auth.setPasswordEncoder(passwordEncoder());
        return auth;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }
}
