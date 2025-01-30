public class Worker extends Person {
    private double hourlyPayRate;

    public Worker(String firstName, String lastName, String ID, String title, int YOB, double hourlyPayRate) {
        super(firstName, lastName, ID, title, YOB);
        this.hourlyPayRate = hourlyPayRate;
    }

    public double getHourlyPayRate() {
        return hourlyPayRate;
    }

    public void setHourlyPayRate(double hourlyPayRate) {
        this.hourlyPayRate = hourlyPayRate;
    }

    public double calculateWeeklyPay(double hoursWorked) {
        double regularHours = Math.min(hoursWorked, 40);
        double overtimeHours = Math.max(hoursWorked - 40, 0);
        return (regularHours * hourlyPayRate) + (overtimeHours * hourlyPayRate * 1.5);
    }

    public void displayWeeklyPay(double hoursWorked) {
        double regularHours = Math.min(hoursWorked, 40);
        double overtimeHours = Math.max(hoursWorked - 40, 0);
        double regularPay = regularHours * hourlyPayRate;
        double overtimePay = overtimeHours * hourlyPayRate * 1.5;
        double totalPay = regularPay + overtimePay;

        System.out.printf("Worker: %s %s (ID: %s)%n", getFirstName(), getLastName(), getID());
        System.out.printf("Regular Hours: %.2f, Regular Pay: $%.2f%n", regularHours, regularPay);
        System.out.printf("Overtime Hours: %.2f, Overtime Pay: $%.2f%n", overtimeHours, overtimePay);
        System.out.printf("Total Weekly Pay: $%.2f%n", totalPay);
        System.out.println("-----------------------------------");
    }

    @Override
    public String toCSV() {
        return super.toCSV() + "," + hourlyPayRate;
    }

    @Override
    public String toXML() {
        return "<Worker>\n" +
                "   <Person>\n" +
                "      <FirstName>" + getFirstName() + "</FirstName>\n" +
                "      <LastName>" + getLastName() + "</LastName>\n" +
                "      <ID>" + getID() + "</ID>\n" +
                "      <Title>" + getTitle() + "</Title>\n" +
                "      <YOB>" + getYOB() + "</YOB>\n" +
                "   </Person>\n" +
                "   <HourlyPayRate>" + hourlyPayRate + "</HourlyPayRate>\n" +
                "</Worker>";
    }

    @Override
    public String toJSON() {
        return "{\n" +
                "   \"firstName\": \"" + getFirstName() + "\",\n" +
                "   \"lastName\": \"" + getLastName() + "\",\n" +
                "   \"ID\": \"" + getID() + "\",\n" +
                "   \"title\": \"" + getTitle() + "\",\n" +
                "   \"YOB\": " + getYOB() + ",\n" +
                "   \"hourlyPayRate\": " + hourlyPayRate + "\n" +
                "}";
    }
}