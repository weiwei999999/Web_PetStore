package src.web.servlet;

import org.apache.log4j.Logger;
import org.apache.log4j.NDC;
import src.domain.Account;
import src.persistence.AccountDao;
import src.persistence.impl.AccountDaoImpl;
import src.service.AccountService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class RegisterServlet extends HttpServlet {
    public static Logger log = Logger.getLogger(RegisterServlet.class);

    private String username;
    private String password;
    private String repeatpassword;
    private String email;
    private String firstName;
    private String lastName;
    private String AuthCode;

    private String AuchCode_1;
    private String status;
    private String address1;
    private String address2;
    private String city;
    private String state;
    private String zip;
    private String country;
    private String phone;
    private String favouriteCategoryId;
    private String languagePreference;
    private boolean listOption;
    private boolean bannerOption;
    private String bannerName;
    private boolean isAdmin;
    private String registerMsg;

    private static final String REGISTER_FORM= "/WEB-INF/jsp/account/NewAccountForm.jsp";
    private static final String SIGN_ON_FORM= "/WEB-INF/jsp/account/signonForm.jsp";
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.AuchCode_1=req.getParameter("Authcode_2");
        this.username = req.getParameter("username");
        this.password = req.getParameter("password");
        this.repeatpassword = req.getParameter("repeatedPassword");
        this.email = req.getParameter("account.email");
        this.firstName = req.getParameter("account.firstName");
        this.lastName = req.getParameter("account.lastName");
        this.AuthCode = req.getParameter("authcode");
        this.phone = req.getParameter("account.phone");
        this.address1 = req.getParameter("account.address1");
        this.address2 = req.getParameter("account.address2");
        this.city = req.getParameter("account.city");
        this.state = req.getParameter("account.state");
        this.zip = req.getParameter("account.zip");
        this.country = req.getParameter("account.country");
        this.favouriteCategoryId=req.getParameter("account.favouriteCategoryId");
        this.state="ok";
        this.languagePreference="english";

        if(!validate())
        {
            req.setAttribute("registerMsg",this.registerMsg);
            req.getRequestDispatcher(REGISTER_FORM).forward(req,resp);
        }
        else {
            Account Register_account =new Account();
            Register_account.setUsername(this.username);
            Register_account.setCity(this.city);
            Register_account.setAddress1(this.address1);
            Register_account.setAddress2(this.address2);
            Register_account.setCountry(this.country);
            Register_account.setEmail(this.email);
            Register_account.setFirstName(this.firstName);
            Register_account.setStatus(this.status);
            Register_account.setPassword(this.password);
            Register_account.setFavouriteCategoryId(this.favouriteCategoryId);
            Register_account.setLastName(this.lastName);
            Register_account.setLanguagePreference(this.languagePreference);
            Register_account.setPhone(this.phone);
            Register_account.setZip(this.zip);
            Register_account.setState(this.state);
            Register_account.setBannerOption(true);
            Register_account.setListOption(true);
            HttpSession session=req.getSession();
            AccountService accountService=new AccountService();
            accountService.insertAccount(Register_account);
            resp.sendRedirect("signonForm");
            String username=(String) session.getAttribute("username");
            if(username==null)
            {username="1234";}
            NDC.push(username);
            String oo="用户注册";
            log.error(oo);
            NDC.remove();


        }


    }

        private boolean validate(){
           AccountService accountService=new AccountService();
           Account account=accountService.getAccountbyUserID(this.username);
            if(this.username==null||this.username.equals("")){
                this.registerMsg ="用户名不能为空";
                return false;
            }
            if(this.password==null||this.password.equals("")){
                this.registerMsg ="密码不能为空";
                return false;
            }
            if(this.repeatpassword==null||this.repeatpassword.equals("")){
                this.registerMsg ="重复密码不能为空";
                return false;
            }
            if(this.country==null||this.country.equals("")){
                this.registerMsg ="国家不能为空";
                return false;
            }
            if(this.city==null||this.city.equals("")){
                this.registerMsg ="城市不能为空";
                return false;
            }
            if(this.address1==null||this.address1.equals("")){
                this.registerMsg ="地址不能为空";
                return false;
            }
            if(this.address2==null||this.address2.equals("")){
                this.registerMsg ="地址不能为空";
                return false;
            }
            if(this.AuthCode==null||this.AuthCode.equals("")){
                this.registerMsg ="验证码不能为空";
                return false;
            }
            if(this.phone==null||this.phone.equals("")){
                this.registerMsg ="电话不能为空";
                return false;
            }
            if(!(this.password.equals(this.repeatpassword))){
                this.registerMsg ="两次密码不一致";
                return false;
            }
            if(!(this.AuchCode_1.equals(this.AuthCode))){
                this.registerMsg ="验证码错误";
                return false;
            }
            if(account!=null){
                this.registerMsg ="账号存在";
                return false;
            }
            return true;
        }

    }






