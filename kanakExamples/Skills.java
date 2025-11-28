package kanakExamples;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

record Employee(String name, List<String> skills) {
}

public class Skills  {
     final static List<String> requiredSkills = List.of("Java", "SpringBoot");

     public static void main(String[] args) {
          List<String> list1 = List.of("Java", "SpringBoot", "Angular");
          List<String> list2 = List.of("Java", "SpringBoot", "React");
          System.out.println(
               list1.stream().filter(list2::contains).distinct().toList()
          );

          List<Employee> employeeList = Arrays.asList(new Employee("Raghu", List.of("Java", "React")),
               new Employee("kanak", List.of("Java", "React")),
               new Employee("reddy", List.of("JavaScript", "React")),
               new Employee("pavani", List.of("Java", "React", "SpringBoot")),
               new Employee("pavi", List.of("Java", "SpringBoot")));

          System.out.println(
               employeeList.stream().filter(employee -> {
                    for (var skill : employee.skills()) {
                         return requiredSkills.contains(skill);
                    }
                    return false;
               }).map(Employee::name).toList()
          );
     }
}
