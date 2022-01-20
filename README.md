# ConferenceManager

You are planning a big programming conference and have received many proposals which
have passed the initial screen process but you're having trouble fitting them into the time
constraints of the day --there are so many possibilities! So you write a program to do it for
you.

The conference has multiple tracks each of which has a morning and afternoon session.
Each session contains multiple talks.

Morning sessions begin at 9am and must finish by 12 noon, for lunch.

Afternoon sessions begin at 1pm and must finish in time for the networking event. 

The networking event can start no earlier than 4:00 and no later than 5:00.

No talk title has numbers in it.

All talk lengths are either in minutes (not hours) or lightning (5 minutes).

Presenters will be very punctual; there needs to be no gap between sessions.

Note that depending on how you choose to complete this problem, your solution may give
a different ordering or combination of talks into tracks. This is acceptable; you don’t need
to exactly duplicate the sample output given here.

1. How do you determine the Track a talk will fall under?  In other words, how did you split up the initial list?
A talk can be under any track it is up to your algorithm to decide how best to fit talks into tracks

2. How is the order of the Talks determined? I had a look and confirmed that the talks for each track are not ordered by title or duration... What criteria did you use to order them?
The order is not important the main thing is that the talks fit into the given track, the track does not overrun and the entire day is not too long based on the rules provided in the exercise.

The best way to think about it is you are given a talk x, this talk has a certain duration. 
You need to work out how to fit that duration into the day and the overall conference and make sure
 all talks are slotted in somewhere (the title of the talk is not relevant except for the networking event,
 the main relevant info is the duration for calculation purposes, the title is important for display purposes)

NOTES FOR RUNNING APP:
1. Place import file in File Import Location see FileImportService.java for path
2. Run AppStart.java 
