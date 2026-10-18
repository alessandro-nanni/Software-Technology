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
        a[i] = a[i] + 2; // bug: adds 2 instead of 1
    }
    //@ assert \forall integer i; 0 <= i < len ==> a[i] == acopy[i] + 1;
}

int main(void) {
    int a[4] = {1, -2, 0, 41};
    add1(a, 4);
    return 0;
}
