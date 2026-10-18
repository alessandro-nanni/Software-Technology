/*@ requires len >= 0;
  requires \valid(a+(0..len-1));
*/
void add1(int* a, int len) {
    //@ ghost int acopy[len];
    int i;
    for(i = 0; i < len; i++) {
        //@ ghost acopy[i] = a[i];
    }
    for(i = 0; i < len; i++) {
        // bug: elements >= 1000 are left unchanged
        if (a[i] < 1000) {
            a[i] = a[i] + 1;
        }
    }
    //@ assert \forall integer i; 0 <= i < len ==> a[i] == acopy[i] + 1;
}

int main(void) {
    // No element is >= 1000, so the buggy path never runs and E-ACSL only
    // sees correct results. With {1, -2, 0, 5000} the assertion fails.
    int a[4] = {1, -2, 0, 41};
    add1(a, 4);
    return 0;
}
