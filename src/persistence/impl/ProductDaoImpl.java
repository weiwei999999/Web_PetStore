package src.persistence.impl;

import src.domain.Product;
import src.persistence.DBUtil;
import src.persistence.ProductDao;

import javax.swing.text.html.StyleSheet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoImpl implements ProductDao {
    private static final String getProductListByCategoryString=
            "SELECT  PRODUCTID, NAME,  DESCN as description, CATEGORY as categoryId FROM PRODUCT  WHERE CATEGORY = ? ";
    private  static final String getProduct=
            "SELECT PRODUCTID,  NAME, DESCN as description,  CATEGORY as categoryId FROM PRODUCT WHERE PRODUCTID = ?";
    private static  final String searchProductList=
            "select  PRODUCTID,  NAME, DESCN as description, CATEGORY as categoryId from PRODUCT WHERE lower(name) like ?";
    private static final String getAllProductList=
            "SELECT  PRODUCTID, NAME,  DESCN as description, CATEGORY as categoryId FROM PRODUCT";
    @Override
    public List<Product> getProductListByCategory(String categoryId) {
       List<Product> products =new ArrayList<>();
       try{
           Connection connection= DBUtil.getConnection();
           PreparedStatement preparedStatement=connection.prepareStatement(getProductListByCategoryString);
           preparedStatement.setString(1,categoryId);
           ResultSet resultSet=preparedStatement.executeQuery();
           while(resultSet.next())
           {
               Product product=new Product();
               product.setProductId(resultSet.getString(1));
               product.setName(resultSet.getString(2));
               product.setDescription(resultSet.getString(3));
               product.setCategoryId(resultSet.getString(4));
               products.add(product);
           }
           DBUtil.closeResultSet(resultSet);
           DBUtil.closeStatement(preparedStatement);
           DBUtil.closeConnection(connection);

       }
       catch (Exception e)
       {
           e.printStackTrace();
       }
       return products;
    }

    @Override
    public Product getProduct(String var1) {
        Product product=null;
        try{
            Connection connection= DBUtil.getConnection();
            PreparedStatement preparedStatement=connection.prepareStatement(getProduct);
//            ResultSet resultSet=preparedStatement.executeQuery(getProduct)
        preparedStatement.setString(1,var1);;
            ResultSet resultSet=preparedStatement.executeQuery();
            if(resultSet.next())
            {
                product=new Product();
                product.setProductId(resultSet.getString(1));
                product.setName(resultSet.getString(2));
                product.setDescription(resultSet.getString(3));
                product.setCategoryId(resultSet.getString(4));

            }
            DBUtil.closeResultSet(resultSet);
            DBUtil.closeStatement(preparedStatement);
            DBUtil.closeConnection(connection);

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
     return product;
    }

    @Override
    public List<Product> searchProductList(String keywords) {
        List<Product> productList=new ArrayList<Product>();
        try{
            Connection connection=DBUtil.getConnection();
            PreparedStatement preparedStatement=connection.prepareStatement(searchProductList);
            preparedStatement.setString(1,keywords);
            ResultSet resultSet=preparedStatement.executeQuery();
            while(resultSet.next())
            {
                Product product=new Product();
                product.setProductId(resultSet.getString(1));
                product.setName(resultSet.getString(2));
                product.setDescription(resultSet.getString(3));
                product.setCategoryId(resultSet.getString(4));
                productList.add(product);
            }
            DBUtil.closeResultSet(resultSet);
            DBUtil.closeStatement(preparedStatement);
            DBUtil.closeConnection(connection);
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return productList;
    }
    @Override
    public List<Product> getAllProduct() {
        List<Product> products =new ArrayList<>();
        try{
            Connection connection= DBUtil.getConnection();
            PreparedStatement preparedStatement=connection.prepareStatement(getAllProductList);
            ResultSet resultSet=preparedStatement.executeQuery();
            while(resultSet.next())
            {
                Product product=new Product();
                product.setProductId(resultSet.getString(1));
                product.setName(resultSet.getString(2));
                product.setDescription(resultSet.getString(3));
                product.setCategoryId(resultSet.getString(4));
                products.add(product);
            }


            DBUtil.closeResultSet(resultSet);
            DBUtil.closeStatement(preparedStatement);
            DBUtil.closeConnection(connection);

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return products;
    }


}

