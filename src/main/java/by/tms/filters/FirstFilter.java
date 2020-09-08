package by.tms.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(servletNames = "CalcServlet")
public class FirstFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse res = (HttpServletResponse) servletResponse;
//        Cookie[] cookies = req.getCookies();
//        Cookie cookie=cookies[0];
//        res.addCookie(new Cookie());
//
        if (req.getSession().getAttribute("user") == null) {
            res.sendRedirect("/err");
        } else {
            chain.doFilter(req, res);
        }
    }

//    @Override
//    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
//        if (req.getSession().getAttribute("user") == null) {
//            res.sendRedirect("/err");
//        } else {
//            chain.doFilter(req, res);
//        }
//    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }
}
