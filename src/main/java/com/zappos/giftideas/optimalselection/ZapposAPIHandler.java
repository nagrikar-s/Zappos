package com.zappos.giftideas.optimalselection;

import java.util.List;

import com.zappos.giftideas.optimalselection.entity.Product;

/**
 * Interface to define API calls to be made to zappos.
 * 
 */
public interface ZapposAPIHandler {

    public List<Product> search(double price, int pageNumber) throws Exception;
}