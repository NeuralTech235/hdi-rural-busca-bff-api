package com.hdi.ruralbuscabff.api.model.emum;

public enum TypesEnum {
    QUOTES(1, "QUOTES", "QUOTES"),
    PROPOSAL(2, "PROPOSAL", "PROPOSAL"),
    POLICIES(3, "POLICIES", "POLICIES"),
    NOT_DEFINED(999, "NOT_DEFINED", "NOT_DEFINED");

    TypesEnum(Integer id, String key, String describe) {
        this.id = id;
        this.key = key;
        this.describe = describe;
    }

    private Integer id;
    private String key;
    private String describe;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
