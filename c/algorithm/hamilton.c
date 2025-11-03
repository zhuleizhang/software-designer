#include <stdio.h>
#include <stdlib.h>
#define MAX 10

void Hamilton(int n, int c[n][n]) {
  int i;
  int x[MAX];
  int visited[MAX];
  int k;

  /*初始化x数组贺visited数组*/
  for (i = 0; i < n; i++) {
    x[i] = 0;
    visited[i] = 0;
  }
  /*访问起始顶点*/
  k = 0;
  visited[x[0]] = 1;
  x[0] = 0;
  k = k + 1;
  printf("first k: %d \n", k);
  /*访问其他顶点*/
  while (k >= 1) {
    x[k] = x[k] + 1;
    printf("k: %d \n", k);
    while (x[k] < n) {
      if (visited[x[k]] == 0 &&
          c[x[k - 1]][x[k]] == 1) { /*邻接顶点x[k]未被访问过*/
        break;
      } else {
        x[k] = x[k] + 1;
      }
    }

    if (x[k] < n && k == n - 1 && c[x[k]][0] == 1) { /*找到一条哈密尔顿回路*/
      for (k = 0; k < n; k++) {
        // 输出 x的类型
        printf("%d--", x[k]); /*输出哈密尔顿回路*/
      }
      printf("%d\n", x[0]);
      return;
    } else if (x[k] < n &&
               k < n - 1) { /*设置当前顶点的访问标志，继续下一个顶点*/
      visited[x[k]] = 1;
      k = k + 1;
    } else { /*没有未被访问过的邻接顶点，回退到上一个顶点*/
      x[k] = 0;
      visited[x[k - 1]] = 0;
      k = k - 1;
    }
  }
  printf("not found");
}

int main() {
  int c[5][5] = {0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0,
                 1, 0, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1};
  Hamilton(5, c);

  int c_a[4][4] = {
      0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0,
  };
  // Hamilton(4, c_a);
}

// 0, 1, 1, 1, 1,
// 1, 0, 1, 1, 1,
// 1, 1, 0, 1, 0,
// 1, 1, 1, 0, 0,
// 1, 1, 0, 0, 1