package com.rakitov.restfull.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private final UserDetailsService userDetailsService;
    @Autowired
    private final AuthenticationSuccessHandler authenticationSuccessHandler;

    public WebSecurityConfig(UserDetailsService userDetailsService, AuthenticationSuccessHandler authenticationSuccessHandler) {
        this.userDetailsService = userDetailsService;
        this.authenticationSuccessHandler = authenticationSuccessHandler;
    }

    @Override
    public void configure(AuthenticationManagerBuilder managerBuilder) throws Exception {
        managerBuilder.userDetailsService(userDetailsService).passwordEncoder(noOpPasswordEncoder());
    }

    @Override
    public void configure(HttpSecurity httpSecurity) throws Exception {

        httpSecurity.formLogin()
                .loginPage("/login")
                .successHandler(authenticationSuccessHandler)
                .loginProcessingUrl("/login")
                .usernameParameter("email")
                .passwordParameter("password")
                .permitAll();
        httpSecurity.logout()
                .permitAll()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/login?logout")
                .and().csrf().disable();
        httpSecurity.authorizeRequests()
                .antMatchers("/login").anonymous()
                .antMatchers("/admin/**", "/user").hasAnyRole("ADMIN")
                .antMatchers("/user").hasAnyRole("USER")
                .anyRequest().authenticated();

    }

    @Bean
    public PasswordEncoder noOpPasswordEncoder () {
        return NoOpPasswordEncoder.getInstance();
    }

}
