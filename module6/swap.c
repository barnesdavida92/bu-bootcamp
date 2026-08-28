#include <stdio.h>

void swap(int *a, int *b);
void swap_double(double *a, double *b);
void swap_char(char *a, char *b);
void broken_swap(int a, int b);

int main() {
    int a = 17;
    int b = 22;
    double x = 12.2;
    double y = 4.5;
    char m = 45;
    char n = 254;

    printf("Pre-Swap    => a: %d | b: %d", a, b);

    swap(&a, &b);

    printf("\nPost-Swap   => a: %d | b: %d", a, b);

    broken_swap(a, b);

    printf("\nBroken Swap => a: %d | b: %d", a, b);

    printf("\nDouble Pre-Swap    => a: %f | b: %f", x, y);

    swap_double(&x, &y);

    printf("\nDouble Post-Swap   => a: %f | b: %f", x, y);

    printf("\nChar Pre-Swap    => a: %c | b: %c", m, n);

    swap_char(&m, &n);

    printf("\nChar Post-Swap   => a: %c | b: %c", m, n);

    return 0;
}

void swap (int *a, int *b) {
    int temp = *a;

    *a = *b;
    *b = temp;
}

void swap_double (double *a, double *b) {
    double temp = *a;

    *a = *b;
    *b = temp;
}

void swap_char (char *a, char *b) {
    char temp = *a;

    *a = *b;
    *b = temp;
}

// Value received
void broken_swap (int a, int b) {
    int temp = a;

    a = b;
    b = temp;

    // These variables are copies and scoped to this method because the pointer was not passed
}