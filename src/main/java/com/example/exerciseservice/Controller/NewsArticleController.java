package com.example.exerciseservice.Controller;

import com.example.exerciseservice.ApiResponse.ApiResponse;
import com.example.exerciseservice.Model.NewsArticle;
import com.example.exerciseservice.Service.NewsArticleService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/news-article")
@RequiredArgsConstructor
public class NewsArticleController {

    private final NewsArticleService newsArticleService;

    @GetMapping("/get")
    public ResponseEntity getNewsArticle(){
        return ResponseEntity.ok(newsArticleService.getNewsArticles());
    }
    @GetMapping("/get-all-published")
    public ResponseEntity getPublishedNewsArticle(){

        ArrayList<NewsArticle> newsArticlesFound = newsArticleService.getPublishedNewsArticle();
        if(newsArticlesFound.size() > 0)return ResponseEntity.ok(newsArticlesFound);
        else return ResponseEntity.status(400).body(new ApiResponse("published news article not found"));
    }
    @GetMapping("/get-all-searched/{category}")
    public ResponseEntity getByCategoryNewsArticle(@PathVariable String category){

        ArrayList<NewsArticle> newsArticlesFound = newsArticleService.getByCategoryNewsArticle(category);
        if(newsArticlesFound.size() > 0)return ResponseEntity.ok(newsArticlesFound);
        else return ResponseEntity.status(400).body(new ApiResponse("category searched news article not found"));
    }
    @PostMapping("/add")
    public ResponseEntity addNewArticle(@RequestBody @Valid NewsArticle newsArticle , Errors errors){

        if (errors.hasErrors())return ResponseEntity.status(400).body(new ApiResponse(errors.getFieldError().getDefaultMessage()));

        newsArticleService.addNewsArticle(newsArticle);
        return ResponseEntity.status(201).body(new ApiResponse("News Article is added"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateNewsArticle(@PathVariable String id,@RequestBody @Valid NewsArticle newsArticle ,Errors errors){
        if (errors.hasErrors())return ResponseEntity.status(400).body(new ApiResponse(errors.getFieldError().getDefaultMessage()));

        if(newsArticleService.updateNewsArticle(id,newsArticle))return ResponseEntity.ok(new ApiResponse("New Article is updated"));
        else return ResponseEntity.status(400).body(new ApiResponse("Error : id not found"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteNewsArticle(@PathVariable String id){
        if(newsArticleService.deleteNewsArticle(id))return ResponseEntity.ok(new ApiResponse("New Article is deleted"));
        else return ResponseEntity.status(400).body(new ApiResponse("Error : id not found"));
    }

}
