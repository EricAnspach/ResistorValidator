# ResistorValidator

From the C3: Code, Craft, Community Meetup 7/17/19

This is a coding exercise to develop a program that validates a resistor's tolerances.

From the documentation provided for the challenge:

A resistor is a ubiquitous component found in all kinds of electronic equipment. Resistors are marked with between 3 and 5 colored stripes that are used to indicate the resistance value and tolerance. For a three- or four-stripped resistor, the first two stripes represent the first two digits of the resistance in ohms, the third represents a multiplier, and the fourth represents the tolerance (which, if absent, denotes ±20%). For a five-stripped resistor, the first three stripes represent the first three digits of the resistance in ohms, the fourth represents a multiplier, and the fifth represents the tolerance. Each color represents a specific numeric value.

See the ResistorValidator.pdf file in the repo for examples.

Determine whether the actual observed value is within the valid range described by the colored stripes. If the actual value is within range, your function should return true (i.e., the resistor is performing as expected). If the actual value falls outside the expected range, your function should return false (i.e., the resistor has failed). Your function should handle 3-stripe, 4-stripe, and 5-stripe resistors. For a 3-stripe resistor, you can assume that the array of colors will contain four entries where the last entry is “none”.

The signature of your function should look like this:

public bool IsInRange(string[] stripeColor, double measuredOhms) { }

Example usage:

string[] stripes = { "brown", "black", "red", "gold" };
bool inRange = IsInRange(stripes, 1017);
// inRange is true because resistance = 1000 ohms +/- 5% (i.e., 950 <= 1017 <= 1050)
