/* Exercise 1 --- array segments
 *
 * Consider an array b with N integer elements. Let j and k be two indices,
 * 0 <= j < k < N. By 'b[j..k]' we mean the segment b[j], ..., b[k] (both
 * ends included), but note that we cannot just write 'b[j..k]' in ACSL.
 *
 * Write ACSL expressions that precisely describe the specifications below:
 * replace the `\true` placeholder in each predicate body. The predicates only
 * give names to b, N, j and k so that the expressions can be checked.
 *
 * Check:  ./check.sh ex1_segments.c          (see README.md)
 * The test_qX functions at the bottom assert what each expression must
 * evaluate to on small concrete arrays. Every goal proved = expression right
 * on those arrays. A [Timeout]/[Unknown] goal names the failing case.
 */

/*@
  // 1. All elements in b[j..k] are zero.
  predicate q1(int *b, integer N, integer j, integer k) =
    \forall integer i; j <= i <= k ==> b[i] == 0;

  // 2. All zeros of b[0..N-1] are in b[j..k].
  predicate q2(int *b, integer N, integer j, integer k) =
   \forall integer i; 0 <= i < N && b[i] == 0 ==> j <= i <= k;

  // 3. It is not the case that all zeros of b[0..N-1] are in b[j..k].
  //    (Try to push the negation inwards instead of writing !q2(...).)
  predicate q3(int *b, integer N, integer j, integer k) =
   \exists integer i; 0 <= i < N && b[i] == 0 && (i < j || i > k);

  // 4. b[0..N-1] contains two zeros (read: exactly two).
  predicate q4(int *b, integer N) =
    \exists integer x, y; 0 <= x < y < N
      && b[x] == 0 
      && b[y] == 0
      && (\forall integer z; 0 <= z < N && b[z] == 0 ==> z == x || z == y);

  // 5. b[0..N-1] contains at least two zeros.
  predicate q5(int *b, integer N) =
    \exists integer x, y; 0 <= x < y < N
      && b[x] == 0 
      && b[y] == 0;

  // 6. b[0..N-1] contains at most two zeros.
  //    First write a solution, then reflect on this: one example of an array
  //    that contains at most two zeros is an array which has only one
  //    element, i.e., it has length one. Does your solution evaluate to true
  //    if b has only one element?
  predicate q6(int *b, integer N) =
    \forall integer x, y, z; 0 <= x < y < z < N ==> !(b[x] == 0 && b[y] == 0 && b[z] == 0);

*/

/* ------------------------------------------------------------------------
 * Tests --- don't edit below this line.
 * ------------------------------------------------------------------------ */

void test_q1(void) {
  int arr[6] = {1, 0, 0, 0, 2, 3};
  int *b = arr;
  //@ check q1_segment_all_zero:  q1(b, 6, 1, 3);
  //@ check q1_nonzero_at_left:   !q1(b, 6, 0, 3);
  //@ check q1_nonzero_at_right:  !q1(b, 6, 1, 4);
}

void test_q2(void) {
  int arr[6] = {1, 0, 0, 5, 2, 3};
  int *b = arr;
  int none[4] = {1, 2, 3, 4};
  int *c = none;
  //@ check q2_exactly_the_zeros:  q2(b, 6, 1, 2);
  //@ check q2_wider_segment:      q2(b, 6, 0, 4);
  //@ check q2_misses_a_zero:      !q2(b, 6, 2, 4);
  //@ check q2_no_zeros_at_all:    q2(c, 4, 1, 2);
}

void test_q3(void) {
  int arr[6] = {1, 0, 0, 5, 2, 3};
  int *b = arr;
  int none[4] = {1, 2, 3, 4};
  int *c = none;
  //@ check q3_exactly_the_zeros:  !q3(b, 6, 1, 2);
  //@ check q3_wider_segment:      !q3(b, 6, 0, 4);
  //@ check q3_misses_a_zero:      q3(b, 6, 2, 4);
  //@ check q3_no_zeros_at_all:    !q3(c, 4, 1, 2);
}

void test_q4(void) {
  int a0[3] = {1, 2, 3};       int *zero0 = a0;
  int a1[3] = {1, 0, 3};       int *zero1 = a1;
  int a2[4] = {0, 1, 0, 3};    int *zero2 = a2;
  int a3[5] = {0, 1, 0, 3, 0}; int *zero3 = a3;
  //@ check q4_no_zeros:        !q4(zero0, 3);
  //@ check q4_one_zero:        !q4(zero1, 3);
  //@ check q4_two_zeros:       q4(zero2, 4);
  //@ check q4_three_zeros:     !q4(zero3, 5);
}

void test_q5(void) {
  int a0[3] = {1, 2, 3};       int *zero0 = a0;
  int a1[3] = {1, 0, 3};       int *zero1 = a1;
  int a2[4] = {0, 1, 0, 3};    int *zero2 = a2;
  int a3[5] = {0, 1, 0, 3, 0}; int *zero3 = a3;
  //@ check q5_no_zeros:        !q5(zero0, 3);
  //@ check q5_one_zero:        !q5(zero1, 3);
  //@ check q5_two_zeros:       q5(zero2, 4);
  //@ check q5_three_zeros:     q5(zero3, 5);
}

void test_q6(void) {
  int a0[3] = {1, 2, 3};       int *zero0 = a0;
  int a1[3] = {1, 0, 3};       int *zero1 = a1;
  int a2[4] = {0, 1, 0, 3};    int *zero2 = a2;
  int a3[5] = {0, 1, 0, 3, 0}; int *zero3 = a3;
  int single[1] = {0};         int *one = single;
  //@ check q6_no_zeros:        q6(zero0, 3);
  //@ check q6_one_zero:        q6(zero1, 3);
  //@ check q6_two_zeros:       q6(zero2, 4);
  //@ check q6_three_zeros:     !q6(zero3, 5);
  //@ check q6_length_one:      q6(one, 1);
}
