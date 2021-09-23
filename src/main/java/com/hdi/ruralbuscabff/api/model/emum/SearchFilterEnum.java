package com.hdi.ruralbuscabff.api.model.emum;

public enum SearchFilterEnum {

    PROPOSAL_DATE("ProposalDate","ProposalDate");

    private String key;
    private String value;

    SearchFilterEnum(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}