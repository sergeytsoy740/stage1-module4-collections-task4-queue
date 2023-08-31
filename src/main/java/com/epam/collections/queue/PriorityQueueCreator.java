package com.epam.collections.queue;

import java.util.*;

public class PriorityQueueCreator {
    public static void main(String[] args) {
        List<String> firstList = Arrays.asList(
                "Java", "PriorityQueue", "class");
        List<String> secondList = Arrays.asList(
                "It", "is", "different", "from", "standard", "queues", "where", "FIFO");
        System.out.println(new PriorityQueueCreator().createPriorityQueue(firstList, secondList) + " actual");

        String[] expected = new String[]{
                "where", "standard", "queues", "is", "from", "different", "class", "PriorityQueue", "Java", "It", "FIFO"};
        System.out.println(Arrays.toString(expected) + " expected");
    }

    public PriorityQueue<String> createPriorityQueue(List<String> firstList, List<String> secondList) {

        List<String> mergedList = new ArrayList<>();
        mergedList.addAll(firstList);
        mergedList.addAll(secondList);
        mergedList.sort(Collections.reverseOrder());

        PriorityQueue<String> pq = new PriorityQueue<>(Collections.reverseOrder());

        pq.addAll(mergedList);

        return pq;
    }
}
