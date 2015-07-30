package com.example.ahmed.stpblog;

import android.content.Context;
import android.content.res.Resources;

import java.util.ArrayList;


public class ArticleFactory {
    public static int NUM_OF_ARTICLE = 10;
    private ArrayList<Article> articles;
    private static ArticleFactory sArticleFactory;
    private Context appContext;
    Resources resources = Resources.getSystem();
    String[] titles = new String[NUM_OF_ARTICLE];
    String[] summaries = new String[NUM_OF_ARTICLE];
    String[] contents = new String[NUM_OF_ARTICLE];
    String[] image_urls = new String[NUM_OF_ARTICLE];


    private ArticleFactory(Context appContext) {
        this.appContext = appContext;
        titles = appContext.getResources().getStringArray(R.array.titles_array);
        contents = appContext.getResources().getStringArray(R.array.details_array);
        image_urls = appContext.getResources().getStringArray(R.array.image_url_array);
        summaries = appContext.getResources().getStringArray(R.array.summary_array);
        articles = new ArrayList<Article>();
        for (int i = 0; i < NUM_OF_ARTICLE; i++) {
            Article article = new Article();
            article.setArticle_content(contents[i]);
            article.setArticle_image_url(image_urls[i]);
            article.setArticle_summary(summaries[i]);
            article.setArticle_title(titles[i]);
            articles.add(article);
        }

    }

    public static ArticleFactory getArticleFactory(Context context) {
        if (sArticleFactory == null) {
            return new ArticleFactory(context.getApplicationContext());
        }
        return sArticleFactory;
    }

    public ArrayList<Article> getArticles() {
        return articles;
    }
}

