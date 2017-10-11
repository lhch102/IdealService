package com.ideal.pojo;

import java.util.Date;

public class MovieInfo {
    private Integer id;

    private String chineseName;

    private String englishName;

    private String ask;

    private String images;

    private Float grade;

    private String country;

    private Date filmYears;

    private String filmTypes;

    private String filmLabel;

    private Integer movieListId;

    private String filmSource;

    private String mediumType;

    private Integer filmTime;

    private Integer heat;

    private Integer createId;

    private Date createTime;

    private Integer modifyId;

    private Date modifyTime;

    private String introduction;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getChineseName() {
        return chineseName;
    }

    public void setChineseName(String chineseName) {
        this.chineseName = chineseName == null ? null : chineseName.trim();
    }

    public String getEnglishName() {
        return englishName;
    }

    public void setEnglishName(String englishName) {
        this.englishName = englishName == null ? null : englishName.trim();
    }

    public String getAsk() {
        return ask;
    }

    public void setAsk(String ask) {
        this.ask = ask == null ? null : ask.trim();
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images == null ? null : images.trim();
    }

    public Float getGrade() {
        return grade;
    }

    public void setGrade(Float grade) {
        this.grade = grade;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country == null ? null : country.trim();
    }

    public Date getFilmYears() {
        return filmYears;
    }

    public void setFilmYears(Date filmYears) {
        this.filmYears = filmYears;
    }

    public String getFilmTypes() {
        return filmTypes;
    }

    public void setFilmTypes(String filmTypes) {
        this.filmTypes = filmTypes == null ? null : filmTypes.trim();
    }

    public String getFilmLabel() {
        return filmLabel;
    }

    public void setFilmLabel(String filmLabel) {
        this.filmLabel = filmLabel == null ? null : filmLabel.trim();
    }

    public Integer getMovieListId() {
        return movieListId;
    }

    public void setMovieListId(Integer movieListId) {
        this.movieListId = movieListId;
    }

    public String getFilmSource() {
        return filmSource;
    }

    public void setFilmSource(String filmSource) {
        this.filmSource = filmSource == null ? null : filmSource.trim();
    }

    public String getMediumType() {
        return mediumType;
    }

    public void setMediumType(String mediumType) {
        this.mediumType = mediumType == null ? null : mediumType.trim();
    }

    public Integer getFilmTime() {
        return filmTime;
    }

    public void setFilmTime(Integer filmTime) {
        this.filmTime = filmTime;
    }

    public Integer getHeat() {
        return heat;
    }

    public void setHeat(Integer heat) {
        this.heat = heat;
    }

    public Integer getCreateId() {
        return createId;
    }

    public void setCreateId(Integer createId) {
        this.createId = createId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getModifyId() {
        return modifyId;
    }

    public void setModifyId(Integer modifyId) {
        this.modifyId = modifyId;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction == null ? null : introduction.trim();
    }
}