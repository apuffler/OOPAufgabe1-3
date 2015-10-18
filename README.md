# OOPAufgabe1-3

TODO:
-Exceptions werfen falls unsinnige Werte in Konstruktoren übergeben werden. (oder eventuell auch nie parameter unter 0 erlauben).


BUGS:
-Limit decay (and other procentual values) to 0-1, (e.g) if parameter is 1.1F negative values can appear.

REFACTORS:
-apuffler: Refactoring: toString() zu Forest hinzugefügt. Fixed table inconsistency. Added getYear(). (Should we also do a setYear? Emulating a timemachine by calling update in a row).	
