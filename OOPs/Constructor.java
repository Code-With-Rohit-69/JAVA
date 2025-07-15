public class Constructor {
    public static void main(String[] args) {
        Student s1 = new Student("Rohit Singh", 20);

        System.out.println(s1.getName());
        System.out.println(s1.getAge());
    }
}

class Student {
    String name;
    int age;

    Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    String getName() {
        return this.name;
    }

    int getAge() {
        return this.age;
    }
}
