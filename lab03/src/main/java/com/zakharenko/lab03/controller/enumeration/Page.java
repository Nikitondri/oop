package com.zakharenko.lab03.controller.enumeration;

public enum Page {
    TABLE("/jsp/table.jsp"),
    HOME("index.jsp"),
    ERROR("/jsp/error.jsp");

    private final String value;

    Page(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
