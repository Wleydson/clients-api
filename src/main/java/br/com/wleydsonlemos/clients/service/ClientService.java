package br.com.wleydsonlemos.clients.service;

import br.com.wleydsonlemos.clients.model.entity.Client;
import br.com.wleydsonlemos.clients.model.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class ClientService {

    @Autowired
    private ClientRepository repository;

    public Client save(Client client) {
        return repository.save(client);
    }

    public Client findById(Integer id) {
        return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "client not found."));
    }

    public void deleteById(Integer id) {
        repository
                .findById(id)
                .map(client -> {
                    repository.delete(client);
                    return Void.TYPE;
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "client not found."));
    }

    public void updateById(Integer id, Client newClient) {
        repository
                .findById(id)
                .map(client -> {
                        newClient.setId(client.getId());
                        newClient.setDateRegister(client.getDateRegister());
                        return repository.save(newClient);
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "client not found."));

    }
}
