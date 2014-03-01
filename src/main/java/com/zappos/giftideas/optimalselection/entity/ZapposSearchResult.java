package com.zappos.giftideas.optimalselection.entity;

public class ZapposSearchResult {
    private String styleId;
    private String productId;
    private String brandName;
    private String productName;
    private String thumbnailImageUrl;
    private String originalPrice;
    private String price;
    private String percentOff;
    private String productUrl;

    public String getStyleId() {
        return styleId;
    }

    public void setStyleId(String styleId) {
        this.styleId = styleId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getThumbnailImageUrl() {
        return thumbnailImageUrl;
    }

    public void setThumbnailImageUrl(String thumbnailImageUrl) {
        this.thumbnailImageUrl = thumbnailImageUrl;
    }

    public String getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(String originalPrice) {
        this.originalPrice = originalPrice;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPercentOff() {
        return percentOff;
    }

    public void setPercentOff(String percentOff) {
        this.percentOff = percentOff;
    }

    public String getProductUrl() {
        return productUrl;
    }

    public void setProductUrl(String productUrl) {
        this.productUrl = productUrl;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((brandName == null) ? 0 : brandName.hashCode());
        result = prime * result + ((originalPrice == null) ? 0 : originalPrice.hashCode());
        result = prime * result + ((percentOff == null) ? 0 : percentOff.hashCode());
        result = prime * result + ((price == null) ? 0 : price.hashCode());
        result = prime * result + ((productId == null) ? 0 : productId.hashCode());
        result = prime * result + ((productName == null) ? 0 : productName.hashCode());
        result = prime * result + ((productUrl == null) ? 0 : productUrl.hashCode());
        result = prime * result + ((styleId == null) ? 0 : styleId.hashCode());
        result = prime * result + ((thumbnailImageUrl == null) ? 0 : thumbnailImageUrl.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ZapposSearchResult other = (ZapposSearchResult) obj;
        if (brandName == null) {
            if (other.brandName != null)
                return false;
        } else if (!brandName.equals(other.brandName))
            return false;
        if (originalPrice == null) {
            if (other.originalPrice != null)
                return false;
        } else if (!originalPrice.equals(other.originalPrice))
            return false;
        if (percentOff == null) {
            if (other.percentOff != null)
                return false;
        } else if (!percentOff.equals(other.percentOff))
            return false;
        if (price == null) {
            if (other.price != null)
                return false;
        } else if (!price.equals(other.price))
            return false;
        if (productId == null) {
            if (other.productId != null)
                return false;
        } else if (!productId.equals(other.productId))
            return false;
        if (productName == null) {
            if (other.productName != null)
                return false;
        } else if (!productName.equals(other.productName))
            return false;
        if (productUrl == null) {
            if (other.productUrl != null)
                return false;
        } else if (!productUrl.equals(other.productUrl))
            return false;
        if (styleId == null) {
            if (other.styleId != null)
                return false;
        } else if (!styleId.equals(other.styleId))
            return false;
        if (thumbnailImageUrl == null) {
            if (other.thumbnailImageUrl != null)
                return false;
        } else if (!thumbnailImageUrl.equals(other.thumbnailImageUrl))
            return false;
        return true;
    }
}