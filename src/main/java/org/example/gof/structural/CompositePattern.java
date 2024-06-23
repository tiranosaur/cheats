package org.example.gof.structural;

import org.example.model.FirstProduct;
import org.example.model.Machine;
import org.example.model.SecondProduct;

import java.util.ArrayList;
import java.util.List;

//Шаблон компоновщик позволяет клиентам работать с индивидуальными объектами в едином стиле.
public class CompositePattern {
    public static void main(String[] args) {
        Machine machine1 = new FirstProduct("first product");
        Machine machine2 = new SecondProduct("second product");

        Composite composite = new Composite();
        composite.add(machine1);
        composite.add(machine2);
        composite.print();
    }
}

class Composite {
    private final List<Machine> machineList = new ArrayList<>();

    public void add(Machine machine) {
        machineList.add(machine);
    }

    public void print() {
        for (Machine machine : machineList) {
            machine.printName();
        }
    }
}
