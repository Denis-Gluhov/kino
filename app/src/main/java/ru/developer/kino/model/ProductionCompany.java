package ru.developer.kino.model;

import com.google.gson.annotations.SerializedName;

public class ProductionCompany {

    @SerializedName("name")
    private String name;

    @SerializedName("id")
    private Integer id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
