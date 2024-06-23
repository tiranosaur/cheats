package org.example.gof.creational;

// Простая фабрика генерирует экземпляр для клиента, не раскрывая никакой логики.
public class SimpleFactory {
    public static void main(String[] args) {
        Type girl = Factory.getInstance(TypeEnum.GIRL);
        girl.introduce();

        Type sword = Factory.getInstance(TypeEnum.SWORD);
        sword.introduce();
    }
}

enum TypeEnum {
    SWORD,
    GIRL
}

interface Type {
    default void introduce() {
        System.out.println(this.getClass().getSimpleName());
    }
}

class Sword implements Type {
}

class Girl implements Type {
}

class Factory {
    public static Type getInstance(TypeEnum typeEnum) {
        switch (typeEnum) {
            case SWORD:
                return new Sword();
            case GIRL:
                return new Girl();
            default:
                throw new RuntimeException("Wrong type");
        }
    }
}