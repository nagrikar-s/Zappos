package com.zappos.giftideas.optimalselection.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;

import com.google.gson.Gson;
import com.zappos.giftideas.optimalselection.ZapposAPIHandler;
import com.zappos.giftideas.optimalselection.entity.Product;
import com.zappos.giftideas.optimalselection.entity.ZapposSearchResponse;
import com.zappos.giftideas.optimalselection.entity.ZapposSearchResult;
import com.zappos.giftideas.optimalselection.helpers.Constant.PriceTypeFacet;
import com.zappos.giftideas.optimalselection.helpers.HttpClientHelper;

public class ZapposAPIHandlerImpl implements ZapposAPIHandler {
    private static final Gson GSON = new Gson();
    private static final String ZAPPOS_BASE_URL = "http://api.zappos.com";
    private static final String API_KEY = "b05dcd698e5ca2eab4a0cd1eee4117e7db2a10c4";
    private static final String KEY_PARAM = "&key=" + API_KEY;
    private static final String SEARCH_QUERY_PREFIX = "/Search?term=&limit=100&sort={\"recentSales\":\"desc\"}&filters={\"priceFacet\":[\"";
    private static final String SEARCH_QUERY_SUFFIX = "\"]}" + KEY_PARAM + "&page=";
    private static final CloseableHttpClient HTTP_CLIENT = HttpClientHelper.getHttpClient();

    public List<Product> search(double price, int pageNumber) throws Exception {
        String searchUrl = ZAPPOS_BASE_URL + SEARCH_QUERY_PREFIX + getPriceTypeFacet(price).getName() + SEARCH_QUERY_SUFFIX + pageNumber;
        System.out.println("Requesting: " + searchUrl + " for page: " + pageNumber);
        List<Product> products = new ArrayList<>();
        HttpGet httpGet = new HttpGet(searchUrl);
        CloseableHttpResponse response = HTTP_CLIENT.execute(httpGet);
        try {
            System.out.println(response.getStatusLine());
            HttpEntity entity = response.getEntity();
            ZapposSearchResponse searchResponse = GSON.fromJson(IOUtils.toString(entity.getContent()), ZapposSearchResponse.class);
            products.addAll(getProductFromResponse(searchResponse));
            // do something useful with the response body
            // and ensure it is fully consumed
            EntityUtils.consume(entity);
        } finally {
            response.close();
        }
        return products;
    }

    private PriceTypeFacet getPriceTypeFacet(double price) {
        if (price <= 50)
            return PriceTypeFacet.UNDER_50;
        else if (price <= 100)
            return PriceTypeFacet.UNDER_100;
        else if (price <= 200)
            return PriceTypeFacet.UNDER_200;
        else
            return PriceTypeFacet.ABOVE_200;
    }

    private List<Product> getProductFromResponse(ZapposSearchResponse response) {
        List<Product> products = new ArrayList<>();
        for (ZapposSearchResult result : response.getResults()) {
            Product product = new Product(result.getProductName(), result.getProductId(), getPriceInDouble(result.getPrice()));
            products.add(product);
        }
        return products;
    }

    private double getPriceInDouble(String price) {
        // remove all $ and ,
        price = price.replaceAll("$", "");
        price = price.replaceAll(",", "");
        return Double.valueOf(price);
    }
}