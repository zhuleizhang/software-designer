#include <stdio.h>

int MaxSubSum(int A[], int left, int right) {
  int sum = 0;

  if (left == right) {
    if (A[left] > 0) {
      sum = A[left];
    } else {
      sum = 0;
    }
  } else {
    int center = (left + right) / 2;
    int leftSubSum = MaxSubSum(A, left, center);
    int rightSubSum = MaxSubSum(A, center + 1, right);

    int LSum = 0;
    int tempLSum = 0;
    for (int i = center; i >= left; i--) {
      tempLSum += A[i];
      if (tempLSum > LSum) {
        LSum = tempLSum;
      }
    }

    int RSum = 0;
    int tempRSum = 0;
    for (int j = center + 1; j <= right; j++) {
      tempRSum += A[j];
      if (tempRSum > RSum) {
        RSum = tempRSum;
      }
    }

    sum = LSum + RSum;

    if (sum < LSum) {
      sum = LSum;
    }
    if (sum < RSum) {
      sum = RSum;
    }
  }

  return sum;
}

int main() {
  printf("sub sum \n");

  int A[] = {-2, 11, -4, 13, -5, -2};

  int subSum = MaxSubSum(A, 0, 3);

  printf("result: %d \n", subSum);

  return 0;
}