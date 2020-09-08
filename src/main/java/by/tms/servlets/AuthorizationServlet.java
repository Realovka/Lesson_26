package by.tms.servlets;

import by.tms.service.UsersService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/auto")
public class AuthorizationServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/auto.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF8");
        String login = req.getParameter("login");
        String password = req.getParameter("password");

        req.getSession().setAttribute("loginAuthorization", login);
        req.getSession().setAttribute("passwordAuthorization", password);
        if (UsersService.getAnswerUserAuthorizationIsOrNo(req.getSession())){
            resp.sendRedirect("/calc");
        } else {
            req.getRequestDispatcher("/auto.jsp").forward(req,resp);
        }
    }
}


