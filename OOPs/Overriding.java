public class Overriding {
    public static void main(String[] args) {
        Derived d1 = new Derived();
        d1.print();
    }
}

class Base {
    void print() {
        System.out.println("Base class called");
    }
}

class Derived extends Base {
    void print() {
        System.out.println("Derived class called");
    }
}