package src.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Random;

public class SignOnFormServlet extends HttpServlet {
    private static final String SIGN_ON_FORM= "/WEB-INF/jsp/account/signonForm.jsp";
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session=req.getSession();
        session.setAttribute("yzm",this.getString());
      req.getRequestDispatcher(SIGN_ON_FORM).forward(req, resp);
    }
    public String getString() {
        Random random = new Random();
        String str = "";
        for (int i = 0; i < 4; i++) {
            int num = random.nextInt(3);
            switch (num) {
                case 0:// 数字
                    int number = random.nextInt(10);
                    str += number;
                    break;
                case 1:// 小写字母
                    int lower = random.nextInt(26) + 97;
                    str += (char) lower;
                    break;
                case 2:// 大写字母
                    int upper = random.nextInt(26) + 65;
                    str += (char) upper;
                    break;
                default:
                    System.out.println("error");
                    break;
            }
        }
        return str;
}}

