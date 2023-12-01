import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.*;

public class SorveteController {
    
    public void createSorvete(Connection con) throws SQLException {

        Scanner input = new Scanner(System.in);

        System.out.println("Insira os seguintes dados para a criar um novo sorvete: ");

        System.out.print("idSorvete: ");

        int id_sorvete = input.nextInt();
        System.out.print("sabor: ");

        String sabor = input.next();

        SorveteBean sorvete = new SorveteBean(id_sorvete, sabor);
        SorveteModel.create(sorvete, con);

        System.out.println("Sorvete criado com sucesso!!!");
        input.close();
    }

    void listarSorvete(Connection con) throws SQLException {
        HashSet all = SorveteModel.listAll(con);
        Iterator<SorveteBean> it = all.iterator();
        
        while(it.hasNext()) {
            System.out.println(it.next().toString());
        }
    }
    
}
