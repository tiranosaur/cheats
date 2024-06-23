package org.example.gof.structural;

import org.example.model.FirstProduct;
import org.example.model.Product;
import org.example.model.SecondProduct;

import java.util.ArrayList;
import java.util.List;

//Шаблон компоновщик позволяет клиентам работать с индивидуальными объектами в едином стиле.
public class CompositePattern {
    public static void main(String[] args) {
        Product product1 = new FirstProduct("first product");
        Product product2 = new SecondProduct("second product");

        Composite composite = new Composite();
        composite.add(product1);
        composite.add(product2);
        composite.print();
    }
}

class Composite {
    private final List<Product> productList= new ArrayList<>();

    public void add(Product product) {
        productList.add(product);
    }

    public void print() {
        for (Product product : productList) {
            product.printName();
        }
    }
}
