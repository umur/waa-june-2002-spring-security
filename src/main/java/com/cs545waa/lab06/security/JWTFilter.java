package com.cs545waa.lab06.security;

import lombok.AllArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@AllArgsConstructor
public class JWTFilter extends OncePerRequestFilter {
    //@Autowired
    private JWTHelper jwtHelper;
    //@Autowired
    private UserDetailsService userDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String authorizationHeader=request.getHeader("Authorization");
        String email=null;
        String token=null;

        if(authorizationHeader != null && authorizationHeader.startsWith("Bearer ")){
            token=authorizationHeader.substring(7);
            try{
                email=jwtHelper.getUsername(token);
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
        if( email !=null && SecurityContextHolder.getContext().getAuthentication() == null){
            var useDetails=userDetailsService.loadUserByUsername(email);
            boolean isTokenValid=jwtHelper.validateToken(token);
            if(isTokenValid){
                UsernamePasswordAuthenticationToken authentication=new UsernamePasswordAuthenticationToken(
                        useDetails,null,useDetails.getAuthorities());
                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        }
        filterChain.doFilter(request,response);
    }
}
