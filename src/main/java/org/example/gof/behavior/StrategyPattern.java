package org.example.gof.behavior;

import lombok.*;

//Алгоритм стратегии может быть изменен во время выполнения программы.
// Позволяет переключаться между алгоритмами или стратегиями в зависимости от ситуации.
public class StrategyPattern {
    public static void main(String[] args) {
        Strategy strategy = new Strategy(new BubbleSort());
        strategy.sort();
        strategy.setSort(new InsertionSort());
        strategy.sort();
    }
}

interface Sort {
    default void sort() {
        System.out.println(this.getClass().getSimpleName() + " is sorting");
    }
}

class BubbleSort implements Sort {
}

class InsertionSort implements Sort {
}

@Data
class Strategy {
    Sort sort;

    Strategy(Sort sort) {
        this.sort = sort;
    }

    public void sort() {
        sort.sort();
    }
}