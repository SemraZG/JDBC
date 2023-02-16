import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

public class CountriesTest {
    /*
      Given
        User connects to the database

      When
        User sends the query to get the region ids from "countries" table

      Then
        Verify that the number of region ids greater than 2 is 4.

      And
        User closes the connection
     */
    @Test
    public void countryTest() throws SQLException {
        //User connects to the database
        JdbcUtils.connectToDatabase("localhost","postgres","postgres","55.Semra");
       Statement statement= JdbcUtils.createStatement();

        //User sends the query to get the region ids from "countries" table
        //1.way
        String sql1="SELECT region_id FROM countries";
        ResultSet resultSet=statement.executeQuery(sql1);
        List<Integer> ids=new ArrayList<>();
        while (resultSet.next()){
            ids.add(resultSet.getInt(1));
        }
        List<Integer> idsGreaterThan2=new ArrayList<>();
        for (int w: ids){
            if (w>2){
               idsGreaterThan2.add(w);
            }
        }
        //Assert that the number of region ids greater than 1 is 17.
        //1.way
        assertEquals(4, idsGreaterThan2.size());

        //User sends the query to get the region ids from "countries" table
        //2.way
//        List<Object> region_ids= JdbcUtils.getColumnList("region_id","countries");
//        System.out.println("region_ids = " + region_ids);
//
//        //Assert that the number of region ids greater than 1 is 17.
//        int idsGreaterThan1 = region_ids.stream().filter(t->(Integer)t>1).collect(Collectors.toList()).size();
//        System.out.println("idsGreaterThan1 = " + idsGreaterThan1);
//        assertEquals(17,idsGreaterThan1);

        //User closes the connection
        JdbcUtils.closeConnectionAndStatement();

    }
}