#include <stdio.h>
#include <stdlib.h>

#define N 10

int q[N + 1];

int check(int row) {
  for (int i = 1; i < row; i++) {
    if (q[i] == q[row] || abs(q[row] - q[i]) == abs(i - row)) {
      return 0;
    }
  }
  return 1;
}

// 已有的方案数量
int answer = 0;

int queen(int row) {

  for (int col = 1; col <= N; col++) {
    // 给当前的皇后放在再col列
    q[row] = col;

    if (check(row)) {
      if (row >= N) {
        answer++;
        printf("找到了第%d种方案：", answer);
        for (int qRow = 1; qRow <= N; qRow++) {
          printf("%d ", q[qRow]);
        }
        printf("\n");
      } else {
        // 放置下一个皇后
        queen(row + 1);
      }
    }
  }

  return 0;
}

int main() {
  // 初始化队列
  for (int row = 0; row < N; row++) {
    q[row] = 0;
  }

  queen(1);

  if (answer == 0) {
    printf("%d皇后没有找到方案：", N);
  }

  return 0;
}