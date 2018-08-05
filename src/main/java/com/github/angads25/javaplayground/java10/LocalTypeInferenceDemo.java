package com.github.angads25.javaplayground.java10;

import java.util.ArrayList;

public class LocalTypeInferenceDemo {
//    Var type not allowed for class variables
//    Var types are not allowed as return types
//    Var types are not allowed as function arguments

    public static void main(String[] args) {
        var arrayList = new ArrayList<Integer>();

        for (int i = 0; i < 10; i++) {
            arrayList.add(i);
        }

        for(Integer number : arrayList) {
            System.out.println(number);
        }
    }
}
