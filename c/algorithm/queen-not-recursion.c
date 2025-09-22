#include <stdio.h>
#include <stdlib.h>

#define N 6

int q[N + 1];

int check(int row) {
  for (int i = 1; i < row; i++) {
    if (q[i] == q[row] || abs(q[row] - q[i]) == abs(i - row)) {
      return 0;
    }
  }
  return 1;
}

int queen() {
  // 初始化队列
  for (int row = 0; row < N; row++) {
    q[row] = 0;
  }

  // 已有的方案数量
  int answer = 0;

  // 正在摆放第几个皇后（即第几行）
  int count = 1;

  while (count >= 1) {
    // 初始值为0，所以这里+1是从第一个位置开始摆放
    q[count]++;

    // 判断这个位置的皇后是否合法
    while (q[count] <= N && !check(count)) {
      q[count]++;
    }

    if (q[count] <= N) {
      // 合法的放置了该皇后
      if (count >= N) {
        answer++;
        printf("找到了第%d种方案：", answer);
        for (int qRow = 1; qRow <= N; qRow++) {
          printf("%d ", q[qRow]);
        }
        printf("\n");
      } else {
        count++;
      }

    } else {
      // 该皇后没有找到合适的位置，
      q[count] = 0; // 将该行的数据重置
      count--;      // 回溯到上一行
    }
  }

  if (answer == 0) {
    printf("%d皇后没有找到方案：", N);
  }

  return 0;
}

int main() {
  queen();
  return 0;
}