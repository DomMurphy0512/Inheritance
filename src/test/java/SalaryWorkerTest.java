import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SalaryWorkerTest {
    @Test
    void testCalculateWeeklyPay() {
        SalaryWorker salaryWorker = new SalaryWorker("Jane", "Smith", "67890", "Dr.", 1985, 25.0, 52000);
        double pay = salaryWorker.calculateWeeklyPay(40); // Weekly salary should be 52000 / 52 = 1000
        assertEquals(1000.0, pay, 0.01);
    }

    @Test
    void testCalculateWeeklyPay_IgnoresHoursWorked() {
        SalaryWorker salaryWorker = new SalaryWorker("Jane", "Smith", "67890", "Dr.", 1985, 25.0, 52000);
        double pay = salaryWorker.calculateWeeklyPay(50); // Should still be 1000, ignoring hours
        assertEquals(1000.0, pay, 0.01);
    }

    @Test
    void testToCSV() {
        SalaryWorker salaryWorker = new SalaryWorker("Jane", "Smith", "67890", "Dr.", 1985, 25.0, 52000);
        String expected = "Jane,Smith,67890,Dr.,1985,25.0,52000.0";
        assertEquals(expected, salaryWorker.toCSV());
    }

    @Test
    void testToXML() {
        SalaryWorker salaryWorker = new SalaryWorker("Jane", "Smith", "67890", "Dr.", 1985, 25.0, 52000);
        String expected = "<SalaryWorker>\n" +
                "   <Worker>\n" +
                "      <Person>\n" +
                "         <FirstName>Jane</FirstName>\n" +
                "         <LastName>Smith</LastName>\n" +
                "         <ID>67890</ID>\n" +
                "         <Title>Dr.</Title>\n" +
                "         <YOB>1985</YOB>\n" +
                "      </Person>\n" +
                "   <Worker>\n" +
                "      <HourlyPayRate>25.0</HourlyPayRate>\n" +
                "   </Worker>\n" +
                "   <AnnualSalary>52000.0</AnnualSalary>\n" +
                "</SalaryWorker>";
        assertEquals(expected.replaceAll("\\s+", ""), salaryWorker.toXML().replaceAll("\\s+", ""));
    }

    @Test
    void testToJSON() {
        SalaryWorker salaryWorker = new SalaryWorker("Jane", "Smith", "67890", "Dr.", 1985, 25.0, 52000);
        String expected = "{\n" +
                "   \"firstName\": \"Jane\",\n" +
                "   \"lastName\": \"Smith\",\n" +
                "   \"ID\": \"67890\",\n" +
                "   \"title\": \"Dr.\",\n" +
                "   \"YOB\": 1985,\n" +
                "   \"hourlyPayRate\": 25.0,\n" +
                "   \"annualSalary\": 52000.0\n" +
                "}";
        assertEquals(expected.replaceAll("\\s+", ""), salaryWorker.toJSON().replaceAll("\\s+", ""));
    }
}
