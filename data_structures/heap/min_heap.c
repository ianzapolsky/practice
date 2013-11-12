// min_heap.c

// Description: Integer array implementation of a min heap.
// Author: Ian Zapolsky (10/30/13)

#include <stdlib.h>
#include <stdio.h>

struct heap {
    int arr[100];
    int ptr;
};

int rChild(int index) { return (index*2)+1; }
int lChild(int index) { return (index*2)+2; }
int parent(int index) { return (index-1)/2; }

struct heap* createHeap() {

    struct heap* newHeap = (struct heap*)malloc(sizeof(struct heap));
    int i;
    for (i = 0; i < 100; i++)
        newHeap->arr[i] = 0;
    newHeap->ptr = 0;
    return newHeap;
}

struct heap* bubbleUp(struct heap* heap, int index) {

    while (index > 0) {
        if (heap->arr[index] < heap->arr[parent(index)]) {
            int temp = heap->arr[parent(index)];
            heap->arr[parent(index)] = heap->arr[index];
            heap->arr[index] = temp;
            index = parent(index);
        }
        else 
            break;
    }
    return heap;
}

struct heap* bubbleDown(struct heap* heap) {
    
    int index = 0;
    while (index < parent(heap->ptr-1)) {
        printf("index: %d, arr[index]: %d\n", index, heap->arr[index]);
        if (heap->arr[index] > heap->arr[rChild(index)]) {
            int temp = heap->arr[rChild(index)];
            heap->arr[rChild(index)] = heap->arr[index];
            heap->arr[index] = temp;
            index = rChild(index);
        } else if (heap->arr[index] > heap->arr[lChild(index)]) {
            int temp = heap->arr[lChild(index)];
            heap->arr[lChild(index)] = heap->arr[index];
            heap->arr[index] = temp;
            index = lChild(index);
        }
        else break;
    }
    return heap;
}

int popMin(struct heap* heap) {
    int min = heap->arr[0];
    heap->arr[0] = heap->arr[heap->ptr-1];
    heap->ptr -= 1;
    heap = bubbleDown(heap);
    return min;
} 

struct heap* insert(struct heap* heap, int data) {

    // check if this is our first element
    if (heap->ptr == 0)
        heap->arr[heap->ptr++] = data;
    // otherwise, add to the next available array slot and bubble up the value
    else {
        heap->arr[heap->ptr++] = data;
        heap = bubbleUp(heap, heap->ptr-1);
    }
    return heap;
}


int main() {
    struct heap* test = createHeap();
    test = insert(test, 4);
    test = insert(test, 6);
    printf("%d\n", test->arr[0]);
    test = insert(test, 2);
    printf("%d\n", test->arr[0]);
    test = insert(test, 7);
    printf("%d\n", test->arr[0]);
    test = insert(test, 2);
    printf("%d\n", test->arr[0]);
    test = insert(test, 1);
    printf("%d\n", test->arr[0]);
    printf("%d\n", popMin(test));
    printf("%d\n", test->arr[0]);

}
