package kanakExamples;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Product {
     private Integer productId;
     private String productName;
     private String category;
     private BigDecimal price;
     private String currency;

     @Override
     public String toString() {
          return "{" +
               "productId=" + productId +
               ", productName='" + productName + '\'' +
               ", category='" + category + '\'' +
               ", price=" + price +
               ", currency='" + currency + '\'' +
               '}';
     }

     public BigDecimal getPrice() {
          return price;
     }

     public void setPrice(BigDecimal price) {
          this.price = price;
     }

     public Integer getProductId() {
          return productId;
     }

     public void setProductId(Integer productId) {
          this.productId = productId;
     }

     public String getProductName() {
          return productName;
     }

     public void setProductName(String productName) {
          this.productName = productName;
     }

     public String getCategory() {
          return category;
     }

     public void setCategory(String category) {
          this.category = category;
     }

     public String getCurrency() {
          return currency;
     }

     public void setCurrency(String currency) {
          this.currency = currency;
     }

     public Product() {
     }

     public Product(Integer productId, String productName, String category, BigDecimal price, String currency) {
          this.productId = productId;
          this.productName = productName;
          this.category = category;
          this.price = price;
          this.currency = currency;
     }

     public List<Product> getMockProducts() {
          List<Product> products = new LinkedList<>();
          products.add(new Product(0, "Wireless Mouse", "Electronics", new BigDecimal("999.00"), "USD"));
          products.add(new Product(1, "Gaming Keyboard", "Electronics", new BigDecimal("1499.00"), "USD"));
          products.add(new Product(2, "Bluetooth Speaker", "Electronics", new BigDecimal("1999.00"), "USD"));
          products.add(new Product(3, "Fitness Tracker", "Wearable", new BigDecimal("2499.00"), "USD"));
          products.add(new Product(4, "Running Shoes", "Footwear", new BigDecimal("3499.00"), "USD"));
          products.add(new Product(5, "Formal Shirt", "Clothing", new BigDecimal("799.00"), "USD"));
          products.add(new Product(6, "LED Monitor", "Electronics", new BigDecimal("8999.00"), "USD"));
          products.add(new Product(7, "Coffee Maker", "Appliances", new BigDecimal("2999.00"), "USD"));
          products.add(new Product(8, "Smartphone Case", "Accessories", new BigDecimal("499.00"), "USD"));
          products.add(new Product(9, "Water Bottle", "Accessories", new BigDecimal("299.00"), "USD"));
          return products.stream().filter(Objects::nonNull).toList();
     }
}
