# OOPAufgabe1-3

TODO:
-Exceptions werfen falls unsinnige Werte in Konstruktoren übergeben werden. (oder eventuell auch nie parameter unter 0 erlauben).
- HarvestedWood usedWood() & DeadWood decayWood() so anpassen, dass durch % Werte 0 erreicht werden kann, alle Werte stimmen.


BUGS:
-Limit decay (and other procentual values) to 0-1, (e.g) if parameter is 1.1F negative values can appear.
-Changing parameters while simulation is running can yield negative values.
REFACTORS:
-apuffler: Refactoring: toString() zu Forest hinzugefügt. Fixed table inconsistency. Added getYear(). (Should we also do a setYear? Emulating a timemachine by calling update in a row).	



===========
Klassendiagramm-Visualizer: https://www.draw.io/
===========
Aufteilung (2te Aufgabe):
Jovan: Simulation 
Stefan: Forest + Tests
Armin: Models (ClimateModel, EconomyModel und dazu gehörige Klassen)
