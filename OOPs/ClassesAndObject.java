public class ClassesAndObject {
    public static void main(String[] args) {
        // Pen p1 = new Pen();

        Student s1 = new Student();

        s1.calculatePercent(80, 80, 90);
        s1.setName("Rohit Singh");
        s1.setAge(20);

        System.out.println(s1.percentage);
        System.out.println(s1.name);
        System.out.println(s1.age);

        // p1.setColor("Pink");
        // p1.setTip(2);

        // p1.color = "Black";
        // p1.tip = 3;

        // System.out.println(p1.color);
        // System.out.println(p1.tip);
    }
}

class Pen {
    String color;
    int tip;

    void setColor(String newColor) {
        color = newColor;
    }

    void setTip(int newTip) {
        tip = newTip;
    }
}

class Student {
    String name;
    int age;
    float percentage;

    void setName(String newName) {
        name = newName;
    }

    void setAge(int newAge) {
        age = newAge;
    }

    void calculatePercent(int phy, int chem, int math) {
        percentage = (phy + chem + math) / 3;
    }
}