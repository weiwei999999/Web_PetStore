package src.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class SignoutServlet extends HttpServlet {
    private static final String MAIN_FORM= "/WEB-INF/jsp/catalog/main.jsp";
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session=req.getSession();
        session.removeAttribute("loginAccount");
        req.getRequestDispatcher(MAIN_FORM).forward(req, resp);
    }
}
