package com.example.sheetalkumar.swasthya.Model;



/*
      @author - Sheetal Kumar
 */


public class ItemsWithImage {

    private Integer productImage;
    private String companyName;
    private String itemType;
    private String prize;

    boolean Fav;

    public ItemsWithImage(Integer productImage, String companyName, String itemType, String prize, boolean fav) {
        this.productImage = productImage;
        this.companyName = companyName;
        this.itemType = itemType;
        this.prize = prize;
        Fav = fav;
    }

    public ItemsWithImage() {
    }

    public Integer getProductImage() {
        return productImage;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getItemType() {
        return itemType;
    }

    public String getPrize() {
        return prize;
    }

    public boolean isFav() {
        return Fav;
    }
}
