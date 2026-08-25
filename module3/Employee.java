import java.util.ArrayList;
import java.util.HashMap;

public class Employee { 
 
    // FIELDS: the data each Employee object holds 
    private String  name; 
    private double  salary; 
    private boolean active; 

    public static void main(String[] args) {
        ArrayList<Employee> employees = new ArrayList<>();
        HashMap<String, Employee> employeeMap = new HashMap<>();

        employees.add(new Employee("Joe", 50000));
        employees.add(new Employee("Sara", 350000));
        employees.add(new Employee("Zelda", 100000));

        employeeMap.put("Joe", new Employee("Joe", 50000));
        employeeMap.put("Sara", new Employee("Sara", 350000));
        employeeMap.put("Zelda", new Employee("Zelda", 100000));

        for (Employee e : employees) {
            System.out.println(e.toString());
        }

        if (employeeMap.containsKey("Zelda")) System.out.println(employeeMap.get("Zelda").toString());
    }
 
    // CONSTRUCTOR: runs when you write new Employee(...) 
    public Employee(String name, double salary) { 
        this.name   = name;     // 'this.name' is the field; 'name' is the parameter 
        this.salary = salary; 
        this.active = true;     // all new employees start active 
    } 
 
    // GETTERS: controlled read access to private fields 
    public String  getName()   { return name; } 
    public double  getSalary() { return salary; } 
    public boolean isActive()  { return active; } 
 
    // METHODS: actions this object can perform 
    public void promote(double raise) { 
        if (raise > 0) this.salary += raise; 
    } 
 
    public void deactivate() { 
        this.active = false; 
    } 
 
    // TOSTRING: what prints when you System.out.println(employee) 
    @Override 
    public String toString() { 
        return name + " | $" + salary + " | active: " + active; 
    } 
} 