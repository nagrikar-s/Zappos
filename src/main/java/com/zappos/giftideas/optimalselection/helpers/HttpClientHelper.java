package com.zappos.giftideas.optimalselection.helpers;

import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class HttpClientHelper {

    /**
     * Create and return a closable HttpClient
     * @return
     */
    public static CloseableHttpClient getHttpClient() {

        return HttpClients.createDefault();
    }
}