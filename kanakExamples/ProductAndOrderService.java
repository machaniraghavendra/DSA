package kanakExamples;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class ProductAndOrderService {
     public static void main(String[] args) {
//          Scanner scanner = new Scanner(System.in);
          List<Product> products = new Product().getMockProducts();
          List<Order> orders = new Order().getMockOrders(products);
//          System.out.println("List of orders placed by source");
//          System.out.println(getAllOrdersPlacedBySource(orders, "Mobile"));
//          System.out.println("List of product names");
//          System.out.println(getListOfProductNames(products));
//          System.out.println("List of order for product");
//          System.out.println(getAllOrdersForProduct(orders));
//          System.out.println("List of orders based on product id");
//          System.out.println(getAllOrdersForProductId(orders, 2));
//          System.out.println("Get total order amount for product");
////          String productName = scanner.nextLine();
//          System.out.println("Formal Shirt" + " : " + getTotalRevenueOfProduct(orders, "Formal Shirt"));
//          System.out.println("List of methods used in order : ");
//          System.out.println(getDistinctListOfMethodsUsedInOrders(orders));
//          System.out.println(getTopTwoProductsWithHighestPrice(products));
//          System.out.println(getDuplicateOrders(orders));
          System.out.println(getTotalOrdersQuantitySoldForProduct(orders, products));
//          System.out.println(getProductWhichHasHighestRevenue(orders));
     }

     private static List<Order> getAllOrdersPlacedBySource(List<Order> orders, String source) {
//          return orders.stream().filter(order -> order.getSource().equals(source)).toList();
//          return orders.stream().filter(order -> order.getSource()!=null && order.getSource().equals(source)).toList();
          return orders.stream().filter(order -> source.equals(order.getSource())).toList();
     }

     private static List<String> getListOfProductNames(List<Product> products) {
          return products.stream().map(Product::getProductName).filter(Objects::nonNull).toList();
     }

     private static Map<Integer, List<Integer>> getAllOrdersForProduct(List<Order> orders) {
          return orders.stream().collect(groupingBy(o -> o.getProductId().getProductId(), Collectors.mapping(Order::getOrderId, Collectors.toList())));
     }

     private static Map<Integer, List<Integer>> getAllOrdersForProductId(List<Order> orders, int productId) {
          return orders.stream().filter(order -> productId == order.getProductId().getProductId())
//               .collect(Collectors.toMap(order -> order.getProductId().getProductId(), order -> {
//                    var id = order.getOrderId();
//                    return new ArrayList<>(List.of(id));
//               }, (a, b) -> {
//                    a.addAll(b);
//                    return a;
//               }));
               .collect(Collectors.groupingBy(order -> order.getProductId().getProductId(), Collectors.mapping(Order::getOrderId, Collectors.toList())));
     }

     private static BigDecimal getTotalRevenueOfProduct(List<Order> orders, String productName) {
          return orders.stream().filter(order -> productName.equals(order.getProductId().getProductName()))
               .map(Order::getOrderAmount).reduce(BigDecimal::add).orElse(BigDecimal.ZERO);
     }

     private static List<String> getDistinctListOfMethodsUsedInOrders(List<Order> orders) {
          return orders.stream().map(Order::getPaymentMode).distinct().toList();
     }

     private static List<Product> getTopTwoProductsWithHighestPrice(List<Product> products) {
          return products.stream().sorted(Comparator.comparing(Product::getPrice).reversed()).limit(2).toList();
     }

     private static List<Order> getDuplicateOrders(List<Order> orders) {
          return orders.stream().collect(groupingBy(Order::getOrderId)).values()
               .stream().filter(orderList -> orderList.size() > 1).findFirst().orElse(new ArrayList<>());
     }

     private static Map<String, Integer> getTotalOrdersQuantitySoldForProduct(List<Order> orders, List<Product> products) {
//          O(N) + O(M)
          var map = orders.stream().collect(groupingBy(order -> order.getProductId().getProductId(), Collectors.collectingAndThen(counting(), Long::intValue)));
          return products.stream().collect(toMap(Product::getProductName, p -> map.getOrDefault(p.getProductId(), 0)));

//          O(N) * O(M)
//          return products.stream().collect(toMap(Product::getProductName, p ->
//               orders.stream()
//                    .filter(o -> o.getProductId().getProductId().equals(p.getProductId()))
//                    .count()
//          ));
     }

     private static Map<Product, Double> getProductWhichHasHighestRevenue(List<Order> orders) {
          return orders.stream().collect(groupingBy(Order::getProductId, Collectors.summingDouble(a -> a.getOrderAmount().doubleValue())))
               .entrySet()
               .stream()
               .max(Map.Entry.comparingByValue())
               .stream().collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
     }
}
