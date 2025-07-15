public class Encapsulation {
    
    public static void main(String[] args) {
        Student s1 = new Student();

        s1.setName("Rohit Singh");
        s1.setAge(20);

        System.out.println(s1.age);
        System.out.println(s1.getAge());
        System.out.println(s1.getName());
    }
}

class Student {
    private String name;
    public int age;

    String getName() {
        return this.name;
    }

    int getAge() {
        return this.age;
    }
    
    void setName(String name) {
        this.name = name;
    }

    void setAge(int age) {
        this.age = age;
    }
}
