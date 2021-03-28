package com.devflask.roboflask.util;

public enum EmbedColor {

    DEFAULT(5208744),
    ERROR(16537691),
    SUCCESS(6612580),
    MODERATION(12084205);

    public final Integer color;
    EmbedColor(Integer color){
        this.color = color;
    }
}
