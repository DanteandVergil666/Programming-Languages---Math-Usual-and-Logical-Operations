import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Person {
    private String name;
    private List<String> fruits = new ArrayList<>();

    public void setName(String name) {
        this.name = name;
    }

    public void addFruit(String fruit) {
        if (fruits.size() < 3) {
            fruits.add(fruit);
        }
    }

    public String getName() {
        return name;
    }

    public List<String> getFruits() {
        return fruits;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Person> people = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            System.out.print("Type your name: ");
            Person person = new Person();
            person.setName(scanner.nextLine());

            System.out.println("\nWhat's your favorite foods: ");
            for (int j = 0; j < 3; j++) {
                person.addFruit(scanner.nextLine());
            }

            System.out.println("\nInformation captation finished\n");
            people.add(person);
        }

        System.out.print("Identify yourself: ");
        String inputName = scanner.nextLine();

        boolean found = false;
        for (Person p : people) {
            if (p.getName().equalsIgnoreCase(inputName)) {
                System.out.println("\n" + p.getName() + ", your favorite foods are: " + String.join(", ", p.getFruits()) + "\n");
                System.out.println("\nProgram ended\n");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("\nInvalid person");
            System.out.println("Program ended\n");
        }
    }
}
