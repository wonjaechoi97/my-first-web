package com.ssafy.backend.dto;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Book {
    private String isbn;
    private String title;
    private String author;
    private int price;
    private String desc; 
    private String img;
}
