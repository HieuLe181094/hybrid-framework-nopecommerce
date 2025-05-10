package dry;

public class EmployeeDRY {
    private String employeeName;
    private String employeePosition;
    private String employeeType;
    private String employeeSalary;
    private String employeeRate;

    public EmployeeDRY(String employeeName, String employeePosition, String employeeType, String employeeSalary, String employeeRate){
        this.employeeName = employeeName;
        this.employeePosition = employeePosition;
        this.employeeType = employeeType;
        this.employeeSalary = employeeSalary;
        this.employeeRate = employeeRate;
    }

    public void showEmployeeDRY(){
        System.out.println("Name = " + this.employeeName);
        System.out.println("Position = " + this.employeePosition);
        System.out.println("Type = " + this.employeeType);

        if (this.employeeType.equalsIgnoreCase("Fulltime")){
            System.out.println("Salary = " + this.employeeSalary);
        } else {
            System.out.println("Rate = " + this.employeeRate);
        }
    }

    public static void main(String[] args){
        EmployeeDRY mimi = new EmployeeDRY("mimi","Devoloper", "Fulltime",
                "5000", "");
        mimi.showEmployeeDRY();

        EmployeeDRY dodo = new EmployeeDRY("dodo", "QA", "Parttime",
                "1000", "");
        dodo.showEmployeeDRY();

        EmployeeDRY hiu = new EmployeeDRY("HIU", "QA", "Fulltime",
                "2000", "");
        hiu.showEmployeeDRY();
    }

}
