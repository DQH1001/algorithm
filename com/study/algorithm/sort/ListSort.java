package com.study.algorithm.sort;

import java.util.ArrayList;
import java.util.List;

public class ListSort {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.sort((o1,o2)->o2-o1);
        list.stream().forEach(o -> System.out.println(o));
    }
}
