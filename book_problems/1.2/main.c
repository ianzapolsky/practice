// main.c -- Book Problem 1.2

// description: Implement a function void reverse(char* str) in C which
// reverses a null-terminated string.
// author: Ian Zapolsky (10/07/13)

#include <stdio.h>
#include <stdlib.h>

void reverse(char* str) {
// My reverse method.
    
    int length = 0;
    char x = str[0];
    while (x)
        x = str[++length];
    if (length <= 1)
        return;
    // Determine length of string. If 1 or 0, return. 

    else {
        int up = 0;
        int down = length-1;
        while (up < down) {
            char temp = str[up];
            str[up] = str[down];
            str[down] = temp;
            up++;
            down--;
        }
    }
    printf("%s\n", str);

}

void reverseBook(char *str) {
// The book's reverse method.

    char* end = str;
    char tmp;
    if (str) {
        while (*end) 
            ++end;
        --end;

        while (str < end) {
            tmp = *str;
            *str++ = *end;
            *end-- = tmp;
        }
    }
}
    
int main() {
    char str[] = "test";
    reverse(str);
    return 1;
}
