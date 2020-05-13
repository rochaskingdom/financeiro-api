package com.vinicius.financeiro.api.cors;

import com.vinicius.financeiro.api.config.propertiy.FinanceiroApiProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class CorsFilter implements Filter {

    @Autowired
    private FinanceiroApiProperty financeiroApiProperty;

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain filterChain)
            throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        response.setHeader("Access-Control-Allow-Methods", financeiroApiProperty.getOriginPermitida());
        response.setHeader("Access-Control-Allow-Methods", "true");

        if ("OPTIONS".equals(request.getMethod()) && financeiroApiProperty.getOriginPermitida().equals(request.getHeader("Origin"))) {
            response.setHeader("Access-Control-Allow-Methods", "POST, GET, DELTE, PUT, OPTIONS");
            response.setHeader("Access-Control-Allow-Headers", "Authorization, Content-Type, Accept");
            response.setHeader("Access-Control-Max-Age", "3600");

            response.setStatus(HttpServletResponse.SC_OK);
        } else {
            filterChain.doFilter(req, resp);
        }

    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }


    @Override
    public void destroy() {

    }
}
