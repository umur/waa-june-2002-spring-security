package edu.miu.springsecurity.security.filter;

import edu.miu.springsecurity.security.AuthService;
import edu.miu.springsecurity.security.helper.JwtHelper;
import io.jsonwebtoken.ExpiredJwtException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtFilter extends OncePerRequestFilter {
  private final JwtHelper jwtHelper;

  private final AuthService authService;

  public JwtFilter(JwtHelper jwtHelper, AuthService authService) {
    this.jwtHelper = jwtHelper;
    this.authService = authService;
  }

  @Override
  protected void doFilterInternal(HttpServletRequest request,
                                  HttpServletResponse response,
                                  FilterChain filterChain) throws ServletException, IOException {

    final String authorizationHeader = request.getHeader("Authorization");
    String email = null;
    String token = null;

    if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
      token = authorizationHeader.substring(7);
      try {
        email = jwtHelper.getUsernameFromToken(token);
      } catch (ExpiredJwtException e) {

      }

    }

    if (email != null && SecurityContextHolder.getContext().getAuthentication() == null) {
      var userDetails = authService.loadUserByUsername(email);
      boolean isTokenValid = jwtHelper.validateToken(token);
      if (isTokenValid) {
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
          userDetails, null, userDetails.getAuthorities());

        authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
        SecurityContextHolder.getContext().setAuthentication(authentication);
      }
    }

    filterChain.doFilter(request, response);
  }
}
