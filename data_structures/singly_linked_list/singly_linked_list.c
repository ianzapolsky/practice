// singly_linked_list.c 

// Description: Standard implementation of a singly linked list in C.
// Author: Ian Zapolsky (10/16/13)

#include <assert.h>
#include <stdio.h>
#include <stdlib.h>

struct node {
    int data;
    struct node* next;
};

struct node* newNode(int data) {
    struct node* newNode = (struct node*)malloc(sizeof(struct node));
    newNode->data = data;
    newNode->next = NULL;
    return newNode;
}

void print(struct node** root) {
    struct node* cur = *root;
    while (cur != NULL) {
        printf("%d,", cur->data);
        cur = cur->next;
    }
    printf("\n");
}

struct node* insert(struct node** root, int data) {
    struct node* n = newNode(data);
    n->next = *root;
    return n;
}

int main() {
    
    struct node* root = newNode(10);
    root = insert(&root, 4);
    print(&root);
    return 0;
}
