package com.egebarisan.SpringSecurity.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    @Override
    protected void configure(HttpSecurity http) throws Exception {

        //PathBazlı autharization . Role bazlı etc.
        http.httpBasic();
        http.formLogin();

        http.authorizeHttpRequests().antMatchers("/dashboard").authenticated()
                .and()
                .authorizeHttpRequests().antMatchers("/index").permitAll();
    }
}
