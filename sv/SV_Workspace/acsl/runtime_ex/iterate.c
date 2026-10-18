void iterate(int n) {
    //@ ghost int it = 0;
    while (n > 1) {
        //@ ghost it++;
        //@ assert it <= 50;
        if (n % 2 == 0) {
            n = n / 2;
        } else {
            n = n * 3 + 1;
        }
        if (n > 4000) {
            return;
        }
    }
}

int main(void) {
    for (int n = 1; n < 10; n++) {
        iterate(n);
    }
    iterate(27);
    return 0;
}
