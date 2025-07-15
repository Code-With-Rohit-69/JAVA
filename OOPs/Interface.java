public class Interface {
    public static void main(String[] args) {
        Bear b1 = new Bear();

        b1.eat();
    }
}

interface Herbivores {
    void eat();
}

interface Carnivores {
    void eat();
}

class Bear implements Herbivores, Carnivores {
    public void eat() {
        System.out.println("Eats Both");
    }
}

// class Herbivores implements Animal {
// public void eat() {
// System.out.println("Eats only grass.");
// }
// }

// class Carnivores implements Animal {
// public void eat() {
// System.out.println("Eats only Meat.");
// }
// }