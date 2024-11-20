package com.example.exerciseservice.Service;

import com.example.exerciseservice.Model.NewsArticle;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;

@Service
public class NewsArticleService {


    ArrayList<NewsArticle> newsArticles = new ArrayList<>();

    public NewsArticleService(){
        newsArticles.add(new NewsArticle("NA222","Barcalona","basil","sdsd sdasd asd","sports","image.com",false, LocalDate.of(2022,1,1) ));
        newsArticles.add(new NewsArticle("NA333","Hilal","Mohammed","sdsd sdasd asd","sports","image.com",false, LocalDate.of(2024,1,1) ));
        newsArticles.add(new NewsArticle("NA444","Trump","Sami","sdsd sdasd asd","politics","image.com",false, LocalDate.of(2023,1,1) ));
        newsArticles.add(new NewsArticle("NA555","Baiden","Abdullah","sdsd sdasd asd","politics","image.com",false, LocalDate.of(2020,1,1) ));
        newsArticles.add(new NewsArticle("NA666","Kamala","Abdulrahman","sdsd sdasd asd","politics","image.com",false, LocalDate.of(2023,1,1) ));
        newsArticles.add(new NewsArticle("NA777","Java","Anas","sdsd sdasd asd","technology","image.com",false, LocalDate.of(2021,1,1) ));

    }

    public ArrayList<NewsArticle> getNewsArticles(){
        return newsArticles;
    }
    public ArrayList<NewsArticle> getPublishedNewsArticle(){
        ArrayList<NewsArticle> newsArticlesFound = new ArrayList<>();
        for (NewsArticle n : newsArticles){
            if (n.isPublished()){
                newsArticlesFound.add(n);
            }
        }
        return newsArticlesFound;
    }
    public ArrayList<NewsArticle> getByCategoryNewsArticle(String category){
        ArrayList<NewsArticle> newsArticlesFound = new ArrayList<>();
        for (NewsArticle n : newsArticles){
            if (n.getCategory().equalsIgnoreCase(category)){
                newsArticlesFound.add(n);
            }
        }
        return newsArticlesFound;

    }
    public void addNewsArticle(NewsArticle newsArticle){

        newsArticles.add(newsArticle);
    }
    public boolean updateNewsArticle(String id,NewsArticle newsArticle){

        for (int i =0 ; i < newsArticles.size(); i++){
            if(newsArticles.get(i).getId().equalsIgnoreCase(id)){
                newsArticles.set(i,newsArticle);
                return true;
            }
        }
        return false;
    }
    public boolean deleteNewsArticle(String id){

        for (int i =0 ; i < newsArticles.size(); i++){
            if(newsArticles.get(i).getId().equalsIgnoreCase(id)){
                newsArticles.remove(i);
                return true;
            }
        }
        return false;
    }

}
