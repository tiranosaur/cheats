package org.example.gof.structural;

import org.example.model.Product;
import org.example.model.SecondProduct;

// Шаблон позволяет обернуть несовместимые объекты в адаптер, чтобы сделать их совместимыми с другим классом
/*
Adapter (Адаптер) - применяется при необходимости использовать классы вместе с несвязанными интерфейсами.
Поведение адаптируемого класса при этом изменяется на необходимое (interface to an object);
 */
public class Adapter {
    public static void main(String[] args) {
        LionInterface lion = new Lion();
        lion.roar();

        LionInterface dog = new DogAdapter(new Dog());
        dog.roar();
    }
}

interface LionInterface {
    void roar();
}

class Lion implements LionInterface {
    public void roar() {
        System.out.println("Lion roar");
    }
}

class Dog {
    public void bark() {
        System.out.println("Dog bark");
    }
}

class DogAdapter implements LionInterface {
    private final Dog dog;

    public DogAdapter(Dog dog) {
        this.dog = dog;
    }

    @Override
    public void roar() {
        dog.bark();
    }
}