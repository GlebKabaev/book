package com.example.book.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookRentalDto {
    @NotNull
    private ClientDto clientDto;
    @NotNull
    private BookDto bookDto;
    @NotNull
    private LocalDate date;
}
