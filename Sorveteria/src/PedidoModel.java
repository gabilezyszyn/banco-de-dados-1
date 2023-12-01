
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;

public class PedidoModel {
    
    public static void create(PedidoBean a, Connection con) throws SQLException {
        PreparedStatement st;
            st = con.prepareStatement("INSERT INTO pedido (id_pedido, tamanho, pagamento, total, id_sorvete) VALUES (?,?,?,?,?)");
            st.setInt(1, a.getId_Pedido());
            st.setString(2, a.getTamanho());
            st.setString(3, a.getPagamento());
            st.setFloat(4, a.getTotal());
            st.setInt(5, a.getId_Sorvete());
            st.execute();
            st.close();  
    }

    static ResultSet lucro(Connection con) throws SQLException {
        Statement st;
        st = con.createStatement();
        String sql = "SELECT sorvete.sabor, pedido.total FROM sorvete NATURAL JOIN pedido WHERE total = (SELECT max(total) FROM pedido WHERE total IS NOT NULL)";
        ResultSet result = st.executeQuery(sql);
        while(result.next()) {
        System.out.print(result.getString(1)+" | ");
        System.out.println(result.getFloat(2));
        }return result;
    }
    
    static HashSet listAllWithSorvete(Connection con) throws SQLException {
        Statement st;
        HashSet list = new HashSet();
        st = con.createStatement();
        String sql = "SELECT id_pedido, tamanho, pagamento, total, id_sorvete, sorvete.sabor FROM pedido NATURAL JOIN sorvete";
        ResultSet result = st.executeQuery(sql);
        while(result.next()) {
            PedidoBean p = new PedidoBean(result.getInt(1), result.getString(2), result.getString(3), result.getFloat(4), result.getInt(5));
            SorveteBean s = new SorveteBean(result.getInt(5), result.getString(6));
            p.setSorvete(s);
            list.add(p);
        }
        return list;
    }

    static HashSet listAll(Connection con) throws SQLException {
        Statement st;
        HashSet list = new HashSet();
            st = con.createStatement();
            String sql = "SELECT id_pedido, tamanho, pagamento, total, id_sorvete FROM pedido";
            ResultSet result = st.executeQuery(sql);
            while(result.next()) {
                list.add(new PedidoBean(result.getInt(1), result.getString(2), result.getString(3), result.getFloat(4), result.getInt(5)));
            }
        return list;
    }
    
}