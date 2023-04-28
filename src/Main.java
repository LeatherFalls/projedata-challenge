import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static List<Employee> employees = new ArrayList<>(){
        {
            add(new Employee("Maria", LocalDate.of(2000, 10, 18), new BigDecimal("2009.44"), "Operador"));
            add(new Employee("João", LocalDate.of(1990, 5, 12), new BigDecimal("2284.38"), "Operador"));
            add(new Employee("Caio", LocalDate.of(1961, 5, 2), new BigDecimal("9836.14"), "Coordenador"));
            add(new Employee("Miguel", LocalDate.of(1988, 10, 14), new BigDecimal("19119.88"), "Diretor"));
            add(new Employee("Alice", LocalDate.of(1995, 1, 5), new BigDecimal("2234.68"), "Recepcionista"));
            add(new Employee("Heitor", LocalDate.of(1999, 11, 19), new BigDecimal("1582.72"), "Operador"));
            add(new Employee("Arthur", LocalDate.of(1993, 3, 31), new BigDecimal("4071.84"), "Contador"));
            add(new Employee("Laura", LocalDate.of(1994, 7, 8), new BigDecimal("3017.45"), "Gerente"));
            add(new Employee("Heloísa", LocalDate.of(2003, 5, 24), new BigDecimal("1606.85"), "Eletrecista"));
            add(new Employee("Helena", LocalDate.of(1996, 9, 2), new BigDecimal("2799.93"), "Gerente"));
        }
    };

    public static void groupByRole(List<Employee> employees) {
        Map<String, List<Employee>> employeesByRole = employees.stream().collect(Collectors.groupingBy(Employee::getRole));

        for (Map.Entry<String, List<Employee>> entry : employeesByRole.entrySet()) {
            System.out.println(entry.getKey() + ":");
            for (Employee employee : entry.getValue()) {
                System.out.println(employee.getName());
            }
            System.out.println();
        }
    }

    public static void addEmployee(List<Employee> employees, Employee employee) {
        employees.add(employee);
    }

    public static void removeEmployee(List<Employee> employees, String name) {
        for (Employee employee : employees) {
            if (employee.getName().equals(name)) {
                employees.remove(employee);
                break;
            }
        }
    }

    public static void salaryIncrease(List<Employee> employees) {
        for (Employee employee : employees) {
            employee.setSalary(employee.getSalary().multiply(new BigDecimal("1.1")));
        }
    }

    public static void printByBirthDate(List<Employee> employees) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        for (Employee employee : employees) {
            if (employee.getBirthDate().getMonthValue() == 10 || employee.getBirthDate().getMonthValue() == 12) {
                System.out.println(employee.getName() + " - " + dtf.format(employee.getBirthDate()));
            }
        }
    }

    public static void printOlderEmployeeAge(List<Employee> employees) {
        LocalDate now = LocalDate.now();

        Employee olderEmployee = employees.get(0);

        for (Employee employee : employees) {
            if (employee.getBirthDate().isBefore(olderEmployee.getBirthDate())) {
                olderEmployee = employee;
            }
        }

        Period period = Period.between(olderEmployee.getBirthDate(), now);
        System.out.println(olderEmployee.getName() + " - " + period.getYears());
    }

    public static void printOrderByAlphabeticalOrder(List<Employee> employees) {
        employees.sort((e1, e2) -> e1.getName().compareTo(e2.getName()));

        for (Employee employee : employees) {
            System.out.println(employee.getName());
        }
    }

    public static void printTotalSalary(List<Employee> employees) {
        BigDecimal totalSalary = new BigDecimal("0");

        for (Employee employee : employees) {
            totalSalary = totalSalary.add(employee.getSalary());
        }

        System.out.println(totalSalary);
    }

    public static void qtdeMinSalaries(List<Employee> employees) {
        BigDecimal minSalary = new BigDecimal("1212.00");

        for (Employee employee : employees) {
            double qtdeMinSalaries = employee.getSalary().doubleValue() / minSalary.doubleValue();
            System.out.println(employee.getName() + " - " + String.format("%.2f", qtdeMinSalaries));
        }
    }

    public static void printEmployees(List<Employee> employees) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        DecimalFormat df = new DecimalFormat("#,###.00");

        for (Employee employee : employees) {
            System.out.println(employee.getName() + " - " + dtf.format(employee.getBirthDate()) + " - " + df.format(employee.getSalary()) + " - " + employee.getRole());
        }
    }
    public static void main(String[] args) {
        //removeEmployee(employees, "João");
        //salaryIncrease(employees);
        //printEmployees(employees);
        groupByRole(employees);
        //printByBirthDate(employees);
        //printOlderEmployeeAge(employees);
        //printOrderByAlphabeticalOrder(employees);
        //printTotalSalary(employees);
        //qtdeMinSalaries(employees);
    }
}