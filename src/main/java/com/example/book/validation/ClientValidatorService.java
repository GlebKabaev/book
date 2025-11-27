package com.example.book.validation;

import com.example.book.dto.ClientDto;
import com.example.book.exception.ClientException;
import com.example.book.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ClientValidatorService {
    private final ClientRepository clientRepository;
    private final String clientNotExistsMessage;

    public ClientValidatorService(ClientRepository clientRepository,
                                  @Value("${app.client.exception-message.not-exist}") String clientNotExistsMessage) {
        this.clientRepository = clientRepository;
        this.clientNotExistsMessage = clientNotExistsMessage;
    }


    public void ensureClientExistById(UUID clientId) {
        if (!clientRepository.existsById(clientId)) {
            throw new ClientException(clientNotExistsMessage);
        }

    }
}
