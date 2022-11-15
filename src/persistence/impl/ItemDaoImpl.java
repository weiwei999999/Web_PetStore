package src.persistence.impl;


import src.domain.Category;
import src.domain.Item;
import src.domain.Product;
import src.persistence.DBUtil;
import src.persistence.ItemDao;
import src.persistence.ProductDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ItemDaoImpl implements ItemDao {
    private static final String GET_ITEM=
            "select I.ITEMID, LISTPRICE, UNITCOST, SUPPLIER AS supplierId, I.PRODUCTID AS \"product.productId\", NAME AS \"product.name\", DESCN AS \"product.description\", CATEGORY AS \"product.categoryId\", STATUS, ATTR1 AS attribute1, ATTR2 AS attribute2, ATTR3 AS attribute3, ATTR4 AS attribute4, ATTR5 AS attribute5, QTY AS quantity from ITEM I, INVENTORY V, PRODUCT P where P.PRODUCTID = I.PRODUCTID  and I.ITEMID = V.ITEMID  and I.ITEMID =?";
    private static final String updateInventoryQuantity=
            "UPDATE INVENTORY SET  QTY = QTY - ?  WHERE ITEMID =?";
    private static final String getInventoryQuantitystring=
            "SELECT QTY AS QUANTITY FROM INVENTORY WHERE ITEMID = ?";
    private static final String getItemListByProductstring=
            "SELECT I.ITEMID,LISTPRICE,UNITCOST,SUPPLIER AS supplierId,I.PRODUCTID AS productId,NAME AS productName,DESCN AS productDescription,CATEGORY AS categoryId,STATUS,ATTR1 AS attribute1,ATTR2 AS attribute2,ATTR3 AS attribute3,ATTR4 AS attribute4,ATTR5 AS attribute5 FROM ITEM I, PRODUCT P WHERE P.PRODUCTID = I.PRODUCTID AND I.PRODUCTID = ?";
    @Override
    public void updateInventoryQuantity(Map<String, Object> param) {
try{
    Connection connection=DBUtil.getConnection();
   PreparedStatement pStatement =connection.
           prepareStatement(updateInventoryQuantity);
    String itemId =param.keySet().iterator().next();
    Integer increment =(Integer) param.get(itemId);
    pStatement.setInt(1,increment.intValue());
    pStatement.setString(2,itemId);
    pStatement.executeUpdate();
    DBUtil.closeStatement(pStatement);
    DBUtil.closeConnection(connection);
}
catch (Exception e)
{
    e.printStackTrace();
}
    }

    @Override
    public int getInventoryQuantity(String itemid) {
        int result=-1;
        try{
            Connection connection =DBUtil.getConnection();
            PreparedStatement pStatement =connection.prepareStatement(getInventoryQuantitystring);
            pStatement.setString(1,itemid);
            ResultSet resultSet=pStatement.executeQuery();
            if(resultSet.next())
            {
                result=resultSet.getInt(1);
            }

            DBUtil.closeResultSet(resultSet);
            DBUtil.closeStatement(pStatement);
            DBUtil.closeConnection(connection);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<Item> getItemListByProduct(String productId) {
        List<Item> itemList=new ArrayList<Item>();
        try {
            Connection connection =DBUtil.getConnection();
            PreparedStatement pStatement =connection.prepareStatement(getItemListByProductstring);
            pStatement.setString(1,productId);
            ResultSet resultSet=pStatement.executeQuery();
            while(resultSet.next())
            {
               Item item =new Item();
                item.setItemId(resultSet.getString(1));
                item.setListPrice(resultSet.getBigDecimal(2));
                item.setUnitCost(resultSet.getBigDecimal(3));
                item.setSupplierId(resultSet.getInt(4));
                Product product = new Product();
                product.setProductId(resultSet.getString(5));
                product.setName(resultSet.getString(6));
                product.setDescription(resultSet.getString(7));
                product.setCategoryId(resultSet.getString(8));
                item.setProduct(product);
                item.setStatus(resultSet.getString(9));
                item.setAttribute1(resultSet.getString(10));
                item.setAttribute2(resultSet.getString(11));
                item.setAttribute3(resultSet.getString(12));
                item.setAttribute4(resultSet.getString(13));
                item.setAttribute5(resultSet.getString(14));
                itemList.add(item);

                }
            DBUtil.closeResultSet(resultSet);
            DBUtil.closeStatement(pStatement);
            DBUtil.closeResultSet(resultSet);

        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return itemList;
    }

    @Override
    public Item getItem(String itemId) {
        Item item=null;
        try{
            Connection connection = DBUtil.getConnection();
            PreparedStatement preparedStatement=connection.prepareStatement(GET_ITEM);
            preparedStatement.setString(1,itemId);
//            ResultSet resultSet =preparedStatement.executeQuery(GET_ITEM);
            ResultSet resultSet =preparedStatement.executeQuery();
            if (resultSet.next())
            {
                item=new Item();
                item.setItemId(resultSet.getString(1));
                item.setListPrice(resultSet.getBigDecimal(2));
                item.setUnitCost(resultSet.getBigDecimal(3));
                item.setSupplierId(resultSet.getInt(4));
                Product product =new Product();
                product.setProductId(resultSet.getString(5));
                product.setName(resultSet.getString(6));
                product.setDescription(resultSet.getString(7));
                product.setCategoryId(resultSet.getString(8));
                item.setProduct(product);
                item.setStatus(resultSet.getString(9));
                item.setAttribute1(resultSet.getString(10));
                item.setAttribute2(resultSet.getString(11));
                item.setAttribute3(resultSet.getString(12));
                item.setAttribute4(resultSet.getString(13));
                item.setAttribute5(resultSet.getString(14));

            }
            DBUtil.closeResultSet(resultSet);
            DBUtil.closeStatement(preparedStatement);
            DBUtil.closeConnection(connection);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
return item;
    }
}
