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

int length(struct node* head) {
    int length = 0;
    struct node* current = head;
    
    while (current != NULL) {
        length += 1;
        current = current->next;
    }
    return length;
}

int count(struct node* head, int searchFor) {
    int count = 0;
    struct node* current = head;

    while (current != NULL) {
        if (current->data == searchFor)
            count += 1;
        current = current->next;
    }
    return count;
}

int getNth(struct node* head, int n) {
    struct node* current = head;
    while (n-- > 0)
        current = current->next;
    return current->data;
}

void push(struct node** headRef, int init_data) {
    struct node* new_node = (struct node*)malloc(sizeof(struct node));
    new_node->data = init_data;
    new_node->next = *headRef;
    *headRef = new_node;
}

int pop(struct node** headRef) {
    struct node* head;
    int result;

    head = *headRef;
    assert(head != NULL);
    result = head->data;
    *headRef = head->next;
    free(head);
    return result;
}

int main() {
    struct node* head = (struct node*)malloc(sizeof(struct node));
    head->data = 5;
    head->next = NULL;

    push(&head, 10);
    push(&head, 5);
    push(&head, 4);
    push(&head, 2);
    push(&head, 1);

    printf("list[1] (should be 2) = %d\n", getNth(head,1));

    

    return 0;
}
