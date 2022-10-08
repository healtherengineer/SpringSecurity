package ege.springSecurity.securitydemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public InMemoryUserDetailsManager userDetailsManager() {
        UserDetails user = User.withDefaultPasswordEncoder()
                .username("user")
                .password("password")
                .roles("USER")
                .build();

        UserDetails admin = User.withDefaultPasswordEncoder()
                .username("admin")
                .password("password")
                .roles("ADMIN")
                .build();
        return new InMemoryUserDetailsManager(user,admin);
    }

    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {

        return http
                .csrf(csrf -> csrf.disable())
                .authorizeRequests(auth -> {
                    auth.antMatchers("/").permitAll();
                    auth.antMatchers("/user").hasAnyRole("USER","ADMIN");
                    auth.antMatchers("/admin").hasAnyRole("ADMIN");
                })
                .httpBasic(Customizer.withDefaults())
                .build();
    }

    //if we use WebSecurityConfigurerAdapter we should write this method in this way.
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//
//        http
//                .csrf().disable()
//                .authorizeRequests()
//                .antMatchers("/").permitAll()
//                .antMatchers("/user").hasAnyRole("USER")
//                .antMatchers("/admin").hasAnyRole("ADMIN")
//                .anyRequest().authenticated()
//                .and()
//                .httpBasic();
//
//    }
}
