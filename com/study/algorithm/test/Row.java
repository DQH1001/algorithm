package com.study.algorithm.test;

import java.util.*;


public class Row {

    private String type;
    private String number;

    public void setType(String type) {
        this.type = type;
    }

    public void setNumber(String number) {
        this.number = number;
    }


    public String getNumber() {
        return number;
    }

    public String getType() {
        return type;
    }

    public Map<String, List<Row>> groupByType(List<Row> rows) {
        Map<String, List<Row>> data = new HashMap<>();
        if (rows == null || rows.size() == 0) {
            return data;
        }

        for (Row row : rows) {
            String type = row.getType();
            List<Row> rowList = data.get(type);
            if (rowList == null) {
                rowList = new ArrayList<>();
            }
            rowList.add(row);
            data.put(type, rowList);
        }

        for (List<Row> rowList : data.values()) {
            Collections.sort(rowList, (o1, o2) -> o1.getNumber().compareTo(o2.getNumber()));
        }
        return data;
    }

    public static void main(String[] args) {
        String str = "asdfgh jkl lkj nb";
        if (str == null || str == "") {
            System.out.println("");
        }
        String strArr[] = str.split(" ");
        StringBuffer sb = new StringBuffer("");
        for(int j = 0; j < strArr.length; j++) {
            char[] charArr = strArr[j].toCharArray();
            for(int i = charArr.length - 1; i >= 0; i--) {
                sb.append(charArr[i]);
            }
            sb.append(" ");
        }
        System.out.println(sb.toString().trim());
    }
}


