import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Execute01 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //1.step: Driver a kaydol.

        Class.forName("org.postgresql.Driver");

        //2.step: Database e bağlan.
      Connection con= DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "55.Semra");

      //3.step: Statement oluştur.
        Statement st=con.createStatement();

        //4.step: Query i çalıştır.

        //"workers" adında table oluştur, "worker_id, worker_name, worker_salary" sütunlarını ekleyin.
        boolean sql1= st.execute("CREATE TABLE workers(worker_id VARCHAR(20),worker_name VARCHAR(20), worker_salary INT)");
        System.out.println("sql1 = " + sql1);//bir data çağırmadiğım için false döndürecek.

        //Table workers a worker_address sütunu ekleyip alter yapın.
        String sql2= "ALTER TABLE workers ADD worker_address  VARCHAR(80)";
        st.execute(sql2);

        //workers table i silin.
        String sql3= "drop table workers";
        st.execute(sql3);

        //5.step: bağlantı ve Statement i kapat.
        con.close();
        st.close();

//DDL== create, drop, alter--> bunlarda execute() methodu;
// DQL==select--->burada executeQuery() methodu kullanulır, sadece execute() methodunu kullanırsak kod çalışır ama boolean return ettiği için gelen datayı göremem..
    }
}
