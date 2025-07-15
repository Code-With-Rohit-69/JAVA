public class Inheritance {
    public static void main(String[] args) {
        Cat cat = new Cat();
        cat.color = "White";
        cat.legs = 4;

        cat.getLegs();
        cat.breathe();
        System.out.println(cat.color);
    }
}

class Animal {
    String color;

    void eat() {
        System.out.println("Can Eat");
    }

    void breathe() {
        System.out.println("Can Breathe");
    }
}

class Mammal extends Animal {
    int legs;

    void getLegs() {
        System.out.println(this.legs + " legs");
    }
}

class Cat extends Mammal {
    String breed;
}

// class Fish extends Animal {
//     void swim() {
//         System.out.println("Can swim in water.");
//     }
// }