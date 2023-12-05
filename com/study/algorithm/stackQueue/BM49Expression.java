package com.study.algorithm.stackQueue;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 请写一个整数计算器，支持加减乘三种运算和括号。
 * <p>
 * 数据范围：0≤∣s∣≤100，保证计算结果始终在整型范围内
 * <p>
 * 要求：空间复杂度：O(n)，时间复杂度：O(n)
 */
public class BM49Expression {
    public int solve(String s) {
        List<Integer> res = getEvaluatingExpressions(s, 0);
        return res.get(0);
    }

    private static List<Integer> getEvaluatingExpressions(String s, int index) {
        Stack<Integer> nums = new Stack<>();
        int num = 0;
        char op = '+';
        int i;
        for (i = index; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                num = num * 10 + c - '0';
                if (i != s.length() - 1) {
                    continue;
                }
            }
            if (c == '(') {
                List<Integer> sonVal = getEvaluatingExpressions(s, i + 1);
                num = sonVal.get(0);
                i = sonVal.get(1);
                if (i != s.length() - 1) {
                    continue;
                }
            }

            switch (op) {
                case '+':
                    nums.push(num);
                    break;
                case '-':
                    nums.push(-num);
                    break;
                case '*':
                    nums.push(nums.pop() * num);
                    break;
            }
            num = 0;
            op = c;

            if (c == ')') {
                break;
            }
        }

        // 递归结束需返回stack中的和，以及当前的索引
        List<Integer> resultList = new ArrayList<>();
        int sum = 0;
        while (!nums.isEmpty()) {
            sum += nums.pop();
        }
        resultList.add(sum);
        resultList.add(i);
        return resultList;
    }

    public static void main(String[] args) {
        BM49Expression b = new BM49Expression();
        System.out.println(b.solve("1+2+3*(2+3-4*(2+3)+1)"));
    }
}
