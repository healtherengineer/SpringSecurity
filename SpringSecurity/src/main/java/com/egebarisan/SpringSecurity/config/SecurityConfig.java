package com.egebarisan.SpringSecurity.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    //Bizim yerimize bilgileri alıp kontrol edecek servis
    @Autowired
    UserDetailsService userDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        //PathBazlı autharization . Role bazlı etc.
        http.httpBasic();
        http.formLogin();

        http.authorizeHttpRequests().antMatchers("/dashboard").hasAnyRole("ROLE_ADMIN", "ROLE_USER")
                .antMatchers("/admin").hasRole("ROLE_ADMIN")
                .and()
                .authorizeHttpRequests().antMatchers("/index")
                .permitAll();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

//        auth.inMemoryAuthentication().withUser("Ege").password("{noop}852456").roles("admin")
//                .and()
//                .withUser("Dilara").password("{noop}789456").roles("standard");


        auth.userDetailsService(userDetailsService);

    }
}
