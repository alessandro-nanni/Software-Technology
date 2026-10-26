// Addition: add1 increases every element of arr by 1.
//   1. Write the contract and the body, then check them: ./run.sh add1.c
//   2. cp add1.c add1_caught.c and add a bug that E-ACSL reports.
//   3. cp add1.c add1_missed.c and add a bug that E-ACSL does not report.

// TODO: contract (/*@ requires ...; ensures ...; */)
void add1(int* arr, int len) {
  // TODO
}

int main(void) {
  int a[4] = {1, -2, 0, 41};
  add1(a, 4);
  return 0;
}
