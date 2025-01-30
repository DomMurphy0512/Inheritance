import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class WorkerTest {
    @Test
    void testCalculateWeeklyPay_RegularHours() {
        Worker worker = new Worker("John", "Doe", "12345", "Mr.", 1990, 20.0);
        double expected = 800.0;
        double actual = worker.calculateWeeklyPay(40);
        assertEquals(expected, actual, 0.01);
    }

    @Test
    void testCalculateWeeklyPay_OvertimeHours() {
        Worker worker = new Worker("John", "Doe", "12345", "Mr.", 1990, 20.0);
        double expected = 1100.0; // 40 * 20 + 10 * (20 * 1.5)
        double actual = worker.calculateWeeklyPay(50);
        assertEquals(expected, actual, 0.01);
    }

    @Test
    void testToCSV() {
        Worker worker = new Worker("John", "Doe", "12345", "Mr.", 1990, 20.0);
        String expected = "John,Doe,12345,Mr.,1990,20.0";
        assertEquals(expected, worker.toCSV());
    }

    @Test
    void testToXML() {
        Worker worker = new Worker("John", "Doe", "12345", "Mr.", 1990, 20.0);
        String expected = "<Worker>" +
                "<Person>" +
                "<FirstName>John</FirstName>" +
                "<LastName>Doe</LastName>" +
                "<ID>12345</ID>" +
                "<Title>Mr.</Title>" +
                "<YOB>1990</YOB>" +
                "</Person>" +
                "<HourlyPayRate>20.0</HourlyPayRate>" +
                "</Worker>";
        assertEquals(expected.replaceAll("\\s+", ""), worker.toXML().replaceAll("\\s+", ""));
    }

    @Test
    void testToJSON() {
        Worker worker = new Worker("John", "Doe", "12345", "Mr.", 1990, 20.0);
        String expected = "{" +
                "\"firstName\":\"John\"," +
                "\"lastName\":\"Doe\"," +
                "\"ID\":\"12345\"," +
                "\"title\":\"Mr.\"," +
                "\"YOB\":1990," +
                "\"hourlyPayRate\":20.0" +
                "}";
        assertEquals(expected.replaceAll("\\s+", ""), worker.toJSON().replaceAll("\\s+", ""));
    }
}