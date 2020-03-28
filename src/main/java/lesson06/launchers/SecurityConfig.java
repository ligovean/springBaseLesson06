package lesson06.launchers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private DataSource myDataSource;

    @Autowired
    public void setMyDataSource(DataSource myDataSource) {
        this.myDataSource = myDataSource;
    }

    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource(myDataSource);

        User.UserBuilder users = User.builder();

//        auth.inMemoryAuthentication()
//                .withUser(users.username("alex").password("123").roles("USER", "ADMIN"))
//                .withUser(users.username("bob").password("{noop}123").roles("USER"));

//
//        auth.inMemoryAuthentication()
//                .withUser(users.username("user1").password("{noop}123").roles("USER", "ADMIN"))
//                .withUser(users.username("user2").password("$2a$10$Ky8sAV0Zbj8RKJcCozhkZuR7S8pIT2Sif/1v42V26eTzx3lzhuQQO").roles("USER"));
    }

    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/").hasAnyRole("USER")
                .antMatchers("/admin/**").hasRole("ADMIN")
                .and()
                .formLogin()
                .loginPage("/login")
                .loginProcessingUrl("/authenticateTheUser")
                .permitAll();
    }

}
