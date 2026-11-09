# 2 Specifications — practice round 5 (30 pts)

Write formal specifications for the following informal requirements in an appropriate specification
formalism of your choice (LTL, CTL, ACSL/JML contracts, LarVa). You may assume that appropriate
atomic propositions, program functions, and classes exist, but make sure that it is clear which
properties are represented by the atomic propositions.

(a) (2 points) A car can only leave the parking garage if the parking fee has been paid.

- G(leave => paid)

(b) (2 points) It is possible that a student passes the exam without ever having attended a lecture.

- AG EF (pass & lectures_attended == 0 )

(c) (2 points) The pedestrian light is green exactly when the car light is red.

- G(p_light == green <-> c_light == red)

(d) (2 points) The battery of a phone might run empty while a phone call is in progress.

- EF (battery == 0 & call_in_progress)

(e) (2 points) ★ The balance of a bank account may never drop below 0, and a single withdrawal is at
most 1,000 euros.

- constraint balance >= 0 && withdrawl <= 1000;

(f) (2 points) Once a user has deleted their account, they can never log in again.

- AG(delete_account => AG !log_in)

(g) (2 points) Once a washing program has started, the door of the washing machine stays locked until
the program has finished.

- G(wash_start => door_locked U wash_finish)

(h) (2 points) Every order that is placed in the online shop will eventually be delivered or cancelled.

- G(order => (order_delivered W cancelled))

(i) (2 points) It is possible that the elevator never leaves the ground floor.

- EG (floor == 0)

(j) (2 points) The score of a basketball team never decreases, and increases by at most 3 points at a
time.

- constraint score >= \old(score) && amount <= 3;

(k) (2 points) If the water tank of the coffee machine is empty, there is a risk that the machine
overheats.

- AG(tank_empty => EF machine_overheat)

(l) (2 points) After 3 failed login attempts in a row, no further login attempt may succeed.

- start -> login [attempt/right_pass/ attempts = 0;]
start -> start [attempt/!right_pass/ attempts++]
start -> bad [attempt/ !right_pass && attempts >= 3
]
(m) (2 points) The pedestrian light must stay green for at least 10 seconds.

- red -> green [turnGreen]
- green -> bad [turnOrange/c.compareTo(10)<=0]
- green -> orange [turnOrange]

(n) (2 points) Once a reservation has been cancelled, it cannot be cancelled again until it has been
re-booked.

- AG(cancel => EF (cancel W book))

(o) (2 points) The function `int max(int a[], int n)` returns the largest element of the non-empty
array `a` of length `n`.

- ensures \forall integer i; 0<= i <= n => a[i] <= \result  
