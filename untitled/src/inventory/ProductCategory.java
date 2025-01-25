package inventory;

import java.util.ArrayList;
import java.util.List;

public class ProductCategory {
    int categoryId;
    String categoryName;
    List<Product> products= new ArrayList<>();
    double price;

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public  void addProduct(Product product) {
        products.add(product);
    }

    public void addItem(int count,Product product) {
        for(int i=0;i<count;i++)
        {
            products.add(product);
        }
    }

    public  void removeProduct(int count) {
        for(int i=0;i<count;i++)
        {
            products.remove(0);
        }
    }
}
