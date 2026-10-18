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


/*@
requires len>=0;
requires \valid(arr+(0..len-1));
assigns arr;
ensures \forall int i; i = 0; i<len; i++; ==> arr[i] == \old(arr[i]) +1;
*/
void add1(int* arr, int len){
    for(int i = 0; i<len; i++){
        arr[i] = arr[i]+1;
    }
}
    
int main(void) {
  fun(42);
  fun(0);
  return 0;
}
