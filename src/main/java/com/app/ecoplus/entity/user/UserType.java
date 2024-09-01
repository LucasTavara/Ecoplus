package com.app.ecoplus.entity.user;


public enum UserType {

    FORNECEDOR("Fornecedor"),
    PRODUTOR("Produtor");

    private final String type;

    UserType(String type) {
        this.type = type;
    }
    public String getUserType(){
        return type;
    }
}
