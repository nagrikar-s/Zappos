package com.zappos.giftideas.optimalselection;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.zappos.giftideas.optimalselection.entity.Product;
import com.zappos.giftideas.optimalselection.entity.ProductList;

public class OptimalSelection {
    private ZapposAPIHandler handler;

    public void setHandler(ZapposAPIHandler handler) {
        this.handler = handler;
    }

    public List<ProductList> getOptimalSelection(double totalExpectedPrice, int itemCount) throws Exception {
        double diffAllowed = totalExpectedPrice / 10.0;
        List<ProductList> finalProductLists = new ArrayList<>();
        List<ProductList> newFinalList = new ArrayList<>();

        // Get at least 10000 products in the order of popularity
        List<Product> products = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            List<Product> nextProducts = handler.search(totalExpectedPrice, i);
            if (!nextProducts.isEmpty()) {
                products.addAll(nextProducts);
            } else
                break;
        }
        for (int i = 0; i < products.size(); i++) {
            // add only the products that has price less than total price
            // expected
            if (products.get(i).getPrice() <= totalExpectedPrice) {
                ProductList productList = new ProductList();
                Set<Product> pList = new HashSet<>();
                pList.add(products.get(i));
                productList.setProductList(pList);
                productList.setTotalPrice(products.get(i).getPrice());
                productList.setMaxIndex(i);
                finalProductLists.add(productList);

            }
        }
        boolean addedNewItems = false;
        do {
            addedNewItems = false;
            for (int i = 0; i < finalProductLists.size(); i++) {
                ProductList pList = finalProductLists.get(i);
                if (pList.getProductList().size() == itemCount && Math.abs(pList.getTotalPrice() - totalExpectedPrice) <= diffAllowed) {
                    newFinalList.add(pList);
                    // retain the pList in finalProductList
                    continue;
                }

                if (pList.getTotalPrice() < totalExpectedPrice) {
                    for (int j = pList.getMaxIndex() + 1; j < products.size(); j++) {
                        if (products.get(j).getPrice() + pList.getTotalPrice() <= totalExpectedPrice) {
                            Set<Product> newProducts = new HashSet<>();
                            newProducts.addAll(pList.getProductList());
                            newProducts.add(products.get(j));
                            ProductList newList = new ProductList();
                            newList.setProductList(newProducts);
                            newList.setMaxIndex(j);
                            // System.out.println("Adding product: " +
                            // products.get(j).getName() + " to list: " +
                            // pList);
                            newList.setTotalPrice(products.get(j).getPrice() + pList.getTotalPrice());
                            newFinalList.add(newList);
                            addedNewItems = true;
                        }
                    }
                }
            }
            finalProductLists = newFinalList;
            newFinalList = new ArrayList<>();
        } while (addedNewItems);

        return finalProductLists;
    }
}