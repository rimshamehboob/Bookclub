package com.bookclub.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter implements CommandLineRunner {


    PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

    @Bean
    public static PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    public void configure(AuthenticationManagerBuilder auth) throws Exception  {
        auth
                .inMemoryAuthentication()
                .withUser("user")
                .password(passwordEncoder().encode("password")).roles("USER")

                .and()
                .withUser("testuser01")
                .password(passwordEncoder().encode("password01")).roles("USER", "ADMIN");
    }



    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/", "/home", "/about").permitAll()
                .antMatchers("/admin/**").hasRole("ADMIN")
                .anyRequest().authenticated()
                .and()
                //Default login form
                .formLogin()
                .loginPage("/login/user")
                .defaultSuccessUrl("/login")
                .permitAll()
                .and()
                //Second custom login form
                .formLogin()
                .loginPage("/login")
                 .defaultSuccessUrl("/home")
                .failureUrl("/login?error=true")
                .permitAll()
                .and()
                .httpBasic()
                .and()

                .logout()
                .logoutSuccessUrl("/login?logout=true")
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID")
                .permitAll()
                .and()
                .csrf().disable();
    }


    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public AuthenticationFailureHandler authenticationFailureHandler() {
        return new SimpleUrlAuthenticationFailureHandler("/login?error");
    }
    PasswordEncoder passwordEncoder ;


    public SecurityConfig(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) throws Exception {
        String defaultPassword = "password"; // or any other default password you set in your code or properties file
        String encodedPassword = passwordEncoder.encode(defaultPassword);
        System.out.println("Default password: " + defaultPassword);
        System.out.println("Encoded password: " + encodedPassword);
    }
}
