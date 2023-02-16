import java.sql.Connection;
import java.sql.Statement;

public class Runner {
    public static void main(String[] args) {
        //1. Step: Registration to the driver
        //2. Step: Create connection with database
      Connection connection= JdbcUtils.connectToDatabase("localhost", "postgres", "postgres", "55.Semra");

        //3. Step: Create statement
       Statement statement= JdbcUtils.createStatement();

        //4. Step: Execute the query
        //JdbcUtils.execute("CREATE TABLE teachers (name VARCHAR(20), id INT, address VARCHAR(80))");
        JdbcUtils.createTable("tutors","name VARCHAR(20)","id INT","address VARCHAR(50)","tel BIGINT");
        JdbcUtils.createTable("Students", "name VARCHAR(20)", "id INT", "address VARCHAR(80)");

        JdbcUtils.insertDataIntoTable("Students","name 'John'");

        // JdbcUtils.dropTable("Students");

        //5. Step: Close the connection and statement
        JdbcUtils.closeConnectionAndStatement();
    }
}
