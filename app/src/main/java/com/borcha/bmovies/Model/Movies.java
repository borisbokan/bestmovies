package com.borcha.bmovies.Model;

import java.util.ArrayList;

public class Movies {

    private int page;
    private int total_results;
    private int total_page;
    private ArrayList<MyMovie> results;

    public Movies() {
    }

    public Movies(int page, int total_results, int total_page, ArrayList<MyMovie> results) {
        this.page = page;
        this.total_results = total_results;
        this.total_page = total_page;
        this.results = results;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getTotal_results() {
        return total_results;
    }

    public void setTotal_results(int total_results) {
        this.total_results = total_results;
    }

    public int getTotal_page() {
        return total_page;
    }

    public void setTotal_page(int total_page) {
        this.total_page = total_page;
    }

    public ArrayList<MyMovie> getResults() {
        return results;
    }

    public void setResults(ArrayList<MyMovie> results) {
        this.results = results;
    }
}
