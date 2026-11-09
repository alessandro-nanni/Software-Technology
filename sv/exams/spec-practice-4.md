# 2 Specifications — practice round 4 (30 pts)

Write formal specifications for the following informal requirements in an appropriate specification
formalism of your choice (LTL, CTL, ACSL/JML contracts, LarVa). You may assume that appropriate
atomic propositions, program functions, and classes exist, but make sure that it is clear which
properties are represented by the atomic propositions.

## Part 1: Smart home

(a) (2 points) The front door can only be unlocked if the correct PIN has been entered.

- G(unlock => correct_pin)

(b) (2 points) The heating and the air conditioning are never on at the same time.

- G(!(heating & air_conditioning))

(c) (2 points) The robot vacuum cleaner returns to its charging station every now and then.

- AG AF return_to_station

(d) (2 points) The temperature set on the thermostat changes by at most 2 degrees at a time.

- constraint \old(temperature) <= temperature <= \old(temperature) + 2

(e) (2 points) ★ If the smoke detector detects smoke, the alarm sounds in the next step, and it keeps
sounding until someone presses the reset button.

- G(smoke => X(sound W reset)) // if there is smoke, it sounds until someone presses reset button (if it ever gets pressed) 

## Part 2: Library

(f) (2 points) The function `int lateFee(int daysLate)` never returns a negative amount, and returns 0
if the book was returned on time.

- ensures (\result >= 0) && (return_on_time ==> \result == 0);

(g) (2 points) A borrowed book might never be returned.

- AG(borrow_book => EG !return_book)

(h) (2 points) A member who has unpaid fees cannot borrow a book until the fees are paid.

- G(!paid_fees => (!borrow_book W paid_fees))

(i) (2 points) Once a book has been marked as damaged, it stays out of circulation forever.

- G(damaged => GF out_of_circulation)

(j) (2 points) Between two loans of the same book, a librarian must check the book.

// pov of the book
- start -> loaned [loan_book]
loaned -> bad [loan_book/!checked ]
loaned -> loaned [loan_book/checked]
## Part 3: Space station

(k) (2 points) If the oxygen level drops below 18%, there is a risk that the astronauts lose
consciousness.

- G (oxygen <= 18 => EF loose_consciousness)

(l) (2 points) Two astronauts might be outside the station at the same time while the radio is broken.

- AG(radio_broken => EG(two_astronauts))

(m) (2 points) The docking hatch is open exactly when a spacecraft is docked.

- G(spacecraft_docked => hatch_open)

(n) (2 points) A spacewalk may last at most 6 hours.
```
- in -> out [exit\\c.reset()]
- out -> bad [c@6*60*60]
- out -> in[enter]
```
(o) (2 points) After a spacewalk, an astronaut must rest for at least 12 hours before starting the next
spacewalk.

- spacewalk -> rest
- rest -> bad [exit/c.compareTo(12*60*60)>=0/;]
- rest -> spacewalk [exit]