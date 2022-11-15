package src.web.servlet;

import src.domain.Account;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.nio.channels.AcceptPendingException;

public class EditFormServlet extends HttpServlet {
    private static final String EDIT_FORM= "/WEB-INF/jsp/account/EditAccountForm.jsp";
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session=req.getSession();
        Account editAccount= (Account) session.getAttribute("loginAccount");
        session.setAttribute("username",editAccount.getUsername());
        session.setAttribute("Form","1234");
        req.getRequestDispatcher(EDIT_FORM).forward(req,resp);
    }
}
