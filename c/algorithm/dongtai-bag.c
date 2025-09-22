#include <stdio.h>

#define MaxN 4 // 物品数量
#define MaxW 5 // 背包容量

int max(int a, int b) { return a > b ? a : b; }

int main() {
  int V[] = {0, 2, 4, 5, 6}; // 物品价值
  int W[] = {0, 1, 2, 3, 4}; // 物品重量

  int F[MaxN + 1][MaxW + 1] = {}; // 子问题最优解

  for (int i = 1; i <= MaxN; i++) {   // 第几个物品
    for (int j = 1; j <= MaxW; j++) { // 当前背包可装物品的重量
      if (j >= W[i]) {
        // 不选择当前物品的最大价值
        int prev = F[i - 1][j];
        // 选择当前物品的最大价值，需要计算前面的商品在装入当前商品后，还能装多少商品
        int cur = F[i - 1][j - W[i]] + V[i];
        F[i][j] = max(prev, cur);
      } else {
        F[i][j] = F[i - 1][j];
      }
    }
  }

  printf("最大价值为：%d \n", F[MaxN][MaxW]);

  for (int i = 0; i <= MaxN; i++) {   // 第几个物品
    for (int j = 0; j <= MaxW; j++) { // 当前背包可装物品的重量
      printf("%d ", F[i][j]);
    }
    printf("\n");
  }

  return 0;
}