#include <stdio.h>

void print_math(int a, int b);

int main() {
    int a;
    int b;

    printf("Number 1: ");
    scanf("%d", &a);

    printf("Number 2: ");
    scanf("%d", &b);

    print_math(a, b);

    return 0;
}

void print_math(int a, int b) {
    printf("Sum: %d\n", a + b);
    printf("Product: %d", a * b);
}