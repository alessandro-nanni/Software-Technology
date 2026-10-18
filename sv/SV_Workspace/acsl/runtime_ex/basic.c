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
        a[i] = a[i] + 2;
    }
    //@ assert \forall integer i; 0 <= i < len ==> a[i] == acopy[i] + 1;
}

/*
    @ requires n >= 0;
*/
void iterate(int n) {
    //@ ghost int it =0;
    while (n > 1) {
        //@ it++;
        if (n%2 == 0){
            n = n / 2;
        } 
        else {
            n = n * 3 + 1;
        }
    if (n > 4000){
        return true;
    } 
    }
    // @ assert(iter<=50);
}

    
int main(void) {
  int a[4] = {1, -2, 0, 41};
  add1(a, 4);

  iterate(27);
  return 0;
}
