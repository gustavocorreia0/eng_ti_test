import model.Transaction;
import repository.ClientRepository;
import service.TransactionService;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Tests {

    public static void main(String[] args) {

        checkRealizedTransaction();

        System.out.println("Todos os testes foram concluídos!");

    }

    private static void assertEquals(BigDecimal expected, BigDecimal actual) {
        if (expected.compareTo(actual) != 0) {
            throw new RuntimeException("Teste falhou. Esperado: " + expected + " | Atual: " + actual);
        }
    }

    private static void checkRealizedTransaction() {
        ClientRepository repository = new ClientRepository();
        TransactionService service = new TransactionService(repository);

        Transaction transaction = new Transaction(1, LocalDateTime.parse("2023-09-09T14:15:00"),"938485762","2147483649",new BigDecimal("150"));
        service.postTransaction(transaction);

        assertEquals(new BigDecimal("30"), repository.findClient("938485762").getSaldo());
        assertEquals(new BigDecimal("150"), repository.findClient("2147483649").getSaldo());
    }



}
