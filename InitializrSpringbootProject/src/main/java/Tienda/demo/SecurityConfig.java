package Tienda.demo;

import com.tienda.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
    
    @Autowired
    private UserService userDetailsService;
    
    @Bean 
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
        
    }
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("admin")
                .password("{noop}123")
                .roles("ADMIN","VENDEDOR","USER")
                .and()
                .withUser("vendedor")
                .password("{noop}123")
                .roles("VENDEDOR","USER")
                .and()
                .withUser("user")
                .password("{noop}123")
                .roles("USER");
    }
    @Override
    protected void configure (HttpSecurity http)throws Exception{
        http.authorizeRequests()
                .antMatchers("/crear")
                .hasRole("ADMIN")
                .antMatchers("/articulo")
                .hasAnyRole("ADMIN","VENDEDOR","ADMIN")
                .and()
                .formLogin()
                .and()
                .exceptionHandling().accessDeniedPage("/errores/403");
    }
}
