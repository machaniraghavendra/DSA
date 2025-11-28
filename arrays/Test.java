package arrays;


public class Test {
     private Integer id;
     private String name;

     @Override
     public String toString() {
          return "Test{" +
               "id=" + id +
               ", name='" + name + '\'' +
               ", salary='" + salary + '\'' +
               '}';
     }

     public Integer getId() {
          return id;
     }

     public void setId(Integer id) {
          this.id = id;
     }

     public String getName() {
          return name;
     }

     public void setName(String name) {
          this.name = name;
     }

     public String getSalary() {
          return salary;
     }

     public void setSalary(String salary) {
          this.salary = salary;
     }

     public Test(Integer id, String name, String salary) {
          this.id = id;
          this.name = name;
          this.salary = salary;
     }

     private String salary;
}
