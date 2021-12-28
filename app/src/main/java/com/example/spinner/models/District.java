package com.example.spinner.models;

public class District {
    private String id;
    private String name;
    private String type;
    private String provinceId;

    public District() {
    }

    public District(String id, String name, String type, String provinceId) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.provinceId = provinceId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(String provinceId) {
        this.provinceId = provinceId;
    }
}
