package com.zzy.po;

/**
 * @Author shitongtong
 * <p>
 * Created by shitongtong on 2018/5/3.
 */
public class Movie extends BasePo{
    private String movieUuid;
    private String name;
    private String url;
    private String director;
    private String screenwriter;
    private String starring;
    private String intro;
    private String photo;

    public String getMovieUuid() {
        return movieUuid;
    }

    public void setMovieUuid(String movieUuid) {
        this.movieUuid = movieUuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getScreenwriter() {
        return screenwriter;
    }

    public void setScreenwriter(String screenwriter) {
        this.screenwriter = screenwriter;
    }

    public String getStarring() {
        return starring;
    }

    public void setStarring(String starring) {
        this.starring = starring;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
