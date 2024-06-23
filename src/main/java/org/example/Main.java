package org.example;


import lombok.AllArgsConstructor;
import lombok.Data;

public class Main {
    public static void main(String[] args) {
        ColoredCircle coloredCircle1 = new ColoredCircle(new Red());
        coloredCircle1.draw();
        ColoredCircle coloredCircle2 = new ColoredCircle(new Green());
        coloredCircle2.draw();
    }
}

interface Color {
    default String getColor() {
        return this.getClass().getSimpleName();
    }
}

class Red implements Color {
}

class Green implements Color {
}


@Data
abstract class ColoredShape {
    private String color;

    abstract void draw();
}

@AllArgsConstructor
class ColoredCircle extends ColoredShape {
    private Color color;

    @Override
    void draw() {
        System.out.println("This circle is " + color.getColor());
    }
}