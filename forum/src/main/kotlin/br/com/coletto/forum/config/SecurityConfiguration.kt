package br.com.coletto.forum.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.web.SecurityFilterChain

@Configuration
@EnableWebSecurity
class SecurityConfiguration(
  private val userDetailsService: UserDetailsService
){

  @Bean
  fun securityFilterChain(http: HttpSecurity): SecurityFilterChain {
    http
      .authorizeHttpRequests { requests ->
        requests
          .anyRequest().authenticated()
      }
      .sessionManagement { session ->
        session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
      }
      .httpBasic { } // This enables HTTP Basic authentication
      .formLogin { formLogin ->
        formLogin.disable()
      }
    return http.build()
  }

  @Bean
  fun bCryptPasswordEncoder(): BCryptPasswordEncoder {
    return BCryptPasswordEncoder()
  }

  @Bean
  fun configureGlobal(auth: AuthenticationManagerBuilder): AuthenticationManagerBuilder {
    auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder())
    return auth
  }

}