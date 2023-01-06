package com.newspaper.app.beans;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Articles {

    private Integer id;
    private String tittle;
    private Timestamp publish_date;
    private int views;
    private String abstracts;
    private String content;
    private String picture_main;
    private int preminum;
    private int status;
    private int categories_id;
    private Integer writer_id;
    

    public Articles(Integer id, String tittle, Timestamp publish_date, int views, String Abstracts, String content, String picture_main, int preminum, int status, int categories_id, Integer writer_id) {
        this.id = id;
        this.tittle = tittle;
        this.publish_date = publish_date;
        this.views = views;
        this.abstracts = Abstracts;
        this.content = content;
        this.picture_main = picture_main;
        this.preminum = preminum;
        this.status = status;
        this.categories_id = categories_id;
        this.writer_id = writer_id;
    }

    public Articles() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public Timestamp getPublish_date() {
        return publish_date;
    }

    public void setPublish_date(Timestamp publish_date) {
        this.publish_date = publish_date;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

   
	public String getAbstracts() {
		return abstracts;
	}

	public void setAbstracts(String abstracts) {
		this.abstracts = abstracts;
	}

	public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPicture_main() {
        return picture_main;
    }

    public void setPicture_main(String picture_main) {
        this.picture_main = picture_main;
    }

    public int getPreminum() {
        return preminum;
    }

    public void setPreminum(int preminum) {
        this.preminum = preminum;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getCategories_id() {
        return categories_id;
    }

    public void setCategories_id(int categories_id) {
        this.categories_id = categories_id;
    }

    public Integer getWriter_id() {
        return writer_id;
    }

    public void setWriter_id(Integer writer_id) {
        this.writer_id = writer_id;
    }

	@Override
	public String toString() {
		return "Articles [id=" + id + ", tittle=" + tittle + ", publish_date=" + publish_date + ", views=" + views
				+ ", abstracts=" + abstracts + ", content=" + content + ", picture_main=" + picture_main + ", preminum="
				+ preminum + ", status=" + status + ", categories_id=" + categories_id + ", writer_id=" + writer_id
				+ "]";
	}
    
    
}
