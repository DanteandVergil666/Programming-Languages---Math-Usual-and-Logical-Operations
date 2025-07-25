import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> phrases = new ArrayList<>();

        System.out.print("Do you wish to raffle a phrase? (yes/no): ");
        String answer = scanner.nextLine().trim().toLowerCase();

        if (answer.equals("yes")) {
            System.out.println("Please enter 3 phrases:");
            for (int i = 1; i <= 3; i++) {
                System.out.print("Phrase " + i + ": ");
                phrases.add(scanner.nextLine());
            }

            Random random = new Random();
            String chosenPhrase = phrases.get(random.nextInt(phrases.size()));
            System.out.println("Your random phrase is: " + chosenPhrase);
        } else {
            System.out.println("No phrase will be raffled. Goodbye!");
        }

        scanner.close();
    }
}
