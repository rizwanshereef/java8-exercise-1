package com.stackroute;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class AlphabetChecker {
    /*Class to check if the list contain only String or not*/
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the list enclosed within []");
        String input = scan.next();
        if (!input.equals("[]")) {
            /*Extract string from input*/
            String inputTrim = input.substring(input.indexOf("[") + 1, input.indexOf("]"));

            /*Convert input to list*/
            List<String> list = new ArrayList<String>(Arrays.asList(inputTrim.split(",")));
            String out = checkAlphabets(list);
            System.out.println(out);
        } else
            System.out.println("Give Proper Input not empty list");
    }

    /*Method to check if input contains only alphabet or not using lambda expression*/
    public static String checkAlphabets(List<String> list) {
        String out = null;
        if (list.isEmpty()) {
            out = "Give Proper Input not empty list";
        } else {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).equals("") && list.get(i).chars().allMatch(Character::isLetter)) {
                    out = "Given list contains only alphabet strings";
                    break;
                } else
                    out = "Given list contains non alphabet strings";
            }
        }
        return out;
    }
}
