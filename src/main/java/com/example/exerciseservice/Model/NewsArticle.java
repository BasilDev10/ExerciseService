package com.example.exerciseservice.Model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class NewsArticle {

    @NotEmpty(message = "Error: id is empty!")
    private String id;
    @NotEmpty(message = "Error: title is empty!")
    @Size(max = 100 , message = "Error: title the max length is 100")
    private String title;
    @NotEmpty(message = "Error: author is empty!")
    @Size(min = 4 , max = 20 , message = "Error: author is between 4 and 20")
    private String author;
    @NotEmpty(message = "Error: content is empty!")
    @Size(max =200 , message = "Error: content the max length is 200")
    private String content;
    @NotEmpty(message = "Error: category is empty!")
    @Pattern(regexp = "politics|sports|technology", message = "Error: only accept this category: politics|sports|technology")
    private String category;
    @NotEmpty(message = "Error: imageURL is empty!")
    private String imageURl;
    @NotNull
    @AssertFalse
    private boolean published;
    @PastOrPresent(message = "Error: only accept today date or past date")
    private LocalDate publishDate;
}
