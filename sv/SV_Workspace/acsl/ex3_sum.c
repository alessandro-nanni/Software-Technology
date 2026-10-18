/* Exercise 3 --- sum
 *
 * Write a function contract for a function that computes the sum of all
 * elements of an array of doubles.
 * Hint: use ACSL's built-in \sum function in your specification:
 *     \sum(lo, hi, \lambda integer k; e)   =   e[k:=lo] + ... + e[k:=hi]
 * (lo and hi inclusive; an empty range lo > hi sums to 0).
 *
 * Part A --- the exercise: contract for `sum`, using \sum.
 *   WP (Frama-C 33) cannot reason about \sum / \lambda yet ("Lambda-functions
 *   not yet implemented"), so for Part A the check is only that Frama-C
 *   parses and type-checks your contract without errors:
 *       ./check.sh ex3_sum.c
 *
 * Part B --- optional, provable: define the sum yourself as a recursive
 *   logic function arr_sum and give sum_b the same contract in terms of it.
 *   Then WP proves the checks in test_sum_b using only that contract:
 *       ./check.sh ex3_sum.c -wp-fct test_sum_b
 *
 * Think about: check.sh treats double as a mathematical real
 * (-wp-model typed+real). Could a real C implementation that adds up doubles
 * actually satisfy your postcondition exactly?
 */

/* Part A ------------------------------------------------------------------ */

/*@
requires N >= 0 && \valid(a+(0..N-1));
ensures \result == \sum(0,N-1,\lambda integer i; a[i]);
@*/
double sum(double a[], int n);

/* Part B (optional) ------------------------------------------------------- */

/*@
  // arr_sum(a, n) = a[0] + ... + a[n-1]   (0 when n <= 0)
  logic real arr_sum(double *a, integer n) =
    0.0; // TODO (it may call itself)
*/

/* TODO: same contract as sum, but using arr_sum instead of \sum */
double sum_b(double a[], int n);

/* ------------------------------------------------------------------------
 * Tests for Part B --- don't edit below this line.
 * ------------------------------------------------------------------------ */

void test_sum_b(void) {
  double arr[3] = {1.5, 2.0, -0.5};
  double all = sum_b(arr, 3);
  //@ check three_elements: all == 3.0;
  double first = sum_b(arr, 1);
  //@ check one_element: first == 1.5;
  double none = sum_b(arr, 0);
  //@ check empty: none == 0.0;
}
