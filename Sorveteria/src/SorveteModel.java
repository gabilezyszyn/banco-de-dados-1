
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.*;

public class SorveteModel {
    
        public static void create(SorveteBean a, Connection conexao) throws SQLException {
        PreparedStatement st;

            st = conexao.prepareStatement("INSERT INTO sorvete (id_sorvete, sabor) VALUES (?,?)");
            st.setInt(1, a.getId_Sorvete());
            st.setString(2, a.getSabor());
            st.execute();
            st.close();  
    }

    static HashSet listAll(Connection conexao) throws SQLException {
        
        Statement s;

        HashSet list = new HashSet();
            s = conexao.createStatement();
            String sql = "SELECT id_sorvete, sabor FROM sorvete";
            ResultSet result = s.executeQuery(sql);
            while(result.next()) {
                list.add(new SorveteBean(result.getInt(1), result.getString(2)));
            }
        return list;
    }
    
}