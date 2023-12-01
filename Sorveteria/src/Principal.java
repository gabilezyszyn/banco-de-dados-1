import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) throws SQLException {
        
        Conexao c = new Conexao();

        Connection conexao = c.getConnection();

        int op = 0;

        do{
            op = menu();
            
            try {
                switch (op) {
                    case 1: new SorveteController().createSorvete(conexao);
                            break;
                    case 2: new PedidoController().createPedido(conexao);
                            break;
                    case 3: new SorveteController().listarSorvete(conexao);
                            break;
                    case 4: new PedidoController().listarPedido(conexao);
                            break;
                    case 5: new PedidoController().listarPedidoSorvete(conexao);
                            break;
                }
            }catch(SQLException ex) {
                System.out.println(ex.getMessage());
                continue;
            }
        } while(op>0 && op<7);  
        conexao.close();
    }    
    
    private static int menu() {
        System.out.println("");
        System.out.println("Informe o numero da opcao que deseja executar: ");
        System.out.println("1 - Inserir um novo sorvete");
        System.out.println("2 - Inserir um novo pedido");
        System.out.println("3 - Exibir todos os sorvetes");
        System.out.println("4 - Exibir todos os pedidos");
        System.out.println("5 - Exibir todos os pedidos e seus respectivos sabores associados");
        System.out.println("Digite qualquer outro valor para sair");
        System.out.print("Sua opcao: ");
        Scanner input = new Scanner(System.in);
        return input.nextInt();

    }
}