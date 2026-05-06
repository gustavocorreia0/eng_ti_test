import model.Transaction;
import repository.ClientRepository;
import service.TransactionService;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) {

        ClientRepository repository = new ClientRepository();
        TransactionService service = new TransactionService(repository);

        List<Transaction> transacoes = List.of(
                new Transaction(1, LocalDateTime.parse("2023-09-09T14:15:00"), "938485762", "2147483649", new BigDecimal("150")),
                new Transaction(2, LocalDateTime.parse("2023-09-09T14:15:05"), "2147483649", "210385733", new BigDecimal("149")),
                new Transaction(3, LocalDateTime.parse("2023-09-09T14:15:29"), "347586970", "238596054", new BigDecimal("1100")),
                new Transaction(4, LocalDateTime.parse("2023-09-09T14:17:00"), "675869708", "210385733", new BigDecimal("5300")),
                new Transaction(5, LocalDateTime.parse("2023-09-09T14:18:00"), "238596054", "674038564", new BigDecimal("1489")),
                new Transaction(6, LocalDateTime.parse("2023-09-09T14:18:20"), "573659065", "563856300", new BigDecimal("49")),
                new Transaction(7, LocalDateTime.parse("2023-09-09T14:19:00"), "938485762", "2147483649", new BigDecimal("44")),
                new Transaction(8, LocalDateTime.parse("2023-09-09T14:19:01"), "573659065", "675869708", new BigDecimal("150"))
        );

        transacoes.stream().sorted(Comparator.comparing(Transaction::getDatetime)).forEach(service::postTransaction);

    }

}