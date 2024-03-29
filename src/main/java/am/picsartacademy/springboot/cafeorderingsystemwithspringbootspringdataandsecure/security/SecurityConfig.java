package am.picsartacademy.springboot.cafeorderingsystemwithspringbootspringdataandsecure.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserDetailsService userDetailsService;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public SecurityConfig(UserDetailsService userDetailsService, PasswordEncoder passwordEncoder) {
        this.userDetailsService = userDetailsService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers(HttpMethod.POST, "/user/register", "/user/login").permitAll()
                .antMatchers(HttpMethod.GET, "/menu/items", "/order/view/{orderId}", "/order/history").hasRole("WAITER")
                .antMatchers(HttpMethod.POST, "/menu/add", "/order/place", "/billing/generate/{orderId}").hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT, "/menu/update/{itemId}", "/order/modify/{orderId}").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/menu/delete/{itemId}", "/order/cancel/{orderId}").hasRole("ADMIN")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .permitAll()
                .and()
                .logout()
                .permitAll();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
    }
}



//package am.picsartacademy.springboot.cafeorderingsystemwithspringbootspringdataandsecure.security;
//
//import am.picsartacademy.springboot.cafeorderingsystemwithspringbootspringdataandsecure.service.impl.UserDetailsServiceImpl;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.factory.PasswordEncoderFactories;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
//    @Autowired
//    private UserDetailsServiceImpl userDetailsService;
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.csrf().disable()
//                .authorizeRequests()
//                .antMatchers(HttpMethod.POST, "/user/register", "/user/login").permitAll()
//                .antMatchers(HttpMethod.GET, "/menu/items", "/order/view/{orderId}", "/order/history").hasRole("WAITER")
//                .antMatchers(HttpMethod.POST, "/menu/add", "/order/place", "/billing/generate/{orderId}").hasRole("ADMIN")
//                .antMatchers(HttpMethod.PUT, "/menu/update/{itemId}", "/order/modify/{orderId}").hasRole("ADMIN")
//                .antMatchers(HttpMethod.DELETE, "/menu/delete/{itemId}", "/order/cancel/{orderId}").hasRole("ADMIN")
//                .anyRequest().authenticated()
//                .and()
//                .formLogin()
//                .permitAll()
//                .and()
//                .logout()
//                .permitAll();
//    }
//
//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth, PasswordEncoder passwordEncoder) throws Exception {
//        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
//    }
//}
