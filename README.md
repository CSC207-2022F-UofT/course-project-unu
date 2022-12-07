# CSC207 Course Project UNU

## Software Specification

Our computer program allows a user to play UNO against bots. The program deals cards to players and users can either play valid cards from their hand or draw cards from the deck during their turns. Certain cards have special effects on the game.

Users can choose:

- Player names

- The difficulty of their opponents

- To play in teams

The program also records player statistics.

## Run Instructions

The program runs on Java 11. To run the program, run the file called GameManager in the UI package.

## Game Setup Instructions

First, pick between playing a Regular game and a Team game. This will open a new setup window.

Next, input player names and press the enter key in all text boxes to initialize all the players. As well, select a difficulty for all bot players, and team names if appropriate.

If the game does not start after clicking "Start Game", please try the above instructions again, ensuring that a difficulty has been selected for each bot player and the enter key has been hit for every text box.

Should all the information be inputted correctly, the game window will open.

## Play Instructions

The game follows most of the traditional rules of UNO. The first player to get rid of all of their cards wins the game. 

To draw a card during your turn, click the "Draw Card" button. To play a card on your turn, click the "Play Card" button and select a card to play. If you do not have any playable cards, no cards will show up here. In this case, do not close the window! Simply switch back to the main game window and draw a card instead.

After you have either drawn or played a card, the bot players will make their moves. 

Once anyone wins the game, a new window will open and state whether or not you have lost the game. If you are playing in team mode and your teammate has won, it will count as your win. You will then have the option to start a new game. Statistics are automatically recorded by the game.

## Project Roles

Sean: Bot player functionality, Database

Paul: Basic game mechanics

Sviat: Team mode, controller

Sarah: User interface, controller

Noelle: Moves system

Tom: Player profile system

Thompson: Card effects
