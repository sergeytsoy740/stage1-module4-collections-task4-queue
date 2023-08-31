package com.epam.collections.queue;

import java.util.LinkedList;
import java.util.List;

public class DishOrderDeterminer {
    public static void main(String[] args) {
        int numsOfDishers = 11;
        int every = 4;
        DishOrderDeterminer dishOrderDeterminer = new DishOrderDeterminer();
        List<Integer> eatenDishes = dishOrderDeterminer.determineDishOrder(numsOfDishers, every);
        System.out.println(eatenDishes + " eaten");
    }


    public List<Integer> determineDishOrder(int numberOfDishes, int everyDishNumberToEat) {
        int step = everyDishNumberToEat;
        if (numberOfDishes == 0) return new LinkedList<>();

        List<Integer> menu = new LinkedList<>();
        for (int i = 1; i <= numberOfDishes; i++) {
            menu.add(i);
        }
        System.out.println(menu + " menu");

        List<Integer> eaten = new LinkedList<>();

        int j = -1;

        while (true) {
            j += everyDishNumberToEat;
            if (menu.size() == 1) {
                eaten.add(menu.get(0));
            }
            else eaten.add(menu.get(j));
            System.out.println(eaten + " eaten " + eaten.size());
            if (eaten.size() == numberOfDishes) {
                break;
            }

            int remainders = menu.size() - j - 1;

            everyDishNumberToEat = step;
            if (remainders < everyDishNumberToEat) {
                j = -1;
                for (int i = 0; i < remainders; i++) {
                    menu.add(0, menu.remove(menu.size() - 1));
                }
                menu.removeAll(eaten);
            }

            if (menu.size() < everyDishNumberToEat) {
                everyDishNumberToEat = everyDishNumberToEat - menu.size();
            }
        }
        return eaten;
    }
}
//[4, 8, 1, 6, 11, 7, 3, 2, 9, 5] actual
//[4, 8, 1, 6, 11, 7, 3, 2, 5, 10, 9] expected

