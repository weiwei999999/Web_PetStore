package src.web.servlet;

import src.service.EmailService;

import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SendEmailServlet extends HttpServlet {


    private static final String REGISTER_FORM = "/WEB-INF/jsp/account/NewAccountForm.jsp";

    private String username;
    private String first_name;
    private String last_name;
    private String password;
    private String re_password;
    private String email;
    private String emailMsg;
    public String AuthCode_2;

    public static String getRandomFourNum() {
        String[] beforeShuffle = new String[]{"2", "3", "4", "5", "6", "7",
                "8", "9", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J",
                "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V",
                "W", "X", "Y", "Z"};
        List list = Arrays.asList(beforeShuffle);
        Collections.shuffle(list);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
        }
        String afterShuffle = sb.toString();
        String result = afterShuffle.substring(5, 9);
        return result;
    }


    @Override

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.username = req.getParameter("username");
        this.email = req.getParameter("account.email");
        this.password = req.getParameter("password");
        this.re_password = req.getParameter("repeatedPassword");
        this.first_name = req.getParameter("account.firstName");
        this.last_name = req.getParameter("account.lastName");
        if (!validate()) {
            req.setAttribute("emailMsg", this.emailMsg);
            req.getRequestDispatcher(REGISTER_FORM).forward(req, resp);
        } else {
            EmailService emailService = new EmailService();
            this.AuthCode_2 = getRandomFourNum();
            try {
                emailService.sentSimpleMail("验证码", this.AuthCode_2, this.email);
            } catch (MessagingException e) {
                throw new RuntimeException(e);
            }
            req.setAttribute("emailMsg", this.emailMsg);
            req.setAttribute("username_e", this.username);
            req.setAttribute("password", this.password);
            req.setAttribute("re_password", this.re_password);
            req.setAttribute("email", this.email);
            req.setAttribute("firstname", this.first_name);
            req.setAttribute("lastname", this.last_name);
            req.setAttribute("Authcode_2",this.AuthCode_2);
            req.getRequestDispatcher(REGISTER_FORM).forward(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);

    }

    private boolean validate() {
        if (this.email == null || this.email.equals("")) {
            this.emailMsg = "邮箱不能为空";
            return false;
        } else {
            boolean flag;
            String correct = "[\\w!#$%&'*+/=?^_`{|}~-]+(?:\\.[\\w!#$%&'*+/=?^_`{|}~-]+)*@(?:[\\w](?:[\\w-]*[\\w])?\\.)+[\\w](?:[\\w-]*[\\w])?";
            String mail = this.email;
            flag = mail.matches(correct);
            if(flag)
            {
                this.emailMsg=null;
                return true;
            }

            else
            {
                this.emailMsg="请输入合法的邮箱";
                return false;

            }

        }
    }

    //public static void main(String[] args) {
      // EmailService emailService = new EmailService();
       // try {
      //     emailService.sentSimpleMail("1","1","2092626629@qq.com");
     //   } catch (MessagingException e) {
      //      throw new RuntimeException(e);
     //   }
   // }
}







