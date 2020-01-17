package com.juniarstudio.kuissantai;

public class ItemJawabanModel {
    private int posisi;
    private char aChar;

    public ItemJawabanModel(int posisi, char aChar) {
        this.posisi = posisi;
        this.aChar = aChar;
    }

    public int getPosisi() {
        return posisi;
    }

    public void setPosisi(int posisi) {
        this.posisi = posisi;
    }

    public char getaChar() {
        return aChar;
    }

    public void setaChar(char aChar) {
        this.aChar = aChar;
    }
}
