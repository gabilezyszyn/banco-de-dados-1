
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.ResultSet;
import java.sql.Statement;

public class Conexao {

    private Connection c;
    
    public Conexao() {

        String driver = "org.postgresql.Driver";
        String user = "postgres";
        String senha = "postgresql";
        String url = "jdbc:postgresql://localhost:5432/sorveteria";

        try {
            Class.forName(driver);
            this.c = (Connection) DriverManager.getConnection(url, user, senha);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
            System.exit(1);
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
            System.exit(1);
        }  
    }
    
    public Connection getConnection() {
        return c;
    }
    
    public void closeConnection(){
        try {
            this.c.close();
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
            System.exit(1);
        }
    }
    
}