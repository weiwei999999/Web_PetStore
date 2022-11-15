package src.persistence.impl;

import src.domain.Account;
import src.persistence.AccountDao;
import src.persistence.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class AccountDaoImpl implements AccountDao {
    //我他妈来了

    private static final String GET_ACCOUNT_BY_USERNAME_AND_PASSWORD = "SELECT " +
            "SIGNON.USERNAME," +
            "ACCOUNT.EMAIL,ACCOUNT.FIRSTNAME,ACCOUNT.LASTNAME,ACCOUNT.STATUS," +
            "ACCOUNT.ADDR1 AS address1,ACCOUNT.ADDR2 AS address2," +
            "ACCOUNT.CITY,ACCOUNT.STATE,ACCOUNT.ZIP,ACCOUNT.COUNTRY,ACCOUNT.PHONE," +
            "PROFILE.LANGPREF AS languagePreference,PROFILE.FAVCATEGORY AS favouriteCategoryId," +
            "PROFILE.MYLISTOPT AS listOption,PROFILE.BANNEROPT AS bannerOption," +
            "BANNERDATA.BANNERNAME " +
            "FROM ACCOUNT, PROFILE, SIGNON, BANNERDATA " +
            "WHERE ACCOUNT.USERID = ? AND SIGNON.PASSWORD = ? " +
            "AND SIGNON.USERNAME = ACCOUNT.USERID " +
            "AND PROFILE.USERID = ACCOUNT.USERID " +
            "AND PROFILE.FAVCATEGORY = BANNERDATA.FAVCATEGORY";
    private static final String GET_ACCOUNT_BY_USERNAME="SELECT " +
            "SIGNON.USERNAME," +
            "ACCOUNT.EMAIL,ACCOUNT.FIRSTNAME,ACCOUNT.LASTNAME,ACCOUNT.STATUS," +
            "ACCOUNT.ADDR1 AS address1,ACCOUNT.ADDR2 AS address2," +
            "ACCOUNT.CITY,ACCOUNT.STATE,ACCOUNT.ZIP,ACCOUNT.COUNTRY,ACCOUNT.PHONE," +
            "PROFILE.LANGPREF AS languagePreference,PROFILE.FAVCATEGORY AS favouriteCategoryId," +
            "PROFILE.MYLISTOPT AS listOption,PROFILE.BANNEROPT AS bannerOption," +
            "BANNERDATA.BANNERNAME " +
            "FROM ACCOUNT, PROFILE, SIGNON, BANNERDATA " +
            "WHERE ACCOUNT.USERID = ?" +
            "AND SIGNON.USERNAME = ACCOUNT.USERID " +
            "AND PROFILE.USERID = ACCOUNT.USERID " +
            "AND PROFILE.FAVCATEGORY = BANNERDATA.FAVCATEGORY";
    private static  final  String insert_Account="INSERT INTO ACCOUNT\n" +
            "      (USERID,EMAIL, FIRSTNAME, LASTNAME, STATUS, ADDR1, ADDR2, CITY, STATE, ZIP, COUNTRY, PHONE)\n" +
            "    VALUES\n" +
            "      (?, ?, ?, ?,?, ?, ?, ?, ?, ?, ?, ?)";
    private static  final  String insert_Profile="INSERT INTO PROFILE (USERID, LANGPREF, FAVCATEGORY,mylistopt,banneropt)\n" +
            "    VALUES (?,?, ?,?,?)";
    private static  final  String insert_Signon="INSERT INTO SIGNON (PASSWORD,USERNAME)" +
            "VALUES (?, ?)";
    private static  final  String update_Account="UPDATE ACCOUNT SET\n" +
            " EMAIL = ?,FIRSTNAME = ?,LASTNAME = ?,STATUS =?,ADDR1 = ?,"+
   "ADDR2 =? ,CITY = ? ,STATE =? ,ZIP =? ,COUNTRY = ?, PHONE = ? "
            +"WHERE USERID=?";
    private static  final  String update_Profile="UPDATE PROFILE SET " +
            "LANGPREF =?," +
            "FAVCATEGORY = ? "+
            "WHERE USERID=?";
    private static  final  String update_Signon= "UPDATE SIGNON SET PASSWORD = ?"
                                                          + "WHERE USERNAME = ?"  ;
    @Override
    public Account getAccountByUsername(String username) {
        Account accountResult =null;
        try{
            Connection connection=DBUtil.getConnection();
            PreparedStatement preparedStatement =connection.prepareStatement(GET_ACCOUNT_BY_USERNAME);
            preparedStatement.setString(1,username);
            ResultSet resultSet =preparedStatement.executeQuery();
            if(resultSet.next())
            {
                accountResult = this.resultSetToAccount(resultSet);
            }
            DBUtil.closeResultSet(resultSet);
            DBUtil.closeStatement(preparedStatement);
            DBUtil.closeConnection(connection);

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    return accountResult;
    }

    @Override
    public Account getAccountByUsernameAndPassword(Account account) {
        Account accountResult = null;
        try {
            Connection connection = DBUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(GET_ACCOUNT_BY_USERNAME_AND_PASSWORD);
            preparedStatement.setString(1, account.getUsername());
            preparedStatement.setString(2, account.getPassword());
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                accountResult = this.resultSetToAccount(resultSet);
            }
            DBUtil.closeResultSet(resultSet);
            DBUtil.closeStatement(preparedStatement);
            DBUtil.closeConnection(connection);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return accountResult;
    }

    private Account resultSetToAccount(ResultSet resultSet) throws Exception {
        Account account = new Account();
        account.setUsername(resultSet.getString("username"));
//        account.setPassword(resultSet.getString("password"));
        account.setEmail(resultSet.getString("email"));
        account.setFirstName(resultSet.getString("firstName"));
        account.setLastName(resultSet.getString("lastName"));
        account.setStatus(resultSet.getString("status"));
        account.setAddress1(resultSet.getString("address1"));
        account.setAddress2(resultSet.getString("address2"));
        account.setCity(resultSet.getString("city"));
        account.setState(resultSet.getString("state"));
        account.setZip(resultSet.getString("zip"));
        account.setCountry(resultSet.getString("country"));
        account.setPhone(resultSet.getString("phone"));
        account.setFavouriteCategoryId(resultSet.getString("favouriteCategoryId"));
        account.setLanguagePreference(resultSet.getString("languagePreference"));
        account.setListOption(resultSet.getInt("listOption") == 1);
        account.setBannerOption(resultSet.getInt("bannerOption") == 1);
        account.setBannerName(resultSet.getString("bannerName"));
        return account;
    }

    @Override
    public void insertAccount(Account account) {
         try{
             Connection connection=DBUtil.getConnection();
             PreparedStatement preparedStatement=connection.prepareStatement(insert_Account);
             preparedStatement.setString(1,account.getUsername());
             preparedStatement.setString(2,account.getEmail());
             preparedStatement.setString(3,account.getFirstName());
             preparedStatement.setString(4,account.getLastName());
             preparedStatement.setString(5,account.getStatus());
             preparedStatement.setString(6,account.getAddress1());
             preparedStatement.setString(7,account.getAddress2());
             preparedStatement.setString(8,account.getCity());
             preparedStatement.setString(9,account.getState());
             preparedStatement.setString(10,account.getZip());
             preparedStatement.setString(11,account.getCountry());
             preparedStatement.setString(12,account.getPhone());
             preparedStatement.executeUpdate();
             DBUtil.closeStatement(preparedStatement);
             DBUtil.closeConnection(connection);

         }
         catch (Exception e)
         {
             e.printStackTrace();
         }


    }

    @Override
    public void insertProfile(Account account) {
   try{
       Connection connection=DBUtil.getConnection();
       PreparedStatement preparedStatement=connection.prepareStatement(insert_Profile);
       preparedStatement.setString(1,account.getUsername());
       preparedStatement.setString(2,account.getLanguagePreference());
       preparedStatement.setString(3,account.getFavouriteCategoryId());

       if(account.isBannerOption())
       {
           preparedStatement.setString(4,"1");
       }
       if(account.isListOption())
       {
           preparedStatement.setString(5,"1");
       }


       preparedStatement.executeUpdate();
       DBUtil.closeStatement(preparedStatement);
       DBUtil.closeConnection(connection);

   }catch (Exception e)
   {
       e.printStackTrace();
   }
    }

    @Override
    public void insertSignon(Account account) {
        try{
            Connection connection=DBUtil.getConnection();
            PreparedStatement preparedStatement=connection.prepareStatement(insert_Signon);
            preparedStatement.setString(2,account.getUsername());
            preparedStatement.setString(1,account.getPassword());
            preparedStatement.executeUpdate();
            DBUtil.closeStatement(preparedStatement);
            DBUtil.closeConnection(connection);

        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }


    @Override
    public void updateAccount(Account account) {
        try{
            Connection connection=DBUtil.getConnection();
            PreparedStatement preparedStatement=connection.prepareStatement(update_Account);
            preparedStatement.setString(12,account.getUsername());
            preparedStatement.setString(1,account.getEmail());
            preparedStatement.setString(2,account.getFirstName());
            preparedStatement.setString(3,account.getLastName());
            preparedStatement.setString(4,account.getStatus());
            preparedStatement.setString(5,account.getAddress1());
            preparedStatement.setString(6,account.getAddress2());
            preparedStatement.setString(7,account.getCity());
            preparedStatement.setString(8,account.getState());
            preparedStatement.setString(9,account.getZip());
            preparedStatement.setString(10,account.getCountry());
            preparedStatement.setString(11,account.getPhone());
            preparedStatement.executeUpdate();
            DBUtil.closeStatement(preparedStatement);
            DBUtil.closeConnection(connection);

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }

    @Override
    public void updateProfile(Account account) {
        try{
            Connection connection=DBUtil.getConnection();
            PreparedStatement preparedStatement=connection.prepareStatement(update_Profile);
            preparedStatement.setString(3,account.getUsername());
            preparedStatement.setString(1,account.getLanguagePreference());
            preparedStatement.setString(2,account.getFavouriteCategoryId());




            preparedStatement.executeUpdate();
            DBUtil.closeStatement(preparedStatement);
            DBUtil.closeConnection(connection);

        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }


    @Override
    public void updateSignon(Account account) {
        try{
            Connection connection=DBUtil.getConnection();
            PreparedStatement preparedStatement=connection.prepareStatement(update_Signon);
            preparedStatement.setString(2,account.getUsername());
            preparedStatement.setString(1, account.getPassword());
            preparedStatement.executeUpdate();
            DBUtil.closeStatement(preparedStatement);
            DBUtil.closeConnection(connection);

        }catch (Exception e)
        {
            e.printStackTrace();
        }

    }

   // public static void main(String[] args) {
     //   AccountDao accountDao = new AccountDaoImpl();
     //   Account account = new Account();
      //  account.setUsername("j2ee");
       // account.setPassword("j2ee");
       // Account result = accountDao.getAccountByUsernameAndPassword(account);
      //  System.out.println("success");
   // }
}
