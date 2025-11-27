package com.example.book.dto;

import lombok.*;
import javax.validation.constraints.NotNull;
import java.util.UUID;


@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
public class UpdateBookDto extends BookDto {
    @NotNull
    @Getter
    private UUID id;

}
