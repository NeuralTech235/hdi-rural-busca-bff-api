package com.hdi.ruralbuscabff.api.model.emum;

public enum EBaoFilterEnum {

    CONDITIONS("Conditions","Conditions","Campos onde a condição de filtro é exatamente o procurado"),
    IN_CONDITIONS("InConditions","InConditions","Campos onde quero que aconteça uma determinada mescla de valores para um mesmo campo"),
    NOT_IN_CONDITIONS("NotInConditions","NotInConditions","Campos onde NÂO quero que aconteça uma determinada mescla de valores para um mesmo campo"),
    FUZZY_CONDITIONS("FuzzyConditions","FuzzyConditions","Pesquisa utilizando similaridade"),
    OR_FUZZY_CONDITIONS("OrFuzzyConditions","OrFuzzyConditions","Mesmo valor inserido para pesquisa em diferentes campos (LIKE)"),
    FROM_RANGE_CONDITIONS("FromRangeConditions","FromRangeConditions","Utilizar com campos data DESDE"),
    TO_RANGE_CONDITIONS("ToRangeConditions","ToRangeConditions","Utilizar com campos data ATE");

    private String key;
    private String value;
    private String description;

    EBaoFilterEnum(String key, String value, String description) {
        this.key = key;
        this.value = value;
        this.description = description;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
