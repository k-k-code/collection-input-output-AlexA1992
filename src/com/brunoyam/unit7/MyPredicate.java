package com.brunoyam.unit7;

import java.util.function.Predicate;

/**
 * Демонстрационный пример использования интерфейса {@link java.util.function.Predicate}
 */
public class MyPredicate implements Predicate<Neighbour> {
    /**
     * {@inheritDoc}
     * @param neighbour сосед для проверки.
     * @return <core>true</core> если сосед старше 21 года, в противном случае <code>false</code>
     */
    @Override
    public boolean test(Neighbour neighbour) {
        return neighbour.getAge() > 21;
    }
}
