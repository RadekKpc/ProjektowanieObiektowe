package pl.edu.agh.internetshop;

public class ProductNameStrategy implements SearchStrategy {
    String productName;

    public ProductNameStrategy(String productName) {
        this.productName = productName;
    }

    @Override
    public boolean filter(OrderLog o) {
        return o.order.getProducts().stream().anyMatch(p -> p.getName().equals(this.productName));
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}
