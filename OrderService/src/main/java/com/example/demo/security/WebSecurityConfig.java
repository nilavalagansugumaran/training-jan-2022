package com.example.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // Define configuration constraints here…
        http.httpBasic()
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/order/**").hasRole("USER")
                .antMatchers(HttpMethod.POST, "/order/**").hasRole("ADMIN")
                .antMatchers("/h2-console/**").permitAll()
                .and().csrf().disable().formLogin().disable();

        http.headers().frameOptions().disable(); // To display H2-console properly
    }

    // Either Autowired - configureGlobal or Override - configure
//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        // Define auth implementation
//        auth.inMemoryAuthentication()
//                .withUser("nila").password("{noop}password").roles("USER")
//                .and()
//                .withUser("admin").password("{noop}admin").roles("ADMIN", "USER");
//    }

    @Autowired private DataSource dataSource;

    // To access database auth
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource(dataSource)
                .usersByUsernameQuery("select username, password, enabled"
                        + " from users where username=?")
                .authoritiesByUsernameQuery("select username, authority "
                        + "from authorities where username=?")
                .passwordEncoder(new BCryptPasswordEncoder());
    }
}
