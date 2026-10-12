import java.util.Scanner;

public class FloatingPointLoop {

    private static final int VALUE_COUNT = 5;
    private static final int MAX_INVALID_ATTEMPTS = 3;
    private static final double INTEREST_RATE = 0.20;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        double total = 0.0;
        double maximum = 0.0;
        double minimum = 0.0;
        int count = 0;
        int invalidAttempts = 0;

        System.out.println("=== Floating-Point Value Calculator ===");
        System.out.println("Enter " + VALUE_COUNT + " floating-point values.");

        while (count < VALUE_COUNT && invalidAttempts < MAX_INVALID_ATTEMPTS) {
            System.out.print("Enter value " + (count + 1) + ": ");

            if (input.hasNextDouble()) {
                double value = input.nextDouble();
                total += value;

                if (count == 0 || value > maximum) {
                    maximum = value;
                }
                if (count == 0 || value < minimum) {
                    minimum = value;
                }

                count++;
                invalidAttempts = 0;
            } else {
                input.next();
                invalidAttempts++;
                System.out.println("  Invalid entry. Please enter a number. ("
                        + (MAX_INVALID_ATTEMPTS - invalidAttempts) + " attempts left)");
            }
        }

        System.out.println();

        if (count < VALUE_COUNT) {
            System.out.println("Too many invalid entries. Loop stopped after "
                    + count + " valid value(s).");
        }

        if (count == 0) {
            System.out.println("No values were entered, so there is nothing to calculate.");
        } else {
            double average = total / count;
            double interest = total * INTEREST_RATE;

            System.out.println("=== Results ===");
            System.out.printf("Values entered:          %d%n", count);
            System.out.printf("Total:                   %,.2f%n", total);
            System.out.printf("Average:                 %,.2f%n", average);
            System.out.printf("Maximum:                 %,.2f%n", maximum);
            System.out.printf("Minimum:                 %,.2f%n", minimum);
            System.out.printf("Interest on total (20%%): %,.2f%n", interest);
        }

        input.close();
    }
}