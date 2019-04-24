package com.koulgar.springapidemo.entity;

public class Line {
    private String type;
    private Value value;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Value getValue() {
        return value;
    }

    public void setValue(Value value) {
        this.value = value;
    }

    public Line() {
    }

    @Override
    public String toString() {
        return "Line{" +
                "type='" + type + '\'' +
                ", value=" + value +
                '}';
    }
}
