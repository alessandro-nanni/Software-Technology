Nobody runs faster than Nadine Visser
```c
\forall athlete a; faster(nadine, a)

\forall a faster(a,nadine) => nadine = a
```

There exists an athlete who participated twice, and never won a medal
```c
\exists T x; participated(x) == 2 && madal(x) == 2
```

No athlete can win twice.
Note: exactly twice, thus winning thrice is ok
```c
\forall T x; !(wins(x)==2)
```

There exists an athlete who wins everything
```c
\exists T x; medal(x) == present(x)

\exists a: medal(a) > 0 & forall b: b!=a => medals(b) == 0
```

If an athlete is faster than Nadine Visser she is faster than everybody
```c
\exists a: faster(a,nadine) => not exists b: b!=a =>faster(b,a)
```

$ (exists e "faster"(e,u)) => forall e . "faster"(e,a) $


Sorted array postcondition

```c
/*@
  requires \valid(t+(0..n-1));
  ensures \forall int i; 0<= i < n - 1 => t[i] <= t[i+i];
*/
```