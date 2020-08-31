package by.tms.servlets;

import by.tms.entity.Result;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@WebServlet(urlPatterns = "/calc", name = "CalcServlet")
public class CalcServlet extends HttpServlet {

    List<Result> results = new ArrayList<>();

    @Override
    public void init() throws ServletException {
        System.out.println("Init first");
    }



    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        String a = req.getParameter("num1");
        String b = req.getParameter("num2");
        String type = req.getParameter("type");
        double result = 0;
        switch (type) {
            case "+":
                result = Double.parseDouble(a) + Double.parseDouble(b);
                break;
            case "-":
                result = Double.parseDouble(a) - Double.parseDouble(b);
                break;
            case "*":
                result = Double.parseDouble(a) * Double.parseDouble(b);
                break;
            case "/":
                result = Double.parseDouble(a) / Double.parseDouble(b);
        }
        session.setAttribute("num1", a);
        session.setAttribute("num2", b);
        session.setAttribute("type", type);
        session.setAttribute("result", result);
        Result result1 = new Result(a, b, type, result);
        results.add(result1);
        session.setAttribute("resultList", results);
        req.getRequestDispatcher("/calc.jsp").forward(req, resp);
    }

    @Override
    public void destroy() {
        System.out.println("Destroy");
    }
}
