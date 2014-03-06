#include <stdio.h>
#include <stdlib.h>

int *input_array(int size);
int get_bulls(int *target, int *guess, int size);
int get_cows(int *target, int *guess, int size);

int main()
{
  int *arr = input_array(4);
  int *guess = input_array(4);
  printf("bulls: %d\n", get_bulls(arr, guess, 4));
  printf("cows: %d\n", get_cows(arr, guess, 4));
  free(arr);
}

// indicates exact positional and value matches
int get_bulls(int *target, int *guess, int size) {
  int bulls = 0;
  for (int i = 0; i < size; i++) {
    if (target[i] == guess[i])
      bulls += 1;
  }
  return bulls;
}

// indicates value matches in the wrong position
int get_cows(int *target, int *guess, int size) {
  int cows = 0;
  for (int i = 0; i < size; i++) {
    int tmp = guess[i];
    for (int j = 0; i < size; i++) {
      if (j == i)
        /* do nothing */;
      else if (guess[i] == target[j])
        cows += 1;
        break;
    }
  }
  return cows;
}

// get array comprised of input integers
int *input_array(int size) {
  printf("please enter a 4-digit number\n");

  // allocate memory and ensure that it's there
  int *tmp = malloc(size*sizeof(int));
  if (tmp == NULL) {
    printf("memory could not be allocated\n");
    exit(1);
  }

  // read input from stdin
  for (int i = 0; i < size; i++) {
    tmp[i] = getchar()-'0';
  }
  // clear the newline character
  getchar();
  return tmp;
}
