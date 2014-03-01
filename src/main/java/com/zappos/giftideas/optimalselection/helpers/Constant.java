package com.zappos.giftideas.optimalselection.helpers;

public class Constant {

    private Constant() {
    }

    public static enum PriceTypeFacet {
        UNDER_50("$50.00 and Under"), UNDER_100("$100.00 and Under"), UNDER_200("$200.00 and Under"), ABOVE_200("$200.00 and Above");
        PriceTypeFacet(String name) {
            this.name = name;
        }

        private String name;

        public String getName() {
            return this.name;
        }
    }
}