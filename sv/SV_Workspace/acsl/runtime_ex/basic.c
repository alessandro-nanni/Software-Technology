#include <stdio.h>

int main(void) {
  int a[5];
  for (int i = 0; i <= 5; i++) {
    /*@ assert 0 <= i < 5; */
    a[i] = 0;
  }
  printf("done\n");
  return 0;
}
