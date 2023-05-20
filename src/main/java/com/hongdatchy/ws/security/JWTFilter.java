package com.hongdatchy.ws.security;

import lombok.AllArgsConstructor;
import org.springframework.core.annotation.Order;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Order(1)
@AllArgsConstructor
public class JWTFilter implements Filter {

    private final JWTService jwtService;


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String token = request.getHeader("token");
//        if(token != null){
//            String username = jwtService.decode(token);
//            if (username != null){
//                filterChain.doFilter(servletRequest, servletResponse);
//            } else {
//                response.setStatus(401);
//            }
//        }
//        response.setStatus(401);
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
