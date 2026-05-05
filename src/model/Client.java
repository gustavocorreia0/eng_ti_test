package model;
import java.math.BigDecimal;


public class Client {

    private final String id_conta;
    private BigDecimal saldo;

    public Client(String id_conta, BigDecimal saldo){
        this.id_conta = id_conta;
        this.saldo = saldo;
    }

    public String getId_conta() {
        return id_conta;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void debitar(BigDecimal valor) {
        saldo = saldo.subtract(valor);
    }

    public void creditar(BigDecimal valor) {
        saldo = saldo.add(valor);
    }

}
