// Basic runtime assertion checking.
// The comments in fun claim things that aren't always true. Write them as
// ACSL assertions (//@ assert ...;) and run ./run.sh basic.c to show that
// the program can fail.

int fun(int a) {
  int x, y;
  int sum, result;
  if (a == 0) {
    x = 0;
    y = 0;
  } else {
    x = 5;
    y = 5;
  }
  sum = x + y;       // sum cannot be 0
  result = 10 / sum; // no division by 0
  return result;
}

int main(void) {
  fun(42);
  fun(0);
  return 0;
}
