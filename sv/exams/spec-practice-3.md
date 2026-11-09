# 2 Specifications — practice round 3 (20 pts)

Write formal specifications for the following informal requirements in an appropriate specification
formalism of your choice (LTL, CTL, ACSL/JML contracts, LarVa). You may assume that appropriate
atomic propositions, program functions, and classes exist, but make sure that it is clear which
properties are represented by the atomic propositions.

## Part 1: Music festival

(a) (2 points) Visitors can only enter the festival area if they wear a valid wristband.

- constraint wristband.valid / G(enter=> valid wristband)

(b) (2 points) ★ The number of sold tickets can only increase, and it may never exceed 50,000.

- constraint tickets >= \old(tickets) && tickets <= 50000

(c) (2 points) It is possible that it rains during the entire festival.

- EF rain

(d) (2 points) If more than 1,000 people stand in front of the main stage, there is a risk that people
get injured.

- G(standing >= 1000 => injury)

(e) (2 points) A band may play for at most 90 minutes.

- start -> play [start playing]
  play -> bad [stop playing/c.compareTo(90*60) >= 0/;]
  play -> start [stop playing]

## Part 2: Ski resort

(f) (2 points) A ski lift may only run while the wind speed is below 60 km/h.

- constraint wind_speed < 60;

(g) (2 points) The price of a ski pass changes by at most 5 euros at a time, both up and down.

- constraint \old(price)-5 <= price <= \old(price)+5

(h) (2 points) There might be skiers who are still on a slope after the lifts have closed.

- G(lifts_closed EF skiers_on_slope > 0)

(i) (2 points) Every skier who starts a run will eventually reach the bottom of the slope, unless the
ski patrol picks them up.

- G(bottom W picked_by_patrol)

(j) (2 points) Once the avalanche alarm goes off, the lifts stay closed until the ski patrol declares
the area safe.

- start -> closed [alarm]
    closed -> open [declare_safe]
