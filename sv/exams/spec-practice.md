# Specification practice (ex2 style)

Write each requirement as an LTL or CTL formula (NuSMV syntax: `G F X U`, `AG AF EF`, `->`, `<->`, `&`, `|`, `!`).
Invent whatever atomic propositions you need.

1. If the alarm rings, I eventually wake up.
   - G(alarmring=>F wake up)

2. I can only enter the office if my badge is valid.
   - G(enteroffice=>badgeValid)

3. Whenever the traffic light is red, the cars are stopped.
   - G (redLight => !carsMoving)

4. The train doors are only open when the train is standing still.
   - G (openDoor => trainStill)

5. I never forget my keys when I leave the house.
   - G( leaveHOuse => hasKeys)

6. I drink coffee every now and then.
   - AGEF drinkCoffee

7. Before the oven door can be opened, the oven must be switched off.
   - G ( openDoor =>ovenoff)

8. If I press the elevator button, the elevator will eventually arrive.
   - G(pressButton=>F elevatorArrive)

9. The printer never prints while it is out of paper.
   - AG(print=> Haspaper)

10. The heating is on unless a window is open.
    - G(!windowOpen -> heatingOn)

11. At some point the battery is empty, and from then on it stays empty.
    - F G batteryEmpty

12. It must always be possible to get back to the home screen.
    - G F homeScreen

13. After a request, the server responds in the very next step.
    - G(request => X result)

14. The car only starts if the seatbelt is fastened.
    - G(seatbelt => carStart)

15. I keep studying until the exam starts.
    - G(exam U !study )

16. The light never stays on forever.
    - AGAF lightOff

17. Whenever I'm logged out, it's possible to log back in later.
    - G(logOut => GF logIn)

18. Once the fire alarm goes off, the emergency doors stay unlocked forever.
    - G(fireAlarm => GF doorsUnlocked)

19. The gate is open exactly when a valid ticket has been scanned.
    - G(scanTicket=> gateOpen)

20. ★ A payment is never made before the customer has confirmed it.
    - AG(confirmPaymetn => AF makePayment)
