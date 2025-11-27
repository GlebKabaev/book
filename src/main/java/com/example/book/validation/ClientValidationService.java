package com.example.book.validation;

import com.example.book.dto.ClientDto;
import com.example.book.dto.ShortClientDto;
import com.example.book.exception.ClientException;
import com.example.book.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ClientValidationService {
    private final ClientRepository clientRepository;
    private final String clientNotExistsMessage;

    public ClientValidationService(ClientRepository clientRepository,
                                   @Value("${app.client.exception-message.not-exist}") String clientNotExistsMessage) {
        this.clientRepository = clientRepository;
        this.clientNotExistsMessage = clientNotExistsMessage;
    }


    public void ensureClientExistById(ClientDto clientDto) {
        if (!clientRepository.existsById(clientDto.getId())) {
            throw new ClientException(clientNotExistsMessage);
        }

    }
}
