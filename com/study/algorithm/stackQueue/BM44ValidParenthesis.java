package com.study.algorithm.stackQueue;

import java.util.Stack;

/**
 * 给出一个仅包含字符'(',')','{','}','['和']',的字符串，判断给出的字符串是否是合法的括号序列
 * 括号必须以正确的顺序关闭，"()"和"()[]{}"都是合法的括号序列，但"(]"和"([)]"不合法。
 * <p>
 * <p>
 * 数据范围：字符串长度 0≤n≤10000
 * 要求：空间复杂度 O(n)，时间复杂度 O(n)
 */
public class BM44ValidParenthesis {
    Stack<Character> data = new Stack<>();

    public boolean isValid(String s) {
        char[] charArray = s.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if (isLeft(charArray[i])) {
                data.push(charArray[i]);
            } else {
                if (data.isEmpty()) {
                    return false;
                }
                if (!data.pop().equals(getLeft(charArray[i]))) {
                    return false;
                }
            }
        }
        if (!data.isEmpty()) {
            return false;
        } else {
            return true;
        }
    }

    public boolean isLeft(Character character) {
        if (character.equals('{') || character.equals('[') || character.equals('(')) {
            return true;
        }
        return false;
    }

    public Character getLeft(Character character) {
        if (character.equals('}')) {
            return '{';
        } else if (character.equals(']')) {
            return '[';
        } else {
            // character.equals(')')
            return '(';
        }
    }
}
