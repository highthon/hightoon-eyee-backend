package com.example.demo.global.security.config.security

import com.example.demo.global.config.filter.FilterConfig
import com.example.demo.global.security.CustomAuthenticationEntryPoint
import com.example.demo.global.security.jwt.JwtTokenProvider
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.util.matcher.RequestMatcher
import org.springframework.web.cors.CorsUtils

@Configuration
@EnableWebSecurity
class SecurityConfig(
    private val jwtTokenProvider: JwtTokenProvider,
    private val objectMapper: ObjectMapper,
) {
    @Bean
    fun filterChain(http: HttpSecurity): SecurityFilterChain {
        return http
            .cors().and()
            .csrf().disable()
            .formLogin().disable()
            .httpBasic().disable()
            .sessionManagement()
            .sessionCreationPolicy(SessionCreationPolicy.STATELESS)

            .and()
            .authorizeRequests()
            .requestMatchers(RequestMatcher { request ->
                CorsUtils.isPreFlightRequest(request)
            }).permitAll()

            .antMatchers(HttpMethod.POST, "/auth").permitAll()
            .antMatchers(HttpMethod.PATCH, "/auth").permitAll()
            .antMatchers(HttpMethod.DELETE, "/auth").authenticated()
            .antMatchers(HttpMethod.POST, "/auth/signup").permitAll()

            .antMatchers(HttpMethod.POST, "/account").authenticated()
            .antMatchers(HttpMethod.GET, "/account").authenticated()

            .antMatchers(HttpMethod.GET, "/product").authenticated()
            .antMatchers(HttpMethod.GET, "/product/{post_id}").authenticated()
            .antMatchers(HttpMethod.POST, "/product").authenticated()

            .anyRequest().denyAll()
            .and()
            .exceptionHandling()
            .authenticationEntryPoint(CustomAuthenticationEntryPoint(objectMapper))

            .and()
            .apply(FilterConfig(jwtTokenProvider, objectMapper))
            .and()
            .build()
    }

    @Bean
    fun passwordEncoder(): PasswordEncoder =
        BCryptPasswordEncoder()
}