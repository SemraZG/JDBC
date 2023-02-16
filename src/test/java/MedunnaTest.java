import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class MedunnaTest {
    /*
    Given
    User connects to the database
    hostname=medunna.com, datbasename= medunna_db, username=medunna_user, password= medunna_pass_987
    When
    User sends the query tp get the names of created_by column from "room" table
    Then
    assert that there are some rooms created by "john_doe"
     */

    @Test
    public void medunnaTest() throws SQLException {
        //User connects to the database
        JdbcUtils.connectToDatabase("medunna.com","medunna_db", "medunna_user", "medunna_pass_987");
        Statement statement=JdbcUtils.createStatement();

        //User sends the query tp get the names of created_by column from "room" table
        String sql1="SELECT region_id FROM room";
        ResultSet resultSet=statement.executeQuery(sql1);
        List<Integer> created_byList=new ArrayList<>();
        while (resultSet.next()){
            created_byList.add(resultSet.getInt(1));
        }

        //assert that there are some rooms created by "john_doe"
        assertTrue(created_byList.contains("john_doe"));
    }
}
