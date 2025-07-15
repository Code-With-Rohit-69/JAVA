public class Inheritance {
    
    public static void main(String[] args) {
        Derived d1 = new Derived();

        d1.print();
    }
}

// Single inheritance

class Base {
    int data;

    void print() {
        System.out.println("Base class.");
    }
}

class Derived extends Base {
    int data;

    void print() {
        System.out.println("Derived class.");
    }
}

// Multi-level Inheritance

class Base1 {
    
}