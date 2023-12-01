import java.util.*;

public class PedidoBean{

    private int idPedido;
    private String tamanho;
    private String pagamento;
    private float total;
    private int idSorvete;
    private SorveteBean sorvete;
    
   public PedidoBean(int idPedido, String tamanho, String pagamento, float total, int idSorvete) {
       this.idPedido = idPedido;
       this.pagamento = pagamento;
       this.tamanho = tamanho;
       this.total = total;
       this.idSorvete = idSorvete;
   }
    
    public String getPagamento() {
        return pagamento;
    }
    
    public void setPagamento(String pagamento) {
        this.pagamento = pagamento;
    }

    public String getTamanho() {
        return tamanho;
    }
    
    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }
    
    public int getId_Sorvete() {
        return idSorvete;
    }

    public void setId_Sorvete(int id_sorvete) {
        this.idSorvete = id_sorvete;
    }
    
    public SorveteBean getSorvete(){
        return sorvete;
    }
    
    public void setSorvete (SorveteBean sorvete){
        this.sorvete = sorvete;
    }

    public int getId_Pedido() {
        return idPedido;
    }

    public void setId_Pedido(int id_pedido) {
        this.idPedido = id_pedido;
    }

    public float getTotal() {
        return total;
    }
    
    public void setTotal(float total) {
        this.total = total;
    }
    
    public String toString(){
        StringBuffer sb = new StringBuffer();
        sb.append("id_pedido: "+idPedido+
                " - tamanho: "+tamanho+
                " - pagamento: "+pagamento+
                " - total: "+total);
        if(sorvete!= null)
            sb.append(" - id_sorvete: "+sorvete.getId_Sorvete()+" - sabor: "+sorvete.getSabor());
        return sb.toString();
    }
    
}
