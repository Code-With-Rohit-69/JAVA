public class Polymorphism {
    public static void main(String[] args) {
        // Calculate calc = new Calculate();

        // System.out.println(calc.sum(10, 15));
        // System.out.println(calc.sum(10, 15, 22));
        // System.out.println(calc.sum((float)5.5, (float)6.5));

        Deer d1 = new Deer();
        d1.eat(null);
    }
}

// Method Overriding

class Animal {
    void eat(String str) {
        System.out.println("Eats anything.");
    }
}

class Deer extends Animal {
    void eat(String str) {
        System.out.println("Eats Only Grass.");
    }
}

// Method Overrloading

class Calculate {
    int sum(int a, int b) {
        return a + b;
    }

    float sum(float a, float b) {
        return a + b;
    }

    int sum(int a, int b, int c) {
        return a + b + c;
    }
}
