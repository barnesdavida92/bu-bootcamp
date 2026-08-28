#include <stdio.h>

void swap(int *a, int *b);
void broken_swap(int a, int b);

int main() {
    int a = 17;
    int b = 22;

    printf("Pre-Swap    => a: %d | b: %d", a, b);

    swap(&a, &b);

    printf("\nPost-Swap   => a: %d | b: %d", a, b);

    broken_swap(a, b);

    printf("\nBroken Swap => a: %d | b: %d", a, b);

    return 0;
}

void swap (int *a, int *b) {
    int temp = *a;

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