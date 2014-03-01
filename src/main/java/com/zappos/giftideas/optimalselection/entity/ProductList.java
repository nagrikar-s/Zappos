package com.zappos.giftideas.optimalselection.entity;

import java.util.Set;

public class ProductList {
    private Set<Product> productList;
    private double totalPrice;
    private int maxIndex;

    public int getMaxIndex() {
        return maxIndex;
    }

    public void setMaxIndex(int maxIndex) {
        this.maxIndex = maxIndex;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Set<Product> getProductList() {
        return productList;
    }

    public void setProductList(Set<Product> productList) {
        this.productList = productList;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + maxIndex;
        result = prime * result + ((productList == null) ? 0 : productList.hashCode());
        long temp;
        temp = Double.doubleToLongBits(totalPrice);
        result = prime * result + (int) (temp ^ (temp >>> 32));
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
        ProductList other = (ProductList) obj;
        if (maxIndex != other.maxIndex)
            return false;
        if (productList == null) {
            if (other.productList != null)
                return false;
        } else if (!productList.equals(other.productList))
            return false;
        if (Double.doubleToLongBits(totalPrice) != Double.doubleToLongBits(other.totalPrice))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "ProductList [productList=" + productList + ", totalPrice=" + totalPrice + ", maxIndex=" + maxIndex + "]";
    }

}
