package src.service;

import src.domain.Category;
import src.domain.Item;
import src.domain.Product;
import src.persistence.CategoryDao;
import src.persistence.ItemDao;
import src.persistence.ProductDao;
import src.persistence.impl.CategoryDaoImpl;
import src.persistence.impl.ItemDaoImpl;
import src.persistence.impl.ProductDaoImpl;

import java.util.ArrayList;
import java.util.List;

public class CatalogService {
    private CategoryDao categoryDao;
    private ProductDao productDao;
    private ItemDao itemDao;

   public CatalogService() {
       this.categoryDao = new CategoryDaoImpl();
       this.productDao = new ProductDaoImpl();
       this.itemDao = new ItemDaoImpl();
   }
       public List<Category> getCategoryList() {
       return categoryDao.getCategoryList();
   }

       public Category getCategory(String categoryId) {
       return categoryDao.getCategory(categoryId);
   }

       public Product getProduct(String productId) {
       return productDao.getProduct(productId);
   }

       public List<Product> getProductListByCategory(String categoryId) {
       return productDao.getProductListByCategory(categoryId);
   }

       // TODO enable using more than one keyword
       public List<Product> searchProductList(String keyword) {

           List<Product> products=productDao.getAllProduct();
           List<Product> result=new ArrayList<>();
           for(int i=0;i<products.size();i++){
               System.out.println(keyword);
               System.out.println(products.get(i).getName());
               if(products.get(i).getName().contains(keyword) && !result.contains(products.get(i))){
                   result.add(products.get(i));
               }

               if(products.get(i).getProductId().contains(keyword) && !result.contains(products.get(i))){
                   result.add(products.get(i));
               }

               if(products.get(i).getCategoryId().contains(keyword) && !result.contains(products.get(i))){
                   result.add(products.get(i));
               }


           }

           return result;
       }

       public List<Item> getItemListByProduct(String productId) {
       return itemDao.getItemListByProduct(productId);
   }

       public Item getItem(String itemId) {
       return itemDao.getItem(itemId);
   }

       public boolean isItemInStock(String itemId) {
       return itemDao.getInventoryQuantity(itemId) > 0;
   }

    }

