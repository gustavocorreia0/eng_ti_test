package service;

import model.Client;
import model.Transaction;
import repository.ClientRepository;

public class TransactionService {

    private final ClientRepository clientRepository;



    public TransactionService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public synchronized void postTransaction(Transaction transaction) {
        Client origem = clientRepository.findClient(transaction.getId_conta_debito());
        Client destino = clientRepository.findClient(transaction.getId_conta_credito());

        if (origem.getSaldo().compareTo(transaction.getValor()) < 0) {
            System.out.printf(
                "Transacao foi cancelada por falta de saldo! Saldo disponível: %s   Valor da Transação: %s%n",
                origem.getSaldo(),
                transaction.getValor()
            );
            return;
        }

        origem.debitar(transaction.getValor());
        destino.creditar(transaction.getValor());

        clientRepository.saveClient(origem);
        clientRepository.saveClient(destino);

        System.out.printf(
                "Transação foi efetivada com sucesso! Novos saldos: Conta Origem: %s | Conta Destino: %s%n",
                origem.getSaldo(),
                destino.getSaldo()
        );

    }

}
