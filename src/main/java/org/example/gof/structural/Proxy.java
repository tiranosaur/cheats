package org.example.gof.structural;

import lombok.AllArgsConstructor;

// Используя шаблон заместитель, класс отображает функциональность другого класса.
public class Proxy {
    public static void main(String[] args) {
        Machine machine = new Machine();
        MachineProxy proxy = new MachineProxy(machine);
        proxy.printName();
    }
}

class Machine {
    public void printName() {
    }

    public void scream() {
    }
}

@AllArgsConstructor
class MachineProxy extends Machine {
    private final Machine machine;

    @Override
    public void printName() {
        machine.printName();
    }

    @Override
    public void scream() {
        machine.scream();
    }
}