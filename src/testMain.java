import java.math.BigDecimal;
import java.util.List;

public class testMain{

    public static void main(String[] args) {

        managerFinanceiro manager = new managerFinanceiro();
        dadosPendentes dados = new dadosPendentes();

        manager.realizarTransacoes(dados.getClientes(), dados.getTransacoes());
        manager.displaySaldos(dados.getClientes());

    }

}

class dadosCliente {

    private final String idConta;
    private BigDecimal saldo;

    public dadosCliente(String idConta, BigDecimal saldo){
        this.idConta = idConta;
        this.saldo = saldo;
    }

    public String getIdConta() {
        return idConta;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

}

class dadosTransacao {

    private final String idContaTransacionada;
    private final BigDecimal nrValor;

    public dadosTransacao(String id, BigDecimal valor){
        this.idContaTransacionada = id;
        this.nrValor = valor;
    }

    public String getIdContaTransacionada() {
        return idContaTransacionada;
    }

    public BigDecimal getNrValor() {
        return nrValor;
    }

}

class dadosPendentes {

    private final List<dadosCliente> clientes = List.of(
            new dadosCliente("0123456789", new BigDecimal("50.25")),
            new dadosCliente("1234567890", new BigDecimal("40.50")),
            new dadosCliente("2345678901", new BigDecimal("90.30")),
            new dadosCliente("3456789012", new BigDecimal("75.99"))
    );

    private final List<dadosTransacao> transacoes = List.of(
            new dadosTransacao("2345678901", new BigDecimal("-30.20")),
            new dadosTransacao("3456789012", new BigDecimal("10.01"))
    );

    public List<dadosCliente> getClientes() {
        return clientes;
    }

    public List<dadosTransacao> getTransacoes() {
        return transacoes;
    }

}

class managerFinanceiro {

    public void realizarTransacoes(List<dadosCliente> clientes, List<dadosTransacao> transacoes){
        for(dadosTransacao transacao : transacoes){
            System.out.println("Saldo: " + transacao.getNrValor());
        }
    }

    public void displaySaldos(List<dadosCliente> clientes){
        for(dadosCliente cliente: clientes){
            System.out.println("Conta: " + cliente.getIdConta() + " Saldo: " + cliente.getSaldo());
        }
    }

}