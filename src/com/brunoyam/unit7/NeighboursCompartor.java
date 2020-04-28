package com.brunoyam.unit7;

import java.util.Comparator;

/**
 * Компаратор для объектов {@link com.brunoyam.unit7.Neighbour neighbour}. Используется для сортировки.
 */
public class NeighboursCompartor implements Comparator<Neighbour> {

    /**
     * Сравнивает два объекта {@link com.brunoyam.unit7.Neighbour neighbour} объект с предложенным.
     * @param neighbour первый объект для сравнения.
     * @param t1 второй объект для сравнения.
     * @return положительное число, если первый объект больше, отрицательно число, если первый объект меньше, ноль,
     * если объекты равны.
     */
    @Override
    public int compare(Neighbour neighbour, Neighbour t1) {
        return neighbour.getAge() - t1.getAge();
    }
}
