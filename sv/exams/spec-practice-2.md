# 2 Specifications — practice (20 pts)

Write formal specifications for the following informal requirements in an appropriate specification
formalism of your choice (LTL, CTL, ACSL/JML contracts, LarVa). You may assume that appropriate
atomic propositions, program functions, and classes exist, but make sure that it is clear which
properties are represented by the atomic propositions.

## Part 1: Airport

(a) (2 points) Passengers can only board the plane if they have passed the security check.

- ```
/*@
requires p.passed_security_check
*/
void board_plane(passenger p)
```
(b) (2 points) It is always possible that a flight gets cancelled.
- AG EF flightCancelled

(c) (2 points) During boarding, the number of passengers on the plane can only increase.

- GF(newPassengers >= oldPassengers) (dont know if i can use \result with \old to compare the two)
(d) (2 points) A plane may never take off while another plane is landing on the same runway.

- G(!planeTakeOff<=>planeLanding)

(e) (2 points) Every time a plane is parked at the gate, it may stay there forever.

- AG EF reach_gate

## Part 2: Hospital

(f) (2 points) There might be patients who leave the hospital before they have seen a doctor.

- ```
/*@
behavior see_doctor:
    ensures: p.saw_doctor
behavior dont_see_doctor:
    ensures: !p.saw_dcotr
complete behavior see_doctor, dont_see_doctor
*/

void leave_hospital(patient p)
```

(g) (2 points) The dose of painkiller that a patient receives may be increased by at most 5 mg at a time.

- ```
/*@
requires 0<= amount <= 5;
ensures \result <= p.painkiller + amount; 
int increasePainkiller (patient p, int amount)
*/
```

(h) (2 points) At most 2 visitors may be at a patient's bed at the same time, unless the patient is in
the children's ward; there, 3 visitors are allowed.

- behavior visitors_n:
    assumes: !in_children_ward
    ensures: visitors <=2
- behavior visitors_c:
    assumes: in_children_ward
    ensures: visitors <=3
complete behavior visitors_n, visitors_c
*/

(i) (2 points) Between two operations, the operating room must be cleaned.

- operation -> operation [finish_operation\\room.clean()]

(j) (2 points) When a patient presses the alarm button, a nurse must arrive within 2 minutes.

- no_alarm -> alarm [nurse_arrive\c.compareTo(120)>=0\]
