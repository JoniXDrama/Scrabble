# Scrabble Game
This is a JavaFX implementation of the Scrabble game using the Model-View-ViewModel (MVVM) architecture and Observer-Observable design pattern. The game operates with Server-Socket and has two modes: Guest and Host mode. This project was developed as part of a college course and demonstrates knowledge of advanced programming concepts, including design patterns, object-oriented programming, and user interface design.

## Team Members
[Tal Zigelnik](https://github.com/xxxlr1)  
[Or Shimon](https://github.com/Orshimon810)  
[Jonathan Cwengel](https://github.com/JoniXDrama)  
[Tal Lovton](https://github.com/TalLovton)


## Planning
![מיין טייבל1](https://github.com/zigelnik/Scrabble/assets/78549129/e961195d-bee7-4f43-9ea9-663e36040025)
![מיין טייבל2](https://github.com/zigelnik/Scrabble/assets/78549129/6fafbfbd-e601-4ac4-9552-c75d38fcb586)
![אבן דרך 1](https://github.com/zigelnik/Scrabble/assets/78549129/7008025f-8689-4742-b64c-e6b8cb39555b)
![אבן דרך 2+3](https://github.com/zigelnik/Scrabble/assets/78549129/21318e2e-d78b-43ed-96cf-07fa6ec7e54e)




## Usage

**Host Mode**
In Host mode, the player starts a new game and waits for other players to join.
Start the application and select the Host mode.
Enter a username and a port number.
Click on the "Start Game" button to start the game.
Wait for other players to connect to your server.

**Guest Mode**
In Guest mode, the player joins an existing game hosted by another player.
Start the application and select the Guest mode.
Enter a username, a server IP address, and a port number.
Click on the "Join Game" button to join the game.

## Playing the Game
Once the game has started and the players have joined, the game board will be displayed in the center of the window. Each player will have a row of tiles at the bottom of the window representing their hand.
To make a move, the player can select a tile from their hand and then click on an empty cell on the board to place the tile on the board. The player can also select a cell on the board that has a tile and then click on the player's hand to swap the tile on the board with a tile from the player's hand.
The game ends when a player has used all of their tiles or when there are no more valid moves left on the board. The player with the highest score at the end of the game wins.

## Project Structure
The project is structured using the MVVM architecture and Observer-Observable design pattern. The purpose of this architecture is to separate the user interface from the underlying data model, making the code easier to read, maintain, and extend. The project is divided into three main packages:

**Model**: Contains the data model classes for the game, including the Scrabble board, tiles, and players. The classes in this package are responsible for the game's logic and state.

**View**: Contains the JavaFX view classes for the game, including the game board, player tiles, and game window. The classes in this package are responsible for displaying the game's user interface and handling user input.

**ViewModel**: Contains the view model classes for the game, which handle the game logic and communication between the model and view. The classes in this package act as intermediaries between the model and view, responding to user input and updating the view accordingly.


