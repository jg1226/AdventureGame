# AdventureGame
All sprites belong to Nintendo.
Upon loading code you'll be set to a screen with nothing on it I was messing with my level array and had that on default by accident open the pack file select the window file and open game scroll down the init method and look for this line of code level.LoadImageLevel(level.getLevel(0)); change the 0 to 2 so it looks like this and it work fine level.LoadImageLevel(level.getLevel(2));
the main method is located in game.
Incomplete project use w,a,s,d to move and hit space bar to use your sword that enemy on the start screen is killable and the tile in the bottom right of the initial room with change the map other than that it has a bunch of random sprites placed outside for testing purposes.
The game generates maps based off rgb inputs from a customized image I created.
The code from this game mostly comes from a tutorial but I adjusted it to fit my own needs such as adding my own enemies, the sword and changing the game from a side scroller to a top down.
Some of the files are remnants from when it was a side scroller such as the bullet object.
