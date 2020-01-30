package com.example.quiz.pojoClass;

public class Interest {
    String literature,lifestyle,coding,movies,booze,cartoon,cricket,series,politics,food;
    public Interest(String literature, String lifestyle, String coding, String movies, String booze, String cartoon, String cricket, String series, String politics, String food) {
        this.literature = literature;
        this.lifestyle = lifestyle;
        this.coding = coding;
        this.movies = movies;
        this.booze = booze;
        this.cartoon = cartoon;
        this.cricket = cricket;
        this.series = series;
        this.politics = politics;
        this.food = food;
    }
    public String getLiterature() {
        return literature;
    }
    public void setLiterature(String literature) {
        this.literature = literature;
    }
    public String getLifestyle() {
        return lifestyle;
    }
    public void setLifestyle(String lifestyle) {
        this.lifestyle = lifestyle;
    }
    public String getCoding() {
        return coding;
    }
    public void setCoding(String coding) {
        this.coding = coding;
    }
    public String getMovies() {
        return movies;
    }
    public void setMovies(String movies) {
        this.movies = movies;
    }
    public String getBooze() {
        return booze;
    }
    public void setBooze(String booze) {
        this.booze = booze;
    }
    public String getCartoon() {
        return cartoon;
    }
    public void setCartoon(String cartoon) {
        this.cartoon = cartoon;
    }
    public String getCricket() {
        return cricket;
    }
    public void setCricket(String cricket) {
        this.cricket = cricket;
    }
    public String getSeries() {
        return series;
    }
    public void setSeries(String series) {
        this.series = series;
    }
    public String getPolitics() {
        return politics;
    }
    public void setPolitics(String politics) {
        this.politics = politics;
    }
    public String getFood() {
        return food;
    }
    public void setFood(String food) {
        this.food = food;
    }
}