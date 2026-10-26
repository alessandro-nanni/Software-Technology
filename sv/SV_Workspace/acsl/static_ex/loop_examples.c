typedef enum _bool { false = 0, true = 1 } bool;
/*@
    ensures \result == n*n*n;
*/
int third_power(int n) {
    int u = 0;
    int v = 1;
    int  w = 6;
    int k = 0;
    /*@
    loop invariant 0<= k <= n;
    loop invariant u == k*k*k;
    */
    while (k < n) {
        u = u + v;
        v = v + w;
        w = w + 6;
        k = k + 1;
    }
    return u;
}


 bool search(int* a, int val, int length) {
    bool found = 0;
    int i = 0;
    
    while (i < length && !found) {
        if (a[i] == val) { found = true; }
        i++;
    }
    return found;
}
