package com.example.ProductApplication.filter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ProductFilter extends GenericFilter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException
    {
        HttpServletRequest request=(HttpServletRequest)servletRequest;
        HttpServletResponse response=(HttpServletResponse)servletResponse;
        String authHeader=request.getHeader("Authorization");
        // Bearer sfnjdnfs454sd5dg45s.sdfnjdnkndklvndknvkldn6566fbvml464+6fbmn.sjdbjkfdbvfds4
        if(authHeader==null || !authHeader.startsWith("Bearer"))
        {
            throw new ServletException("Token is Missing...........");
        }
        else
        {
            String token=authHeader.substring(7);  //sfnjdnfs454sd5dg45s.sdfnjdnkndklvndknvkldn6566fbvml464+6fbmn.sjdbjkfdbvfds4
            Claims claims=Jwts.parser().setSigningKey("secretKeyWave47").parseClaimsJws(token).getBody();
            System.out.println("Retrived claims : "+claims);
            String email=(String)claims.get("userEmail");
            request.setAttribute("a",email);
            String role=(String) claims.get("userRole");
            request.setAttribute("b",role);
            filterChain.doFilter(request,response);
        }
    }
}


// interface AI

// interface BI  extends AI

//class A
//Class B extends A

// class C implement AI