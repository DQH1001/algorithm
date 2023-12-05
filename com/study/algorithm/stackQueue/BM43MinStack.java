package com.study.algorithm.stackQueue;

import java.util.Stack;

/**
 * 描述
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的 min 函数，输入操作时保证 pop、top 和 min 函数操作时，栈中一定有元素。
 *
 * 此栈包含的方法有：
 * push(value):将value压入栈中
 * pop():弹出栈顶元素
 * top():获取栈顶元素
 * min():获取栈中最小元素
 */
public class BM43MinStack {
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> min = new Stack<>();
    public void push(int node) {
        stack.push(node);
        if (min.isEmpty() || node <= min.peek()) {
            min.push(node);
        } else {
            min.push(min.peek());
        }
    }

    public void pop() {
        stack.pop();
        min.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return min.peek();
    }
}
