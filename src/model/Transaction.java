package model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Transaction {

    private final int id_transaction;
    private final LocalDateTime datetime;
    private final String id_conta_debito;
    private final String id_conta_credito;
    private final BigDecimal valor;

    public Transaction(int id_transaction, LocalDateTime datetime, String id_conta_debito, String id_conta_credito, BigDecimal valor){
        this.id_transaction = id_transaction;
        this.datetime = datetime;
        this.id_conta_debito = id_conta_debito;
        this.id_conta_credito = id_conta_credito;
        this.valor = valor;
    }

    public int getId_transaction() {
        return id_transaction;
    }

    public LocalDateTime getDatetime() {
        return datetime;
    }

    public String getId_conta_debito() {
        return id_conta_debito;
    }

    public String getId_conta_credito() {
        return id_conta_credito;
    }

    public BigDecimal getValor() {
        return valor;
    }

}
