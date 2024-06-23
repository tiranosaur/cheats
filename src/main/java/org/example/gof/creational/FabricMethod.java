package org.example.gof.creational;

import org.example.model.FirstProduct;
import org.example.model.Machine;
import org.example.model.SecondProduct;

// Фабричный метод редоставляет способ делегирования логики создания экземпляра дочерним классам.
public class FabricMethod {
    public static void main(String[] args) {
        Creator creator1 = new FirstProductCreator();
        Machine firstMachine = creator1.createProduct();
        firstMachine.printName();
    }
}

interface Creator {
    Machine createProduct();
}

class FirstProductCreator implements Creator {
    public FirstProduct createProduct() {
        return new FirstProduct();
    }
}

class SecondProductCreator implements Creator {
    public SecondProduct createProduct() {
        return new SecondProduct();
    }
}