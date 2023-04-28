import java.math.BigDecimal;
import java.time.LocalDate;

public class Employee extends Person {
    private BigDecimal salary;
    private String role;
    public Employee(String name, LocalDate birthDate, BigDecimal salary, String role) {
        super(name, birthDate);
        this.salary = salary;
        this.role = role;
    }

    public BigDecimal getSalary() {
        return this.salary;
    }

    public String getRole() {
        return this.role;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
