#include <stdbool.h>
#include <stdio.h>
#include <stdlib.h>
#include <civlc.cvh>
$input int n = 4;
$input int idx1 = 0;
$input int idx2 = n;
$input int inorder[n+1]; // input array from which the tree is derived

struct Node {
	int data;
	int idx;
	struct Node *left, *right;
};

struct Node* newNode(int key, int arrIdx) {
	struct Node* node = (struct Node*) malloc(sizeof(struct Node));
	node->data = key;
	node->idx = arrIdx;
	node->left = node->right = 0;
	return node;
}

void deleteTree(struct Node* node) {
  if (node == 0) {
    return;
  }
  deleteTree(node->left);
  deleteTree(node->right);
  free(node);
}

int minElementIndex(int inorder[], int start, int end) {
	int minIndex = start;
	for (int i = start + 1; i <= end; i++) {
		if(inorder[minIndex] > inorder[i]) {
			minIndex = i;
		}
	}
	return minIndex;
}

struct Node* constructTree(int inorder[], int start, int end) {
	if (start > end) {
		return 0;
	}
	
	int index = minElementIndex(inorder, start, end);
	struct Node *root = newNode(inorder[index], index);
	root->left  = constructTree(inorder, start, index-1);
	root->right = constructTree(inorder, index+1, end);
	return root;
}

void printTree(struct Node* root) {
	if (root != 0) {
		fprintf(stdout, "Data: %d\n", root->data);
		printf("Left tree: \n");
		printTree(root->left);
		printf("Right tree: \n");
		printTree(root->right);
	}
}

struct Node *nodeForIdx(struct Node *root, int idx) {
	if (root == 0 || root->idx == idx) {
		return root;
	}
	if (root->idx > idx) {
		return nodeForIdx(root->left, idx);
	} else {
		return nodeForIdx(root->right, idx);
	}
}

// You may assume that this function is correct and side-effect free. 
// I.e. you may use it in specifications.
bool reachable(struct Node *from, struct Node *to) {
	if (from == 0 || from == to) {
		return from;
	} else {
		return (reachable(from->left,  to) != 0) || 
			   (reachable(from->right, to) != 0);
	}
}

struct Node *findLCA(struct Node *root, struct Node *n1, struct Node *n2) {
	int lowIdx  = n1->idx <= n2->idx ? n1->idx : n2->idx;
	int highIdx = n1->idx <= n2->idx ? n2->idx : n1->idx;

	struct Node *res = 0;
	struct Node *current = root;
	while (current != 0) {
		if (lowIdx <= current->idx && current->idx <= highIdx) {
			break;
		} else if (lowIdx > current->idx) {
			// current->idx < lowIdx
			current = current->right;
		} else {
			// current->idx > highIdx
			current = current->left;
		}
	}
	res = (reachable(current, n1) && reachable(current, n2)) ? current : 0;
	return res;
}

int main() {
	struct Node* root;
	root = constructTree(inorder, 0, n);
	printTree(root);
	struct Node *n1 = nodeForIdx(root, idx1);
	struct Node *n2 = nodeForIdx(root, idx2);
	struct Node *minNode = findLCA(root, n1, n2);
  	deleteTree(root);
	return 0;
}
