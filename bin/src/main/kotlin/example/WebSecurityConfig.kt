package example

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.provisioning.InMemoryUserDetailsManager

@Configuration
@EnableWebSecurity
class WebSecurityConfig : WebSecurityConfigurerAdapter() {

    // roles admin allow to access /admin/**
    // roles user allow to access /user/**
    // custom 403 access denied handler
    @Throws(Exception::class)
    override fun configure(http :HttpSecurity) {

      http
        .authorizeRequests()
          .antMatchers("/login").permitAll()
          .anyRequest().authenticated()
          .and()
        .formLogin()
          .loginPage("/login")
          .loginProcessingUrl("/login")
          .defaultSuccessUrl("/", true)
          .permitAll()
    }

  	@Bean
  	override fun userDetailsService() :UserDetailsService {

      val user :UserDetails =
  			 User.withDefaultPasswordEncoder()
  				.username("user")
  				.password("pass")
  				.roles("USER")
  				.build()

      return InMemoryUserDetailsManager(user)
  	}
}
