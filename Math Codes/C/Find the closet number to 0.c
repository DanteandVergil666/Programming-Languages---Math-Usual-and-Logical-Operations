#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <string.h>
#include <unistd.h>

// Calculation function to generate heavy load
double calculateValue(double value, int iteration) {
    // Performs a heavy operation (multiplication, exponentiation, and addition)
    value *= sin(iteration) + cos(iteration);
    value += pow(iteration, 2) / 3.14159;
    return value;
}

// Function to check if the value is very small (approaching zero)
int isUnderflow(double value) {
    return (value == 0.0 || fabs(value) < 1e-300);  // Lower threshold for underflow
}

// Function to print the number in scientific notation
void printInWords(double value) {
    if (isUnderflow(value)) {
        printf("Result: Approximately zero\n");
    } else {
        printf("Result: %.16e\n", value);
    }
}

int main() {
    char time_input[6];
    int max_operations;
    double value = 1.0;  // Initial value for the calculation
    int operations = 0;
    int elapsed_time_seconds = 0;

    // Prompt the user for execution time
    printf("Enter the time for the process (2:00, 5:00, 10:00, 20:00, 30:00, 1:00): ");
    scanf("%s", time_input);

    // Set the maximum time based on user input
    if (strcmp(time_input, "2:00") == 0) {
        elapsed_time_seconds = 120;
    } else if (strcmp(time_input, "5:00") == 0) {
        elapsed_time_seconds = 300;
    } else if (strcmp(time_input, "10:00") == 0) {
        elapsed_time_seconds = 600;
    } else if (strcmp(time_input, "20:00") == 0) {
        elapsed_time_seconds = 1200;
    } else if (strcmp(time_input, "30:00") == 0) {
        elapsed_time_seconds = 1800;
    } else if (strcmp(time_input, "1:00") == 0) {
        elapsed_time_seconds = 3600;
    } else {
        printf("Invalid time input.\n");
        return 1;
    }

    // Set the number of operations to perform per second (millions)
    max_operations = elapsed_time_seconds * 100000000;  // Perform billions of operations in the given time

    printf("Starting the process for %s...\n", time_input);
    printf("Executing operations for %d seconds...\n", elapsed_time_seconds);

    // Execution loop (heavy operations)
    for (operations = 1; operations <= max_operations; operations++) {
        value = calculateValue(value, operations);

        // Log progress every 100000 operations
        if (operations % 100000 == 0) {
            // Uncomment the line below to show progress if needed (it might slow things down slightly)
            // printf("Executing operation %d...\n", operations);
        }

        // Check if the value has reached a very small number
        if (isUnderflow(value)) {
            printf("Warning: Value has reached a very small number, approaching zero.\n");
            break;
        }
    }

    // Display the result
    printf("Total operations executed: %d\n", operations);
    printf("Closest result to zero found:\n");
    printInWords(value);

    return 0;
}
