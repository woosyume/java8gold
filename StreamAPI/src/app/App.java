package app;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) throws Exception {
        List<String> list = Arrays.asList("Java ", "Gold");
        Function<String, String> f = a -> "Hello : ".concat(a);

        list.stream().map(f).peek(a -> System.out.println(a)); // peek만으로는 아무것도 표시되지 않는다. 중간처리이기 때문에

        Predicate<String> test = n -> {
            System.out.println("Checking ... / ");
            return n.contains("ld");
        };

        list.stream().filter(c -> c.length() > 5).allMatch(test);

        List<Employee> emp = Arrays.asList(
            new Employee("101", "woosyume1", "Osaka"),
            new Employee("102", "woosyume2", "Tokyo"),
            new Employee("103", "woosyume3", "Osaka")
        );

        emp.stream().collect(Collectors.groupingBy(Employee::getLoc))
        .forEach((src, res) -> System.out.println(res));
    }
}

class Employee {
    String id, name, loc;

    public Employee(String id, String name, String loc) {
        this.id = id;
        this.name = name;
        this.loc = loc;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

    @Override
    public String toString() {
        return "Employee [id=" + id + ", loc=" + loc + ", name=" + name + "]";
    }
}