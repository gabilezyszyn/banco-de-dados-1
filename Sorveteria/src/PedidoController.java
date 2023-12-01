
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.*;

public class PedidoController {
    
    public void createPedido(Connection con) throws SQLException {
        Scanner input = new Scanner(System.in);
        System.out.println("Insira os seguintes dados para a criar um novo Pedido: ");
        
        System.out.print("id_pedido: ");
        int id_pedido = input.nextInt();
        
        System.out.print("tamanho (p: pequeno / m: medio / g: grande): ");
        String tamanho = input.next();
        
        System.out.print("pagamento (c: credito / de: debito / di: dinheiro): ");
        String pagamento = input.next();
        
        System.out.print("total: ");
        float total = input.nextFloat();
        
        System.out.print("id_sorvete: ");
        int id_sorvete = input.nextInt();
        
        PedidoBean pedido = new PedidoBean(id_pedido, tamanho, pagamento, total, id_sorvete);
        PedidoModel.create(pedido, con);
        
        System.out.println("Pedido criado com sucesso!!");

        input.close();
    }

    void listarPedido(Connection con) throws SQLException {
        HashSet all = PedidoModel.listAll(con);
        Iterator<PedidoBean> it = all.iterator();
        while(it.hasNext()) {
            System.out.println(it.next().toString());
        }
    }
    
        void listarPedidoSorvete(Connection con) throws SQLException {
        HashSet all = PedidoModel.listAllWithSorvete(con);
        Iterator<PedidoBean> it = all.iterator();
        while(it.hasNext()) {
            System.out.println(it.next().toString());
        }
    }
    
}
