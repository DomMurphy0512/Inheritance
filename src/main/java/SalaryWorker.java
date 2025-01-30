public class SalaryWorker extends Worker {
    private double annualSalary;

    public SalaryWorker(String firstName, String lastName, String ID, String title, int YOB, double hourlyPayRate, double annualSalary) {
        super(firstName, lastName, ID, title, YOB, hourlyPayRate);
        this.annualSalary = annualSalary;
    }

    public double getAnnualSalary() {
        return annualSalary;
    }

    public void setAnnualSalary(double annualSalary) {
        this.annualSalary = annualSalary;
    }

    @Override
    public double calculateWeeklyPay(double hoursWorked) {
        return annualSalary / 52;
    }

    @Override
    public void displayWeeklyPay(double hoursWorked) {
        double weeklyPay = calculateWeeklyPay(hoursWorked);

        System.out.printf("Salary Worker: %s %s (ID: %s)%n", getFirstName(), getLastName(), getID());
        System.out.printf("Annual Salary: $%.2f%n", annualSalary);
        System.out.printf("Weekly Pay: $%.2f (1/52 of annual salary)%n", weeklyPay);
        System.out.println("-----------------------------------");
    }

    @Override
    public String toCSV() {
        return super.toCSV() + "," + annualSalary;
    }

    @Override
    public String toXML() {
        return "<SalaryWorker>\n" +
                "   <Worker>\n" +
                "   <Person>\n" +
                "      <FirstName>" + getFirstName() + "</FirstName>\n" +
                "      <LastName>" + getLastName() + "</LastName>\n" +
                "      <ID>" + getID() + "</ID>\n" +
                "      <Title>" + getTitle() + "</Title>\n" +
                "      <YOB>" + getYOB() + "</YOB>\n" +
                "   </Person>\n" +
                "   <Worker>\n" +
                "      <HourlyPayRate>" + getHourlyPayRate() + "</HourlyPayRate>\n" +
                "   </Worker>\n" +
                "   <AnnualSalary>" + annualSalary + "</AnnualSalary>\n" +
                "</SalaryWorker>";
    }

    @Override
    public String toJSON() {
        return "{\n" +
                "   \"firstName\": \"" + getFirstName() + "\",\n" +
                "   \"lastName\": \"" + getLastName() + "\",\n" +
                "   \"ID\": \"" + getID() + "\",\n" +
                "   \"title\": \"" + getTitle() + "\",\n" +
                "   \"YOB\": " + getYOB() + ",\n" +
                "   \"hourlyPayRate\": " + getHourlyPayRate() + ",\n" +
                "   \"annualSalary\": " + annualSalary + "\n" +
                "}";
    }
}
