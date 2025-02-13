package com.camp.campusconnect.config;

import java.io.IOException;
import java.util.List;

import javax.crypto.SecretKey;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

public class JwtTokenValidationFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        // Get the JWT from the Authorization header
        String jwt = request.getHeader(SecurityContext.HEADER);

        if (jwt != null && jwt.startsWith("Bearer ")) {
            try {
                // Remove "Bearer " from the JWT token
                jwt = jwt.substring(7);

                // Get the SecretKey from the SecurityContext
                SecretKey key = Keys.hmacShaKeyFor(SecurityContext.JWT_KEY.getBytes());

                // Parse the JWT to get the claims
                Claims claims = Jwts.parserBuilder()
                        .setSigningKey(key)
                        .build()
                        .parseClaimsJws(jwt)
                        .getBody();

                // Extract the username from the claims
                String username = claims.getSubject();

                // Extract authorities (roles) from the claims
                String authorities = (String) claims.get("authorities");
                List<GrantedAuthority> auths = AuthorityUtils.commaSeparatedStringToAuthorityList(authorities);

                // Create the Authentication object
                Authentication auth = new UsernamePasswordAuthenticationToken(username, null, auths);

                // Set the Authentication in the SecurityContext
                SecurityContextHolder.getContext().setAuthentication(auth);

            } catch (Exception e) {
                // Handle token parsing/validation errors
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                response.getWriter().write("Invalid or expired token");
                return;
            }
        }

        // Continue with the filter chain
        filterChain.doFilter(request, response);
    }
}
