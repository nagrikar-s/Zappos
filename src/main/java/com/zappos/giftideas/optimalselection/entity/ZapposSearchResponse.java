package com.zappos.giftideas.optimalselection.entity;

import java.util.List;

public class ZapposSearchResponse {
    private int statusCode;
    private List<ZapposSearchResult> results;
    private long currentResultCount;
    private long totalResultCount;

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public List<ZapposSearchResult> getResults() {
        return results;
    }

    public void setResults(List<ZapposSearchResult> results) {
        this.results = results;
    }

    public long getCurrentResultCount() {
        return currentResultCount;
    }

    public void setCurrentResultCount(long currentResultCount) {
        this.currentResultCount = currentResultCount;
    }

    public long getTotalResultCount() {
        return totalResultCount;
    }

    public void setTotalResultCount(long totalResultCount) {
        this.totalResultCount = totalResultCount;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (currentResultCount ^ (currentResultCount >>> 32));
        result = prime * result + ((results == null) ? 0 : results.hashCode());
        result = prime * result + statusCode;
        result = prime * result + (int) (totalResultCount ^ (totalResultCount >>> 32));
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
        ZapposSearchResponse other = (ZapposSearchResponse) obj;
        if (currentResultCount != other.currentResultCount)
            return false;
        if (results == null) {
            if (other.results != null)
                return false;
        } else if (!results.equals(other.results))
            return false;
        if (statusCode != other.statusCode)
            return false;
        if (totalResultCount != other.totalResultCount)
            return false;
        return true;
    }
}