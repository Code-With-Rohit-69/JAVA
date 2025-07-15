public class Polymorphism {

    public static void main(String[] args) {
        // Parent p1 = new Parent();

        // int sum1 = p1.sum(10, 20);
        // System.out.println(sum1);
        // int sum2 = p1.sum(10, 0, 0);
        // System.out.println(sum2);

        Animal a = new Animal();
        a.eat();

        Deer d1 = new Deer();
        d1.eat();
    }
}

// Method Overriding

class Animal {
    void eat() {
        System.out.println("Animals eats");
    }
}

class Deer extends Animal {
    void eat() {
        System.out.println("Dear Eats only grass.");
    }
}


//Method OverLoading

class Parent {

    int sum(int a, int b) {
        return a + b;
    }

    int sum(int a, int b, int c) {
        return a + b + c;
    }

    float sum(float a, float b) {
        return a + b;
    }
}