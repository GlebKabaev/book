package com.example.book.service;

import com.example.book.dto.ShortClientDto;
import com.example.book.entity.Client;
import com.example.book.dto.ClientDto;
import com.example.book.repository.ClientRepository;
import com.example.book.validation.ClientValidationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ClientService {
    private final ClientRepository clientRepository;
    private final ClientValidationService clientValidationService;

    @Transactional
    public void createClient(ShortClientDto clientDto) {
        clientRepository.save(toEntity(clientDto));
    }

    @Transactional
    public void updateClient(ClientDto clientDto) {
        clientValidationService.ensureClientExistById(clientDto);
        clientRepository.save(toEntity(clientDto));
    }
    @Transactional(readOnly = true)
    public List<ClientDto> findAllClients(){
        return clientRepository.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    public ClientDto toDto(Client client) {
        return ClientDto.builder()
                .id(client.getId())
                .firstName(client.getFirstName())
                .secondName(client.getSecondName())
                .middleName(client.getMiddleName())
                .birthDate(client.getBirthDate())
                .build();
    }

    public Client toEntity(ShortClientDto dto) {
        return Client.builder()
                .id(UUID.randomUUID())
                .firstName(dto.getFirstName())
                .secondName(dto.getSecondName())
                .middleName(dto.getMiddleName())
                .birthDate(dto.getBirthDate())
                .build();
    }

    public Client toEntity(ClientDto dto) {
        return Client.builder()
                .id(dto.getId())
                .firstName(dto.getFirstName())
                .secondName(dto.getSecondName())
                .middleName(dto.getMiddleName())
                .birthDate(dto.getBirthDate())
                .build();
    }

}
