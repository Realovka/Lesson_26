package by.tms.servlets;

import by.tms.entity.User;
import by.tms.service.UsersService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/reg", loadOnStartup = 0)
public class RegistrationServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/reg.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF8");
        String name = req.getParameter("name");
        String login = req.getParameter("login");
        String password = req.getParameter("password");

        User user = new User(name, login, password);
        req.getServletContext().setAttribute("userRegistration", user);
        req.getServletContext().setAttribute("loginRegistration", login);

       if(UsersService.getAnswerUserRegistrationIsOrNo(req.getServletContext(), req.getSession())){
           String error="Пользователь с таким логином уже есть";
           req.getSession().setAttribute("errorRegistration",error);
           req.getRequestDispatcher("/reg.jsp").forward(req,resp);
       } else {
           resp.sendRedirect("/auto");
       }

    }
}
