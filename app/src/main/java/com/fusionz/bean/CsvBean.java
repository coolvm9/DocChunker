package com.fusionz.bean;

import com.opencsv.bean.CsvBindByName;



public class CsvBean {

    @CsvBindByName(column = "filename")
    private String filename;

    @CsvBindByName(column = "title")
    private String title;

    @CsvBindByName(column = "page number")
    private int pageNumber;

    @CsvBindByName(column = "chunk index")
    private int chunkIndex;

    @CsvBindByName(column = "chunk text")
    private String chunkText;

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getChunkIndex() {
        return chunkIndex;
    }

    public void setChunkIndex(int chunkIndex) {
        this.chunkIndex = chunkIndex;
    }

    public String getChunkText() {
        return chunkText;
    }

    public void setChunkText(String chunkText) {
        this.chunkText = chunkText;
    }





}
