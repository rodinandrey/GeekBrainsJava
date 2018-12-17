package geekbrains.Java;

public class Person {
    private String fio;
    private String post;
    private String email;
    private String phone;
    private int salary;
    private int age;

    public Person(String fio, String post, String email, String phone, int salary, int age){
        this.fio = fio;
        this.post = post;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }

    public int getAge(){
        return this.age;
    }

    public void info(){
        System.out.println("ФИО: " + this.fio);
        System.out.println("должность: " + this.post);
        System.out.println("email: " + this.email);
        System.out.println("телефон: " + this.phone);
        System.out.println("зарплата: " + this.salary);
        System.out.println("возраст: " + this.age);
        System.out.println("--------------------------");
    }
}
