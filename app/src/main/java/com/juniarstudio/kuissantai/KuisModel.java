package com.juniarstudio.kuissantai;

public class KuisModel {
    private int level;
    private String pertanyaan;
    private String jawaban;

    public KuisModel(int level, String pertanyaan, String jawaban) {
        this.level = level;
        this.pertanyaan = pertanyaan;
        this.jawaban = jawaban;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getPertanyaan() {
        return pertanyaan;
    }

    public void setPertanyaan(String pertanyaan) {
        this.pertanyaan = pertanyaan;
    }

    public String getJawaban() {
        return jawaban;
    }

    public void setJawaban(String jawaban) {
        this.jawaban = jawaban;
    }
}
