package repository;

import model.Client;

import java.math.BigDecimal;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ClientRepository {

    private final Map<String, Client> clientes = new ConcurrentHashMap<>();

    public ClientRepository() {
        clientes.put("938485762", new Client("938485762", new BigDecimal("180")));
        clientes.put("347586970", new Client("347586970", new BigDecimal("1200")));
        clientes.put("2147483649", new Client("2147483649", BigDecimal.ZERO));
        clientes.put("675869708", new Client("675869708", new BigDecimal("4900")));
        clientes.put("238596054", new Client("238596054", new BigDecimal("478")));
        clientes.put("573659065", new Client("573659065", new BigDecimal("787")));
        clientes.put("210385733", new Client("210385733", new BigDecimal("10")));
        clientes.put("674038564", new Client("674038564", new BigDecimal("400")));
        clientes.put("563856300", new Client("563856300", new BigDecimal("1200")));
    }

    public Client findClient(String id) {
        return clientes.get(id);
    }

    public void saveClient(Client client) {
        clientes.put(client.getId_conta(), client);
    }

}
