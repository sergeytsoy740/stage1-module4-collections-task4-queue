package com.epam.collections.queue;


import java.util.*;


public class ArrayDequeCreator extends PriorityQueue<String> {
    public static void main(String[] args) {
        Queue<Integer> firstQueue = new LinkedList<>(List.of(new Integer[]{1, 5, 7, 6}));
        Queue<Integer> secondQueue = new LinkedList<>(List.of(new Integer[]{2, 5, 8, 3}));
        ArrayDeque<Integer> expected = new ArrayDeque<>(List.of(new Integer[]{1, 5, 2, 7, 8, 5, 6, 3}));

        ArrayDequeCreator arrayDequeCreator = new ArrayDequeCreator();
        ArrayDeque<Integer> ad = arrayDequeCreator.createArrayDeque(firstQueue, secondQueue);
        System.out.println(ad + " actual");

        System.out.println(expected + " expected");

    }

    public ArrayDeque<Integer> createArrayDeque(Queue<Integer> firstQueue, Queue<Integer> secondQueue) {
/*  firstQueue =    [1, 5, 7, 6]
    secondQueue =   [2, 5, 8, 3]
                    [1, 5, 2, 7, 8, 5, 6, 3]
*/

        ArrayDeque<Integer> actual = new ArrayDeque<>();
// First, both take turns adding two cards to the ArrayDeque<Integer>
        addTo(firstQueue, actual);
        addTo(firstQueue, actual);
        addTo(secondQueue, actual);
        addTo(secondQueue, actual);

// Then, with each move, the player:
        while (!firstQueue.isEmpty() && !secondQueue.isEmpty()) {

// first player
// takes the top card from the ArrayDeque<Integer> and adds this card to the end of his Queue<Integer>
            firstQueue.add(actual.pollLast());
// then puts two cards from the beginning of his Queue<Integer> into the ArrayDeque<Integer>
            addTo(firstQueue, actual);
            addTo(firstQueue, actual);

// second player
// takes the top card from the ArrayDeque<Integer> and adds this card to the end of his Queue<Integer>
            secondQueue.add(actual.pollLast());
// then puts two cards from the beginning of his Queue<Integer> into the ArrayDeque<Integer>
            addTo(secondQueue, actual);
            addTo(secondQueue, actual);
        }
        return actual;

    }

    private void addTo(Queue<Integer> queue, ArrayDeque<Integer> arrayDeque) {
        if (!queue.isEmpty())
            arrayDeque.add(queue.poll());
    }

}




































