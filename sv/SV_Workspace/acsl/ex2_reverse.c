/* Exercise 2 --- reverse
 *
 * Specify a function void reverse(int b[], int N) which reverses the order
 * of elements in array b of size N.
 *
 * Write the contract (requires / assigns / ensures) as an ACSL annotation
 * in place of the TODO comment right above reverse.
 *
 * Check (see README.md):
 *   ./check.sh ex2_reverse.c -wp-fct test_reverse
 *       Does the contract say the right thing? WP proves the checks in
 *       test_reverse using ONLY your contract; it never looks at the body.
 *       A failed goal ending in _requires means your precondition rejects a
 *       legitimate call; a failed check means the contract is too weak
 *       (think also about what reverse may NOT touch).
 *
 *   ./check.sh ex2_reverse.c -wp-fct reverse          (optional, Ch. 10)
 *       Does the implementation satisfy the contract? This needs loop
 *       annotations (loop invariant / loop assigns / loop variant) in place
 *       of the TODO comment above the loop.
 */

/*@ requires N>0;
    requires \valid(b+(0..N-1));
    assigns  b[0..N-1];
    ensures  \forall integer i; 0<=i< N ==> b[N-1-i] == \old(b[i]);
*/
void reverse(int b[], int N) {
  /* TODO (optional, Ch. 10): loop annotations */
  for (int i = 0; i < N / 2; i++) {
    int tmp = b[i];
    b[i] = b[N - 1 - i];
    b[N - 1 - i] = tmp;
  }
}

/* ------------------------------------------------------------------------
 * Tests --- don't edit below this line.
 * ------------------------------------------------------------------------ */

void test_reverse(void) {
  int even[4] = {1, 2, 3, 4};
  int odd[5] = {1, 2, 3, 4, 5};
  int single[1] = {7};

  reverse(even, 4);
  //@ check even_length: even[0] == 4 && even[1] == 3 && even[2] == 2 && even[3] == 1;

  reverse(odd, 5);
  //@ check odd_length: odd[0] == 5 && odd[1] == 4 && odd[2] == 3 && odd[3] == 2 && odd[4] == 1;

  reverse(single, 1);
  //@ check length_one: single[0] == 7;

  // The later calls must not have disturbed the arrays reversed earlier.
  //@ check other_arrays_untouched: even[0] == 4 && even[3] == 1 && odd[0] == 5 && odd[4] == 1;
}
