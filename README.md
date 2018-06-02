# APCSAProject4
RandomWalk: README for more info
# Project 4: RandomWalk

* Author: Letizia Moro
* Class: CS121 Section X
* Semester: 2018

## Overview
This project generates a random path from the top-left corner at finds its way to the bottom-right corner.

## Compiling and Using

In order to use this program, the user must first download all the files. Then, from the command line, they must cd into the certain directory that hold all of the program contents.
To compile, type 'javac RandomWalkGUI.java' if theat runs wihtout errors, one can proceed to running
the program by typing 'java RandomWalkGUI (grid size) (seed value)'.
After hitting enter, the program will show a grid with a line that makes attemps to go to the bottom right corner of the grid. By Running the GUI file other than just RandomWalk, this allows the visual grid to pop up.

## Discussion

During the development of this program, one of the biggest challenges I encountered was that when the path got stuck and then restarted, the grid would clear but then the added point would draw a diagnol line that stopped at the point of intereferece of the previous line attempt. After much trial, I figured out that this was due to the x and y variables not being updated. Even thought the array list was cleared, the variables had the be reset to zero as well becaue they still were initialized the their previous values. With the help of Dylan Habersetzer, I learned I needed to include a return statemetn as well, because it allows for the step() method break and stop.
Something I useful I learned from this project was the conveniency of having seed instead of just random numbers that are not stored. Using a seed, which is a initialized set a random numbers to a number, this made debugging much more efficient.

I also created a higher probability of the path going South and East by setting that command to run of more conditions, so within six number there is a more probability of going South and East because they are set to run if two numbers within six are called.

## Testing

This program was tested by ensuring it could run from the command line,
To do this I created a 'P4Test' folder in my Downloads and then followed the 'Compiling and Using' INstructions stated above.

## Extra Credit
N/A
## Sources used

For how to set case statements to multiple cases [https://stackoverflow.com/questions/5086322/java-switch-statement-multiple-cases]

----------
This README template is using Markdown. To preview your README output, you can copy your file contents to a Markdown editor/previewer such as [https://stackedit.io/editor](https://stackedit.io/editor).
