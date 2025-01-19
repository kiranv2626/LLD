package facade;

public class ProductDao {
    public ProductDao getProduct() {
        System.out.println("ProductDao");
        return new ProductDao();
    }
}
