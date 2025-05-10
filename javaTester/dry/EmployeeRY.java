package dry;

public class EmployeeRY {

    public void showFulltimeEmployeeDetail(){
        System.out.println("Name = mimi ");
        System.out.println("Position = Devoloper");
        System.out.println("Type = Fulltime");
        System.out.println("Salary = 5000");
    }

    public void showParttimeEmployeeDetail(){
        System.out.println("Name = dodo");
        System.out.println("Position = QA");
        System.out.println("Type = Parttime");
        System.out.println("Salary = 1000");
    }

    public static void main (String[] args){
        EmployeeRY firstEmployee = new EmployeeRY();
        firstEmployee.showFulltimeEmployeeDetail();

        EmployeeRY secondEmployee = new EmployeeRY();
        secondEmployee.showParttimeEmployeeDetail();
    }

}
