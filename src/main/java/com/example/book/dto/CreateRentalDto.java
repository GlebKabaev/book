package com.example.book.dto;


import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.NotNull;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class CreateRentalDto {
    @NotNull
    private UUID clientId;
    @NotNull
    private UUID bookId;
}
