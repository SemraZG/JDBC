import java.sql.*;

public class ExecuteQuery02 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //1.step: Driver a kaydol.

        Class.forName("org.postgresql.Driver");

        //2.step: Database e bağlan.
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "55.Semra");

        //3.step: Statement oluştur.
        Statement st = con.createStatement();

        //COMPANİES TABLE DAN en yüksek ikinci number_of_employees değeri olan company ve number_of_employees değerini al.
        String sql1="SELECT company, number_of_employees FROM companies ORDER BY number_of_employees DESC OFFSET 1 ROW FETCH NEXT 1 ROW ONLY;";
        ResultSet resultSet1= st.executeQuery(sql1);
        while (resultSet1.next()){
            System.out.println(resultSet1.getString("company")+"--"+resultSet1.getInt("number_of_employees"));
        }

        //2. YOL
        String sql2="SELECT company, number_of_employees\n" +
                "FROM companies\n" +
                "WHERE number_of_employees=(SELECT MAX(number_of_employees) FROM companies\n" +
                "WHERE number_of_employees < (SELECT MAX (number_of_employees) FROM companies));\n";
        ResultSet resultSet2= st.executeQuery(sql2);
        while (resultSet2.next()){
            System.out.println(resultSet2.getString("company")+"---"+resultSet2.getInt(2));
        }

        con.close();
        st.close();
        resultSet2.close();
        resultSet1.close();
    }
}