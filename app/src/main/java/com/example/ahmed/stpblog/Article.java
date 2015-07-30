package com.example.ahmed.stpblog;

import android.content.res.Resources;

/**
 * Cresourcesated by ahmed on 28/07/15.
 */
public class Article {
    private int position = 0;
    private String article_content;
    private String article_summary;
    private String article_title;
    private String article_image_url;

    public void setArticle_content(String article_content) {
        this.article_content = article_content;
    }

    public void setArticle_summary(String article_summary) {
        this.article_summary = article_summary;
    }

    public void setArticle_title(String article_title) {
        this.article_title = article_title;
    }

    public void setArticle_image_url(String article_image_url) {
        this.article_image_url = article_image_url;
    }

    public String getArticle_content() {

        return article_content;
    }

    public String getArticle_summary() {
        return article_summary;
    }

    public String getArticle_title() {
        return article_title;
    }

    public String getArticle_image_url() {
        return article_image_url;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getPosition() {
        return position;
    }
}
