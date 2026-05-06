import model.Transaction;
import repository.ClientRepository;
import service.TransactionService;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;

public class Tests {

    public static void main(String[] args) {

        checkApprovedTransaction();
        checkDisapprovedTransaction();
        checkDatetimeOrder();

        System.out.println("Todos os testes foram concluídos!");

    }

    private static void assertEquals(BigDecimal expected, BigDecimal actual) {
        if (expected.compareTo(actual) != 0) {
            throw new RuntimeException("Teste falhou. Esperado: " + expected + " | Atual: " + actual);
        }
    }

    private static void checkApprovedTransaction() {
        ClientRepository repository = new ClientRepository();
        TransactionService service = new TransactionService(repository);

        Transaction transaction = new Transaction(1, LocalDateTime.parse("2023-09-09T14:15:00"),"938485762","2147483649",new BigDecimal("150"));
        service.postTransaction(transaction);

        assertEquals(new BigDecimal("30"), repository.findClient("938485762").getSaldo());
        assertEquals(new BigDecimal("150"), repository.findClient("2147483649").getSaldo());
    }

    private static void checkDisapprovedTransaction() {
        ClientRepository repository = new ClientRepository();
        TransactionService service = new TransactionService(repository);

        Transaction transaction = new Transaction(4, LocalDateTime.parse("2023-09-09T14:17:00"),"675869708","210385733", new BigDecimal("5300"));
        service.postTransaction(transaction);

        assertEquals(new BigDecimal("4900"), repository.findClient("675869708").getSaldo());
        assertEquals(new BigDecimal("10"), repository.findClient("210385733").getSaldo());
    }

    private static void checkDatetimeOrder() {
        ClientRepository repository = new ClientRepository();
        TransactionService service = new TransactionService(repository);

        List<Transaction> transactions = List.of(
                new Transaction(2, LocalDateTime.parse("2023-09-09T14:15:05"), "2147483649", "210385733", new BigDecimal("149")),
                new Transaction(1, LocalDateTime.parse("2023-09-09T14:15:00"), "938485762", "2147483649", new BigDecimal("150"))
        );
        transactions.stream().sorted(Comparator.comparing(Transaction::getDatetime)).forEach(service::postTransaction);

        assertEquals(new BigDecimal("30"), repository.findClient("938485762").getSaldo());
        assertEquals(new BigDecimal("1"), repository.findClient("2147483649").getSaldo());
        assertEquals(new BigDecimal("159"), repository.findClient("210385733").getSaldo());
    }

}
