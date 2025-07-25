import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nWelcome to the Variable Creator\n");

        System.out.print("Enter a variable name: \n");
        String varName = scanner.nextLine();

        System.out.println("\nChoose a variable type:\nbyte\nshort\nint\nlong\nfloat"
                + "\ndouble\nchar\nboolean\nString\n");
        String varType = scanner.nextLine().toLowerCase();

        String value = "";
        boolean valid = false;

        while (!valid) {
            switch (varType) {
                case "byte":
                    System.out.println("\nEnter a byte value (-128 to 127):\n");
                    value = scanner.nextLine();
                    valid = isValidByte(value);
                    if (!valid) System.out.println("Invalid byte. Try again.\n");
                    break;
                case "short":
                    System.out.println("\nEnter a short value (-32768 to 32767):\n");
                    value = scanner.nextLine();
                    valid = isValidShort(value);
                    if (!valid) System.out.println("Invalid short. Try again.\n");
                    break;
                case "int":
                    System.out.println("\nEnter an int value:\n");
                    value = scanner.nextLine();
                    valid = isValidInt(value);
                    if (!valid) System.out.println("Invalid int. Try again.\n");
                    break;
                case "long":
                    System.out.println("\nEnter a long value:\n");
                    value = scanner.nextLine();
                    valid = isValidLong(value);
                    if (!valid) System.out.println("Invalid long. Try again.\n");
                    break;
                case "float":
                    System.out.println("\nEnter a float value (e.g., 3.14):\n");
                    value = scanner.nextLine();
                    valid = isValidFloat(value);
                    if (!valid) System.out.println("Invalid float. Try again.\n");
                    break;
                case "double":
                    System.out.println("\nEnter a double value (e.g., 3.14159):\n");
                    value = scanner.nextLine();
                    valid = isValidDouble(value);
                    if (!valid) System.out.println("Invalid double. Try again.\n");
                    break;
                case "char":
                    System.out.println("\nEnter a single character:\n");
                    value = scanner.nextLine();
                    valid = value.length() == 1;
                    if (!valid) System.out.println("Invalid char. Must be one character.\n");
                    break;
                case "boolean":
                    System.out.println("\nEnter boolean value (true or false):\n");
                    value = scanner.nextLine().toLowerCase();
                    valid = value.equals("true") || value.equals("false");
                    if (!valid) System.out.println("Invalid boolean. Enter true or false.\n");
                    break;
                case "string":
                    System.out.println("\nEnter any string:\n");
                    value = scanner.nextLine();
                    valid = true;
                    break;
                default:
                    System.out.println("\nUnsupported type. Program terminated.\n");
                    return;
            }
        }

        System.out.printf("\nVariable successfully declared:\n\nName: %s\nType: %s\nValue: %s\n\n", varName, varType, value);
    }

    private static boolean isValidByte(String s) {
        try {
            byte b = Byte.parseByte(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static boolean isValidShort(String s) {
        try {
            short sh = Short.parseShort(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static boolean isValidInt(String s) {
        try {
            int i = Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static boolean isValidLong(String s) {
        try {
            long l = Long.parseLong(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static boolean isValidFloat(String s) {
        try {
            Float.parseFloat(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static boolean isValidDouble(String s) {
        try {
            Double.parseDouble(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
