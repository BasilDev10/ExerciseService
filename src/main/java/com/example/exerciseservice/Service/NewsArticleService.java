package com.example.exerciseservice.Service;

import com.example.exerciseservice.Model.NewsArticle;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class NewsArticleService {


    ArrayList<NewsArticle> newsArticles = new ArrayList<>();


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
