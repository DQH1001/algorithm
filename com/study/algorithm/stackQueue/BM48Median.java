package com.study.algorithm.stackQueue;

import java.util.PriorityQueue;

public class BM48Median {
    // 小顶堆，元素值比大顶堆大，小的在前
    PriorityQueue<Integer> max = new PriorityQueue<>();

    // 大顶堆，元素值比小顶堆小，大的在前
    PriorityQueue<Integer> min = new PriorityQueue<>((o1, o2) -> o2.compareTo(o1));

    public void Insert(Integer num) {
        min.offer(num);
        max.offer(min.poll());
        if (min.size() < max.size()) {
            min.offer(max.poll());
        }
    }

    public Double GetMedian() {
        if (min.size() > max.size()) {
            return (double) min.peek();
        } else if (min.size() < max.size()) {
            return (double) max.peek();
        } else {
            return (double) (min.peek() + max.peek()) / 2;
        }
    }

    public static void main(String[] args) {
        BM48Median b = new BM48Median();
        b.Insert(1);
        System.out.println(b.GetMedian());
        b.Insert(3);
        System.out.println(b.GetMedian());
        b.Insert(2);
        System.out.println(b.GetMedian());
        b.Insert(3);
        System.out.println(b.GetMedian());
    }
}
