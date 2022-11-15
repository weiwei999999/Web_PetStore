package src.web.servlet;

import org.apache.log4j.Logger;
import org.apache.log4j.NDC;
import src.domain.Account;
import src.persistence.AccountDao;
import src.service.AccountService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class SignOnServlet extends HttpServlet {
    public static Logger log = Logger.getLogger(SearchServlet.class);
    private static final String SIGN_ON_FORM= "/WEB-INF/jsp/account/signonForm.jsp";
    private String username;
    private  String password;
    private String signOnMsg;
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.password=req.getParameter("password");
        this.username=req.getParameter("username");
        //校验
        if(!validate())
        {
          req.setAttribute("signOnMsg",this.signOnMsg);
          req.getRequestDispatcher(SIGN_ON_FORM).forward(req,resp);
        }
        else {
            AccountService accountService=new AccountService();
           Account loginAccount= accountService.getAccount(username,password);
            if(loginAccount==null)
            {
                this.signOnMsg="用户名或密码错误";
                req.setAttribute("signOnMsg",this.signOnMsg);
                req.getRequestDispatcher(SIGN_ON_FORM).forward(req,resp);
            }
            else
            {
                HttpSession session=req.getSession();
                session.setAttribute("username",username);
                session.setAttribute("loginAccount",loginAccount);
                resp.sendRedirect("mainForm");
                String username=(String) session.getAttribute("username");
                NDC.push(username);
                log.error("用户登录");
                NDC.remove();

            }
        }

    }
    private boolean validate(){
        if(this.username==null||this.username.equals("")){
            this.signOnMsg ="用户名不能为空";
            return false;
        }
        if(this.password==null||this.password.equals("")){
            this.signOnMsg ="密码不能为空";
            return false;
        }
        return true;
    }
}
