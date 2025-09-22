#include <stdio.h>

#define MaxN 5   // 物品数量
#define MaxW 100 // 背包容量

double answer[MaxN + 1];

void show(int v[], int w[], double vw[]) {
  printf("物品价值：\n");
  for (int i = 1; i <= MaxN; i++)
    printf("%d ", v[i]);
  printf("\n");

  printf("物品重量：\n");
  for (int i = 1; i <= MaxN; i++)
    printf("%d ", w[i]);
  printf("\n");

  printf("物品价值重量比：\n");
  for (int i = 1; i <= MaxN; i++)
    printf("%.2lf ", vw[i]);
  printf("\n");
}

double MaxValue(int v[], int w[], double vw[]) {
  double result = 0;

  int w_temp = MaxW;

  int i = 0;

  for (i = 1; i <= MaxN; i++) {
    if (w_temp >= w[i]) {
      answer[i] = 1;
      result += v[i];
      w_temp -= w[i];
    } else {
      break;
    }
  }

  if (w_temp > 0 && i <= MaxN) {
    answer[i] = (double)w_temp / w[i];
    result += w_temp * vw[i];
  }

  return result;
}

int main() {
  int V[] = {0, 65, 20, 30, 60, 40}; // 物品价值
  int W[] = {0, 30, 10, 20, 50, 40}; // 物品重量

  double VW[MaxN + 1]; // 物品价值重量比（v / w）

  for (int i = 1; i <= MaxN; i++) {
    VW[i] = (double)V[i] / W[i];
  }

  show(V, W, VW);

  double result = MaxValue(V, W, VW);
  printf("最大价值为：%.2lf \n", result);

  printf("\n方案：\n");
  for (int i = 1; i <= MaxN; i++)
    printf("%.2lf ", answer[i]);

  return 0;
}