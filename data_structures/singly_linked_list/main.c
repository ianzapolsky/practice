// main.c

// Description: Tooling around with C, with the eventual goal of coding a min
// heap.
// Author: Ian Zapolsky (10/30/13)

#include <stdlib.h>
#include <stdio.h>

struct node {
    int data;
    struct node* left;
    struct node* right;
};

struct node* insert(struct node** root, int data) {
    
    struct node* n = (struct node*)malloc(sizeof(struct node));
    n->data = data;    
    n->right = *root;
    n->left = NULL;
    return n;

}

int main() {
    
    struct node* root = (struct node*)malloc(sizeof(struct node));
    root->data = 10;
    root->left = NULL;
    root->right = NULL;
    
    printf("%d\n", root->data);    

    root = insert(&root, 5); 

    printf("%d, %d\n", root->data, root->right->data);
    
    free(root);
    return 0;
}
