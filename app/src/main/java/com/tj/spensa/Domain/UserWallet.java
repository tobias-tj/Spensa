package com.tj.spensa.Domain;

public class UserWallet {
    private String titleItemWallet;
    private Integer priceItemWallet;
    private String dateItemWallet;
    private String iconWallet;
    private String typeMoney;

    public UserWallet(String titleItemWallet, Integer priceItemWallet, String dateItemWallet, String iconWallet, String typeMoney) {
        this.titleItemWallet = titleItemWallet;
        this.priceItemWallet = priceItemWallet;
        this.dateItemWallet = dateItemWallet;
        this.iconWallet = iconWallet;
        this.typeMoney = typeMoney;
    }

    public String getTitleItemWallet() {
        return titleItemWallet;
    }

    public void setTitleItemWallet(String titleItemWallet) {
        this.titleItemWallet = titleItemWallet;
    }

    public Integer getPriceItemWallet() {
        return priceItemWallet;
    }

    public void setPriceItemWallet(Integer priceItemWallet) {
        this.priceItemWallet = priceItemWallet;
    }

    public String getDateItemWallet() {
        return dateItemWallet;
    }

    public void setDateItemWallet(String dateItemWallet) {
        this.dateItemWallet = dateItemWallet;
    }

    public String getIconWallet() {
        return iconWallet;
    }

    public void setIconWallet(String iconWallet) {
        this.iconWallet = iconWallet;
    }

    public String getTypeMoney() {
        return typeMoney;
    }

    public void setTypeMoney(String typeMoney) {
        this.typeMoney = typeMoney;
    }
}
