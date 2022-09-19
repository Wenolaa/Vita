package shop.shoes.portal.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();}

    @Autowired
    UserDetailsServiceImpl userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeHttpRequests()
                .antMatchers(
                "/login_shoes.html",
                "/login_shoes",
                "/register_shoes.html",
                "/register_shoes",
                "/renew.html",
                "/renew",
                "/image/**",
                "/js/**",
                "/jquery/**"
                ).permitAll()
                .anyRequest().authenticated()
                .and().formLogin()
                .loginPage("/login_shoes.html")
                .loginProcessingUrl("/login_shoes")
                .failureUrl("/login_shoes.html?error")
                .defaultSuccessUrl("/index_shoes.html")
                .and().logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login_shoes.html?logout");
    }
}
