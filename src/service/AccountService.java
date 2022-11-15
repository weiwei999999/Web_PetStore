package src.service;

import src.domain.Account;
import src.persistence.AccountDao;
import src.persistence.impl.AccountDaoImpl;

public class AccountService {
    private AccountDao accountDao;
    public AccountService(){
       this.accountDao=new AccountDaoImpl();

    }
    public Account getAccount(String username, String password) {
        Account account = new Account();
        account.setUsername(username);
        account.setPassword(password);
        return this.accountDao.getAccountByUsernameAndPassword(account);
    }
    public Account getAccountbyUserID(String username) {
        Account account = new Account();
        account.setUsername(username);
        return this.accountDao.getAccountByUsername(username);
    }


    public void insertAccount(Account account) {
        this.accountDao.insertAccount(account);
        this.accountDao.insertProfile(account);
        this.accountDao.insertSignon(account);
    }

    public void updateAccount(Account account) {
        this.accountDao.updateAccount(account);
        this.accountDao.updateProfile(account);
        this.accountDao.updateSignon(account);
    }
}
