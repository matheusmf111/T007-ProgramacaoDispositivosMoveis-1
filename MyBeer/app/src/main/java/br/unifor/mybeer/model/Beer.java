package br.unifor.mybeer.model;

/**
 * Created by Bruno Lopes on 04/05/2017.
 */

public class Beer implements IModel{

    private Integer id;
    private String name;
    private String brand;
    private Integer volume;
    private String kind;
    private Integer score;
    private String picture;

    public Beer(Integer id, String name, String brand, Integer volume, String kind, Integer score, String picture) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.volume = volume;
        this.kind = kind;
        this.score = score;
        this.picture = picture;
    }

    public Beer(String name, String brand, Integer volume, String kind, Integer score, String picture) {
        this(null, name, brand, volume, kind, score, picture);
    }

    public Beer() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Integer getVolume() {
        return volume;
    }

    public void setVolume(Integer volume) {
        this.volume = volume;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
}
