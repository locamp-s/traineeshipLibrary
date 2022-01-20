package test.com.library.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

import javax.sql.DataSource;

/*WebSecurityConfigКласс помечается @EnableWebSecurity включить поддержку веб - безопасности Spring Security
и обеспечивают интеграцию Spring MVC. Он также расширяет WebSecurityConfigurerAdapter
и переопределяет несколько своих методов, чтобы установить некоторые особенности конфигурации веб-безопасности.
В configure(HttpSecurity)методе определяет , какие пути URL должны быть надежно закреплены и которые не должны.
В частности, /и /home путь настроены , чтобы не требовать никакой аутентификации.
Все остальные пути должны быть аутентифицированы.
Когда пользователь успешно входит в систему, он перенаправляется на ранее запрошенную страницу,
требующую аутентификации. Существует настраиваемая /login страница (указанная с помощью loginPage()),
и все могут ее просматривать. userDetailsService()Метод настраивает в памяти пользователя магазин с одним пользователем.
Этому пользователю дается имя пользователя user, пароль password и роль USER.*/
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    private final DataSource dataSource;

    public WebSecurityConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                    .antMatchers("/", "/registration").permitAll()
                    .anyRequest().authenticated()
                .and()
                    .formLogin()
                    .loginPage("/login")
                    .permitAll()
                .and()
                    .logout()
                    .permitAll();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
                .dataSource(dataSource)
                .passwordEncoder(NoOpPasswordEncoder.getInstance())
                .usersByUsernameQuery("select username, password, active from usr where username=?")
                .authoritiesByUsernameQuery("select u.username, ur.roles from usr u inner join user_role ur on u.id = ur.user_id where u.username=?");
    }
}
