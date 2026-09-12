= Temporal Logic Formalisations
```
Write the following statements using both CTL and LTL if possible, or one of them otherwise.
- While p is true, q must be false.
- Whenever p is true, we can continue in such a way that q becomes true.
- From any state where p holds, we can reach states where q and states where r hold.
- At any time the reset button can be pushed.
- As a result of pushing the reset button the system eventually reaches the restart state.
- If we try to send a message infinitely often then eventually it will arrive.
```
LTL 
+ $G(p => not q)$
+ not possible
+ not possible
+ not possible
+ $G ("reset" => F "restart")$ 
+ $G F "send"=> F "receive"$
CTL
+ $A G (p=> not q)$
+ $A G (p => E F q)$
+ $(A G p => (E F q and E F r))$
+ $A G E X "push"$
+ $A G("reset" => A F "restart") $
+ $A G A F "send" => A F "receive" $

= Meaning of Temporal Logic Formulas
```
- The property r is true infinitely often.
- It is possible to end up in a state, such that p holds in all reachable states. It is possible to end up in a state, such that p holds forever.
- Everywhere it holds that if a p-state can be reached then a q-state can be reached.
- If p becomes true, it will remain true until q becomes true and remains true during true-to-false transition of p.
```
+ $G F r$
+ $E F A G p $
+ $A G(E F p => E F q)$
+ $G(p=>p U (q and q W not p))$