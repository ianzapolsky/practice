#include <stdio.h>

void incrementArray(int* arr, int size);
void printArray(int* arr, int size);

int main()
{
  int arr[5] = {1, 2, 3, 4, 5};
  printArray(arr, 5);
  incrementArray(arr, 5);
  printArray(arr, 5);
  return 0;
}

void incrementArray(int* arr, int size)
{
  for (int i = 0; i < size; i++)
    *(arr+i) = *(arr+i)+1;
}

void printArray(int* arr, int size)
{
  for (int i = 0; i < size; i++)
    printf("element %d: %d\n", i, *(arr+i));
}
