import hash.Hash;
import hash.InvalidKeyException;

public class HashTest {
    public static void main(String[] args) {
        System.out.println("====== strings ======");
        System.out.println("------ display all ------");
        Hash<String> strings = new Hash<>();
        strings.insert("one", "1");
        strings.insert("two", "2");
        strings.insert("hello", "world");
        strings.insert("hi", "wrld");
        strings.insert("Cthulhu", "Пх’нглуи мглв’нафх Ктулху Р’льех вгах’нагл фхтагн");
        strings.display();

        System.out.println();
        System.out.println("------ display Cthulhu item ------");
        try {
            System.out.println(strings.search("Cthulhu"));
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        }

        System.out.println();
        System.out.println("====== Users ======");

        Hash<User> users = new Hash<>();
        users.insert("Ivanov", new User("Ivan", "Ivanov", 21));
        users.insert("Petrov", new User("Petr", "Petrov", 34));
        users.insert("Sidorov", new User("Sidor", "Sidorov", 16));
        users.insert("Rumpel", new User("Rumpelstiltskin", "", -1));
        users.display();

        System.out.println("------ after removed 'Rumpel'------");

        try {
            users.delete("Rumpel");
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        }
        users.display();


    }
}

class User {
    public String name;
    public String surname;
    public int age;

    public User(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }
    public String toString() {
        return String.format("name: %s\nsurname: %s\nage: %d\n", name, surname, age);
    }
}
