package com.stackroute;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

public class CartCheckout {

    /*Method to calculate Tax*/
    private static String billGenerator(Map<String, BigDecimal> map, Double val) {
        String out = null;
        if (map.isEmpty()) {
            out = "Map Empty!";
        } else if (val < 0) {
            out = "The taxPercent cannot be Negative!";
        } else if (val == null) {
            out = "The taxPercent cannot be null";
        } else {

            Double sum = map.values().stream().mapToDouble(BigDecimal::doubleValue).sum();
            Double tax = ((val * sum) / 100) + sum;
            DecimalFormat dec = new DecimalFormat("#.0000");
            out = String.valueOf(dec.format(tax));

        }
        return out;
    }

    /*Functional Interface*/
    @FunctionalInterface
    interface predicateFunctional {
        String billGenerator(Map<String, BigDecimal> map, Double val);
    }

    /*Main Method to implement*/
    public static void main(String[] args) throws Exception {

        Map<String, BigDecimal> map = new HashMap<>();
        BigDecimal bd1 = new BigDecimal("54");
        BigDecimal bd2 = new BigDecimal("36.78");
        BigDecimal bd3 = new BigDecimal("27.89");
        BigDecimal bd4 = new BigDecimal("23.6");
        BigDecimal bd5 = new BigDecimal("10.2");

        map.put("Apple", bd1);
        map.put("Grapes", bd2);
        map.put("Papaya", bd3);
        map.put("Orange", bd4);
        map.put("Banana", bd5);
        try {
            predicateFunctional pred = CartCheckout::billGenerator;
            System.out.println(pred.billGenerator(map, 10.00));


        } catch (NullPointerException e) {
            System.out.println("The taxPercent cannot be null!");
        }
    }


}
