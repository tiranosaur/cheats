package org.example.gof.structural;

import lombok.*;
import org.example.model.Machine;
import org.example.model.ThirdProduct;

//Фасад предоставляет упрощенный интерфейс для сложной системы. Несколько действий над объектом в одном методе
public class Facade {
    public static void main(String[] args) {
        ProductFacade facade = new ProductFacade(new ThirdProduct("third product"));
        facade.turnOn();
        facade.turnOff();
    }
}

@AllArgsConstructor
class ProductFacade {
    private Machine machine;

    public void turnOn() {
        machine.printName();
        machine.startProcess();
    }

    public void turnOff() {
        machine.printClassName();
        machine.endProcess();
    }
}