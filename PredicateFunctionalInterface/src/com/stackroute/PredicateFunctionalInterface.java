package com.stackroute;

import java.util.ArrayList;
import java.util.List;


public class PredicateFunctionalInterface {


    private static List<String> findPattern(List<String> list) {
        List<String> sortStart = new ArrayList<String>();
        List<String> dupliRem = new ArrayList<String>();
        /*Removing duplicate from list*/
        for (String element : list) {
            if (!dupliRem.contains(element)) {
                dupliRem.add(element);
            }
        }
        /*Selecting String starts with "I"*/
        for (int i = 0; i < dupliRem.size(); i++) {
            if (dupliRem.get(i).startsWith("I")) {
                sortStart.add(dupliRem.get(i));
            }

        }

        return sortStart;
    }

    @FunctionalInterface
    interface predicateFunctional {
        List<String> findPattern(List<String> list);
    }


    public static void main(String[] args) {
	    List<String> list = new ArrayList<String>();
	    list.add("Icecream");
        list.add("Water");
        list.add("Ice");
        list.add("Gas");
        list.add("Ice");
        list.add("Java");
/*Functional Interface*/
        predicateFunctional pred =  PredicateFunctionalInterface::findPattern;
        System.out.println(pred.findPattern(list));
    }

}
