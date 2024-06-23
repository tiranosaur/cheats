package org.example.gof.behavior;

// позволяет добавлять новые операции к объектам без изменения этих объектов.
public class VisitorPattern {
    public static void main(String[] args) {
        Visitor areaVisitor = new AreaVisitor();
        Shape rectangle = new Rectangle();
        rectangle.accept(areaVisitor);
        Shape circle = new Circle();
        circle.accept(areaVisitor);
    }
}

interface Shape {
    void accept(Visitor visitor);
}

class Rectangle implements Shape {
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

class Circle implements Shape {
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

interface Visitor {
    void visit(Rectangle rectangle);
    void visit(Circle circle);
}

class AreaVisitor implements Visitor {
    public void visit(Rectangle rectangle) {
        System.out.println("Rectangle visit");
    }

    public void visit(Circle circle) {
        System.out.println("Circle visit");
    }
}