package kanakExamples;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Order {
     private Integer orderId;

     @Override
     public String toString() {
          return "{" +
               "orderId=" + orderId +
               ", productId=" + productId.getProductName() +
               ", orderAmount=" + orderAmount +
               ", quantity=" + quantity +
               ", paymentMode='" + paymentMode + '\'' +
               ", orderStatus='" + orderStatus + '\'' +
               ", source='" + source + '\'' +
               '}';
     }

     private Product productId;
     private BigDecimal orderAmount;
     private Integer quantity;
     private String paymentMode;
     private String orderStatus;
     private String source;

     public Integer getOrderId() {
          return orderId;
     }

     public void setOrderId(Integer orderId) {
          this.orderId = orderId;
     }

     public Product getProductId() {
          return productId;
     }

     public void setProductId(Product productId) {
          this.productId = productId;
     }

     public Integer getQuantity() {
          return quantity;
     }

     public void setQuantity(Integer quantity) {
          this.quantity = quantity;
     }

     public String getPaymentMode() {
          return paymentMode;
     }

     public void setPaymentMode(String paymentMode) {
          this.paymentMode = paymentMode;
     }

     public BigDecimal getOrderAmount() {
          return orderAmount;
     }

     public void setOrderAmount(BigDecimal orderAmount) {
          this.orderAmount = orderAmount;
     }

     public String getOrderStatus() {
          return orderStatus;
     }

     public void setOrderStatus(String orderStatus) {
          this.orderStatus = orderStatus;
     }

     public String getSource() {
          return source;
     }

     public Order() {
     }

     public void setSource(String source) {
          this.source = source;
     }

     public Order(Integer orderId, Product productId, BigDecimal orderAmount, Integer quantity, String paymentMode, String orderStatus, String source) {
          this.orderId = orderId;
          this.productId = productId;
          this.orderAmount = orderAmount;
          this.quantity = quantity;
          this.paymentMode = paymentMode;
          this.orderStatus = orderStatus;
          this.source = source;
     }

     public List<Order> getMockOrders(List<Product> products) {
          List<Order> orders = new ArrayList<>();
          orders.add(new Order(1001, products.get(1), new BigDecimal("1998.00"), 2, "UPI", "Confirmed", null));
          orders.add(new Order(1002, products.get(1), new BigDecimal("1499.00"), 1, "Credit Card", "Shipped", "WebSite"));
          orders.add(new Order(1003, products.get(2), new BigDecimal("3998.00"), 2, "Net Banking", "Delivered", "Mobile"));
          orders.add(new Order(1003, products.get(2), new BigDecimal("0.00"), 0, "UPI", "Cancelled", "WebSite"));
          orders.add(new Order(1005, products.get(3), new BigDecimal("2499.00"), 1, "Cash", "Pending", "RetailStore"));
          orders.add(new Order(1006, products.get(4), new BigDecimal("6998.00"), 2, "Cash", "Confirmed", "RetailStore"));
          orders.add(new Order(1007, products.get(5), new BigDecimal("1598.00"), 2, "Cash", "Pending", "WebSite"));
          orders.add(new Order(1008, products.get(8), new BigDecimal("998.00"), 2, "UPI", "Delivered", "Mobile"));
          orders.add(new Order(1009, products.get(7), new BigDecimal("2999.00"), 1, "Credit Card", "Shipped", "WebSite"));
          orders.add(new Order(1010, products.get(9), new BigDecimal("299.00"), 1, "UPI", "Confirmed", "RetailStore"));
          orders.add(new Order(1011, products.get(9), new BigDecimal("299.00"), 1, "UPI", "Confirmed", "RetailStore"));
          return orders.stream().filter(Objects::nonNull).toList();
     }
}
