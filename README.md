# Description: 
This is a console game *simplified* version of monopoly.<br />
Created by Indu, Aden, and Priya from G3.

# Major Differences from Normal Monopoly
* You can't purchase houses or hotels. 
* You cant't sell property to other players or mortage your properties.
* You start with $2000 instead of $1500.
* The banker is the program.
* You can have a negative bank balance, but if you do at the end of the game, you are automatically not a winner.<br />
    *you can have no winners if everyone has a negative balance*

# How to Play
After pressing run program, the program will prompt you to enter the number of players and the names of each player. Follow the prompts asking you which keys to press in order to roll the die, pruchase property, get out of jail, pay rent, etc. until the program reads the next players name. For example, if the next player is **Harry**: <br />
`Next Player: Harry` <br />
Then it is Harry's turn. <br />
Except for houses, hotels, players selling properties to each other, and mortgages, game rules are mostly the same. <br />
See: [Rules of Monopoly](https://www.ultraboardgames.com/monopoly/game-rules.php)

# Sample Execution Path
*(After running the program)* When you see: <br />
1. `How many players do you have?` Type `2` and press Enter
2. `Player 1, what is your name?` Type `Mrs. Kane` and press Enter
3. `Player 2, what is your name?` Type `Harry` and press Enter
4. `Press any key to roll the dice` Type `d` and press Enter<br />


From Here paths may vary. As a general rule, you should be able to follow prompts. If you see: <br />
`Press 1 to purchase or any other key to not purchase.` Type `1` and press Enter<br />
`Press y to end OR any other key to continue` Type `d` and press Enter (continuing game)<br />
`Press any key to roll the dice` Type `d` and press Enter<br />
`Press any key to pay` Type `d` and press Enter (paying rent to another player)<br />
And lastly if you see: <br />
```
Press:
1 to pay $50 to get out
2 to roll dice (need doubles to get out)
Press any other key to stay in jail
```
Type `1` and press Enter<br /><br />
Follow this until you want to end game. To end game, if you see: <br />
`Press y to end OR any other key to continue` Type `y` and press Enter<br />
This will display winners.

# APCSA Optional Concepts Used
Throughout: 
* Primitives
* PEMDAS
* Pass By Value & Pass By Object Reference

In specific places
* Sorting *see insertionSort() method in Game class*
* They key word static *see BoardMap class and main class*
<br /> <br /> <br /> <br />

*(Made in Visual Studio Code in java)*