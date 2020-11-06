package com.csc394.capStoneProject.config;

import com.csc394.capStoneProject.config.MyUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@EnableWebSecurity
@Configuration
public class securityConfiguration extends WebSecurityConfigurerAdapter {


    @Autowired
    MyUserDetailService userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//                .antMatchers("/admin").hasRole("ADMIN")
//                .antMatchers("/user").hasAnyRole("ADMIN","USER")
//                .antMatchers("/authenticate").permitAll()
//                .antMatchers("/","/h2-console/**").permitAll()
//                .and().formLogin();
//

        http.csrf().disable().authorizeRequests().antMatchers("/authenticate")
                .permitAll()
                .antMatchers("/","/h2-console/**").permitAll()
                .anyRequest().authenticated();
        http.csrf().disable();
        http.headers().frameOptions().disable();
    }
    @Bean
     public PasswordEncoder getPasswordEncoder(){
        return NoOpPasswordEncoder.getInstance();
     }

    @Bean(name = BeanIds.AUTHENTICATION_MANAGER)
    @Override
    public AuthenticationManager authenticationManagerBean()throws Exception{
        return super.authenticationManagerBean();
    }

}
