package com.botvin.model;

public enum Color {

    BLACK (0),
    WHITE (1),
    RED (2),
    YELLOW (3),
    GREEN (4),
    BLUE (5),
    VIOLET (6);

    private int colorNumber;

    Color(int colorNumber){
        this.colorNumber = colorNumber;
    }

    public int getColorNumber(){
        return colorNumber;
    }
}


