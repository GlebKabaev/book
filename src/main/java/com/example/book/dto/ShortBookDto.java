package com.example.book.dto;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class ShortBookDto {
    @NotBlank
    private String name;

    @NotBlank
    private String author;

    @NotBlank
    private String isbn;


}
