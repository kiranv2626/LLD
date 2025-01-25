package inventory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Inventory {
    List<ProductCategory> categories ;

    public Inventory() {
        categories = new ArrayList<>();
    }

    public List<ProductCategory> getCategories() {
        return categories;
    }

    public void setCategories(List<ProductCategory> categories) {
        this.categories = categories;
    }
    public void addCategory(int Id, String CategoryName, double price) {
        ProductCategory category = new ProductCategory();
        category.setCategoryId(Id);
        category.setCategoryName(CategoryName);
        category.setPrice(price);
        categories.add(category);
    }
    public void addProduct(int CategoryId, Product product) {
        for(ProductCategory category : categories) {
            if(category.getCategoryId() == CategoryId) {
                category.addProduct(product);
                return;
            }
        }
    }

    public void removeItem(Map<Integer, Integer> prodctCategoryvsCount) {
        for(Map.Entry<Integer, Integer> entry : prodctCategoryvsCount.entrySet()) {
            ProductCategory category = getCategory(entry.getKey());
            category.removeProduct(entry.getValue());
        }
    }

    public void addItem(Map<Integer, Integer> prodctCategoryvsCount) {
        for(Map.Entry<Integer, Integer> entry : prodctCategoryvsCount.entrySet()) {
            ProductCategory category = getCategory(entry.getKey());

            category.addItem(entry.getValue(), category.products.get(0));
        }
    }

    public ProductCategory getCategory(int CategoryId) {
        for(ProductCategory category : categories) {
            if(category.getCategoryId() == CategoryId) {
                return category;
            }
        }
        return null;
    }
}
