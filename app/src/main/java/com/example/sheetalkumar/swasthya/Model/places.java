package com.example.sheetalkumar.swasthya.Model;

public class places {
        private String dengue;
        private String fever;
        private String maleriya;

    public places(String dengue, String fever, String maleriya) {
        this.dengue = dengue;
        this.fever = fever;
        this.maleriya = maleriya;
    }

    public places() {
    }

    public String getDengue() {
        return dengue;
    }

    public String getFever() {
        return fever;
    }

    public String getMaleriya() {
        return maleriya;
    }
}
