package geekbrains.Java;

public class Main {

    public static void main(String[] args) {
        Person[] persArray = new Person[5];
        persArray[0] = new Person("Сидоров Иван Сергеевич", "Директор", "sidorov@test.com", "78003252233",38000, 35);
        persArray[1] = new Person("Иванов Василий Сергеевич", "Инженер", "ivanov@test.com", "78003648590",28000, 46);
        persArray[2] = new Person("Петров Валерий Иванович", "Инженер", "petrov@test.com", "78003679854",28000, 51);
        persArray[3] = new Person("Васильев Прокофий Васильевич", "Кассир", "vasiliev@test.com", "78003659721",18000, 26);
        persArray[4] = new Person("Прокофьев Иван Валерьевич", "Электрик", "prokofiev@test.com", "78002379645",20000, 42);

        for (int i = 0; i < persArray.length; i++) {
            if(persArray[i].getAge() > 40){
                persArray[i].info();
            }
        }
    }
}
