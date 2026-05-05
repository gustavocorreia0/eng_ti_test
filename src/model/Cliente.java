package model;
import java.math.BigDecimal;


public class Cliente {

    private final String id_conta;
    private BigDecimal saldo;

    public Cliente(String id_conta, BigDecimal saldo){
        this.id_conta = id_conta;
        this.saldo = saldo;
    }

    public String getId_conta() {
        return id_conta;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

}
