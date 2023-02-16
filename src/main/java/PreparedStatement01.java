import java.sql.*;

public class PreparedStatement01 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //1.step: Driver a kaydol.

        Class.forName("org.postgresql.Driver");

        //2.step: Database e bağlan.
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "55.Semra");

        //3.step: Statement oluştur.
        Statement st = con.createStatement();

        //Prepared Statement kullanarak company adı IBM olan number_of_employees değerini 9999 olarak güncelle.
        //Preppared Statement query sini oluştur
        String sql1="UPDATE companies SET number_of_employees=? WHERE company = ? ";
        //Prepared Statement objesini oluştur.
        PreparedStatement pst1= con.prepareStatement(sql1);
        //setInt(), setStribg().. methodları ile soru işaretleri yerlerine değer gir.
        pst1.setInt(1, 8888);
        pst1.setString(2, "IBM");
        //query i çalıştır.
        int güncellenenSatırSayısı=pst1.executeUpdate();
        System.out.println(güncellenenSatırSayısı);

        //değişen datayı gör.
        String sql2="SELECT * FROM companies";
        ResultSet resultSet2= st.executeQuery(sql2);
        while (resultSet2.next()){
            System.out.println(resultSet2.getInt(1)+"--"+resultSet2.getString(2)+"--"+resultSet2.getInt(3));
        }

        //Prepared Statement kullanarak company adı GOOGLE olan number_of_employees değerini 7777 olarak güncelle.
        pst1.setInt(1, 7777);
        pst1.setString(2, "GOOGLE");
        int güncellenenSatırSayısı2=pst1.executeUpdate();
        System.out.println(güncellenenSatırSayısı2);
        ResultSet resultSet3= st.executeQuery(sql2);
        while (resultSet3.next()){
            System.out.println(resultSet3.getInt(1)+"--"+resultSet3.getString(2)+"--"+resultSet3.getInt(3));
        }
        con.close();
        st.close();
        resultSet3.close();
        resultSet2.close();

    }
}
