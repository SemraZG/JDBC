import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ExecuteQuery01 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //1.step: Driver a kaydol.

        Class.forName("org.postgresql.Driver");

        //2.step: Database e bağlan.
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "55.Semra");

        //3.step: Statement oluştur.
        Statement st = con.createStatement();

        //region id si 1 olan country name değerlerini çağırın.
        String sql1="SELECT country_name FROM countries WHERE region_id=7;";
        //If you use execute() method you will get true or false as return.But i want to see the records.
        boolean result1= st.execute(sql1);
        System.out.println(result1);

        //Recordları görmek için ExecuteQuery() methodunu kullanmalıyız.
       ResultSet resultSet1= st.executeQuery(sql1);
       //ResultSet databaseden gelen dataları koyduğumuz conteynır.
        //Burada data oluşturmayıp olan datayı çağırdığımız için executeQuery() methodunu kullanıp datayı çağırıyoruz, gelen datayı resultset conteynırının içine atıyoruz.


        while (resultSet1.next()){
            System.out.println(resultSet1.getString(1));
        }

        //region id nin 3den büyük olduğu country id ve country name değerlerini çağırın.
        String sql2="SELECT country_id, country_name FROM countries WHERE region_id>3";
        ResultSet resultSet2= st.executeQuery(sql2);
        while (resultSet2.next()){
            System.out.println(resultSet2.getString("country_name")+"--"+resultSet2.getString("country_id"));
            //or
            //System.out.println(resultSet2.getString(1)+"--"+resultSet2.getString(2));
        }

        con.close();
        st.close();
    }

}