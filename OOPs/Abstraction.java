public class Abstraction {
    public static void main(String[] args) {
        Mustang myHorse = new Mustang();
    }
}

abstract class Animal {
    String color;

    Animal() {
        System.out.println("Animal constructor called.");
    }
}

class Horse extends Animal {
    Horse() {
        System.out.println("Horse constructor called.");
    }
}

class Mustang extends Horse {
    Mustang() {
        System.out.println("Mustang Constructor called.");
    }
}