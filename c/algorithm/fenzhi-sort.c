#include <stdio.h>

#define INT_MAX 2147483647

void Merge(int A[], int left, int middle, int right) {
  int leftEnd = middle - left + 1;
  int rightEnd = right - middle;
  int i, j, k;
  int L[50], R[50];

  for (i = 0; i < leftEnd; i++) {
    L[i] = A[left + i];
  }
  for (j = 0; j < rightEnd; j++) {
    R[j] = A[middle + j + 1];
  }
  L[leftEnd] = INT_MAX;
  R[rightEnd] = INT_MAX;

  i = 0;
  j = 0;
  for (k = left; k < right + 1; k++) {
    if (L[i] < R[j]) {
      A[k] = L[i];
      i++;
    } else {
      A[k] = R[j];
      j++;
    }
  }
}

// 归并排序
void MergeSort(int A[], int left, int right) {
  if (left < right) {
    int m = (left + right) / 2;
    printf("m: %d \n", m);
    MergeSort(A, left, m);
    MergeSort(A, m + 1, right);
    // merge(A, left, m, right);
    Merge(A, left, m, right);
  }
}

int main() {
  printf("fenzhi sort \n");

  int A[] = {1, 5, 9, 2, 8, 3};

  MergeSort(A, 0, 5);

  int i;
  for (i = 0; i < 6; i++) {
    printf("%d ", A[i]);
  }
  printf("\n");

  return 0;
}