import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        char[] alphabet = {
            'a','b','c','d','e','f','g','h','i','j','k','l','m',
            'n','o','p','q','r','s','t','u','v','w','x','y','z'
        };
        
        char[] accentuated = {
            'á','à','â','ã','é','è','ê','í','ì','î','ó','ò','ô','õ','ú','ù','û','ç'
        };
        
        char[] numbers = {
            '0','1','2','3','4','5','6','7','8','9'
        };
        
        System.out.print("Type something: ");
        String entrada = sc.nextLine().toLowerCase();

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < entrada.length(); i++) {
            char caracter = entrada.charAt(i);

            if (caracter == ' ') {
                result.append(' ');
            } else if (contains(alphabet, caracter)) {
                result.append(caracter);
            } else if (contains(accentuated, caracter)) {
                result.append(caracter);
            } else if (contains(numbers, caracter)) {
                result.append(caracter);
            }
        }

        System.out.println("Phrase rebuilt: " + result.toString());
        sc.close();
    }

    public static boolean contains(char[] vector, char c) {
        for (char element : vector) {
            if (element == c) {
                return true;
            }
        }
        return false;
    }
}
