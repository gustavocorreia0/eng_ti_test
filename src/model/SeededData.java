package model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class SeededData {

    private final List<Client> clientes = List.of(
            new Client("938485762", new BigDecimal("180.00")),
            new Client("347586970", new BigDecimal("1200.00")),
            new Client("2147483649", new BigDecimal("0.00")),
            new Client("675869708", new BigDecimal("4900.00")),
            new Client("238596054", new BigDecimal("478.00")),
            new Client("573659065", new BigDecimal("787.00")),
            new Client("210385733", new BigDecimal("10.00")),
            new Client("674038564", new BigDecimal("400.00")),
            new Client("563856300", new BigDecimal("1200.00"))
    );

    private final List<Transacao> transacoes = List.of(
            new Transacao(1, LocalDateTime.of(2023, 9, 9, 14, 15, 0), "938485762", "2147483649", new BigDecimal("150.00")),
            new Transacao(2, LocalDateTime.of(2023, 9, 9, 14, 15, 5), "2147483649", "210385733", new BigDecimal("149.00")),
            new Transacao(3, LocalDateTime.of(2023, 9, 9, 14, 15, 29), "347586970", "238596054", new BigDecimal("1100.00")),
            new Transacao(4, LocalDateTime.of(2023, 9, 9, 14, 17, 0), "675869708", "210385733", new BigDecimal("5300.00")),
            new Transacao(5, LocalDateTime.of(2023, 9, 9, 14, 18, 0), "238596054", "674038564", new BigDecimal("1489.00")),
            new Transacao(6, LocalDateTime.of(2023, 9, 9, 14, 18, 20), "573659065", "563856300", new BigDecimal("49.00")),
            new Transacao(7, LocalDateTime.of(2023, 9, 9, 14, 19, 0), "938485762", "2147483649", new BigDecimal("44.00")),
            new Transacao(8, LocalDateTime.of(2023, 9, 9, 14, 19, 1), "573659065", "675869708", new BigDecimal("150.00"))
    );

    public List<Cliente> getClientes() {
        return clientes;
    }

    public List<Transacao> getTransacoes() {
        return transacoes;
    }
}
