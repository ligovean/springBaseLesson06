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
        auth.inMemoryAuthentication()
                .withUser(users.username("alex").password("{noop}123").roles("USER", "ADMIN"))
                .withUser(users.username("bob").password("$2a$10$Ky8sAV0Zbj8RKJcCozhkZuR7S8pIT2Sif/1v42V26eTzx3lzhuQQO").roles("USER"));
    }


    protected void configure(HttpSecurity http) throws Exception {
        //     http.csrf().ignoringAntMatchers("/**");

//        http.authorizeRequests()
//                .anyRequest().authenticated()
//                .antMatchers("/shop/**").permitAll()
//                .antMatchers("/admin/**").hasAnyRole("MANAGER", "ADMIN")
//                .and()
//                .httpBasic()
//                .and()
//                .logout()
//                    .deleteCookies("JSESSIONID")
//                    .logoutUrl("/exit")
//                    .logoutSuccessUrl("/shop");



        http.authorizeRequests()
                .antMatchers("/").hasAnyRole("USER")
                .antMatchers("/admin/**").hasRole("ADMIN")
                .and()
                .formLogin()
                .loginPage("/login")
                .loginProcessingUrl("/authenticateTheUser")
                .permitAll();

//        http.authorizeRequests()
////                .anyRequest().authenticated()
//                .antMatchers("/").permitAll()
//                .antMatchers("/admin").hasRole("ADMIN")
//                .and()
//                .formLogin()
//                .loginPage("/login")
//                // .failureUrl("/ohSh")
//                .loginProcessingUrl("/authenticateTheUser")
//                .permitAll()
//                .and()
//                .logout()
//                .permitAll();

// 1

//        http.authorizeRequests()
//                .anyRequest().authenticated()
//            //    .antMatchers("/*").hasAnyRole("ADMIN","USER");
//                .antMatchers("/").hasAnyRole("USER")
//                .antMatchers("/admin/**").hasRole("ADMIN")
//                .and()
//                .formLogin()
//                .loginPage("/login")
//                // .failureUrl("/ohSh")
//                .loginProcessingUrl("/authenticateTheUser")
//                .permitAll()
//                .and()
//                .logout()
//                .permitAll()
//                .and()
//                .exceptionHandling().accessDeniedPage("/accessDenied");


//        http
//                .csrf().disable()
//                .authorizeRequests()
//                .antMatchers("/").hasRole("USER")
//                .anyRequest().authenticated()
//                .and()
//                .httpBasic()
//                .and()
//                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

    }

}
