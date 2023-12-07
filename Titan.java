import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Titan {
    public static void main(String[] args) {
        if (args.length != 0 && args[0].equals("-help")) {
            displayHelp();
            System.exit(0);
        }
        System.out.println("____");
        slowPrint("Meanwhile, far away in space...");
        System.out.print("");
        pause(2000);
        System.out.println("               .                                            .\n" +
                           "     *   .                  .              .        .   *          .\n" +
                           "  .         .                     .       .           .      .        .\n" +
                           "        o                             .                   .\n" +
                           "         .              .                  .           .\n" +
                           "          0     .\n" +
                           "           \\      .          .                 ,                ,    ,\n" +
                           " .          \\          .                         .\n" +
                           "      .      \\   ,\n" +
                           "   .          o     .                 .                   .            .\n" +
                           "     .         \\                 ,             .                .\n" +
                           "               # ## #      .                              .        .\n" +
                           "             #  #O## ###                .                        .\n" +
                           "   .        #*#  # ## ###                       .                     ,\n" +
                           "        .   ##*#  # ## ##               .                     .\n" +
                           "      .      ##*#  #o# ##         .                             ,       .\n" +
                           "          .     *#  ##     .                    .             .          ,\n" +
                           "                                .                         .\n" +
                           "____^/\\___^--____/\\____O______________/\\/\\---/\\___________---______________\n" +
                           "   /\\^   ^  ^    ^                  ^^ ^  '\\ ^          ^       ---\n" +
                           "         --           -            --  -      -         ---  __       ^\n" +
                           "   --  __                      ___--  ^  ^                         --  __");
        slowPrint("You: This doesnt look right...");
        pause(2000);
        System.out.println("");
        System.out.print("Enter your character name: ");

        Scanner input = new Scanner(System.in);
        String characterName = input.nextLine();
        int token = 0; 
        int attemptsLeft = 6;
        char pathNumber = 'M'; // keeps track of which path the player chooses.
        boolean diceToken = true; // this wil be used to track if the player has won the dice game
        boolean letterToken = true; // this wil be used to track if the player has won the letter game
        boolean copyToken = true;// this wil be used to track if the player has won the copy cat game
        int tokenGrabber = 0; // used later in the code to keep track of when the player wins a recieves a token
        int slowPrintCounterDice = 0 ;
        int slowPrintCounterLetter = 0 ;
        int slowPrintCounterCopy = 0 ;


        while(attemptsLeft > 0 && (diceToken == true || letterToken == true || copyToken == true)) { // main game loop, makes sure all mingames haven't been beat
            tokenGrabber = 0; // resets the token to 0
            if(pathNumber == 'M') { // menu at the start of the game
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                slowPrint("Dorthy: Greetings, " + characterName + "!" + " Welcome to Titan!"
                        +"\n        Ahhh, I see you've landed on the wrong planet are lacking resources."
                        +"\n        Well don't worry about that, I could help!"
                        +"\n        Whoops, I forgot to introduce myself. "
                        +"\n        I'm Dorthy, a professional planet Titan guide." 
                        +"\n        I frequently assist players similar to yourself in gathering resources, "
                        +"\n        particularly those who find themselves on the wrong planet"
                        +"\n        But first, lets play some games. *evil laugh*"
                        +"\n        Here I have three games: Lucky Dice, Letter Guess, and Copy Cat."
                        +"\n        In order to proceed, you need to beat every one of my games, "
                        +"\n        however theres a catch."
                        +"\n        You will only be given a total of 6 attempts to beat them,"
                        +"\n        but once you've beat all of them, we will proceed." 
                        +"\n        After winning each game you be rewarded with a mysterious token.");
                System.out.println("");
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                System.out.println("Choose Your Game: (Input ONLY a Number)");
                System.out.println("1: LUCKY DICE");
                System.out.println("2: LETTER GUESS");
                System.out.println("3: COPY CAT");
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

                pathNumber = input.nextLine().charAt(0);
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            }
            else if(pathNumber == '0') {  // when user is finished with a minigame
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                System.out.println("Attempts left: " + attemptsLeft);
                System.out.println("You have " + token + " token/s.");
                System.out.println("Which game do you want to play? (next) ");
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                System.out.println("Choose Your Game: (Input ONLY a Number)");
                System.out.println("1: LUCKY DICE");
                System.out.println("2: LETTER GUESS");
                System.out.println("3: COPY CAT");    
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                pathNumber = input.nextLine().charAt(0);
            }
            else if(pathNumber == '1' & diceToken) { // path to dice game
                System.out.println("LUCKY DICE CHOSEN");
                tokenGrabber += diceGame(slowPrintCounterDice); // returns token if player wins //tokenGrabber turns into 1.
                token += tokenGrabber; // The player's token goes up by 1 because of the TokenGrabber variable
                if(tokenGrabber == 1) { // if the token grabber is one(player wins the minigame) then diceToken will be false, meaning you've beat the minigame so you cant select the 2nd path anymore.
                    diceToken = false;
                }
                attemptsLeft --;
                pathNumber = '0'; // takes you to path '0'
                slowPrintCounterDice ++;
                if(slowPrintCounterDice > 0) {
                    slowPrintCounterDice++;
                }
            }

            else if(pathNumber == '2' & letterToken) { // path to letter guess game
                System.out.println("LETTER GUESS CHOSEN");
                tokenGrabber += letterGuess(slowPrintCounterLetter); // returns token if player wins //tokenGrabber turns into 1.
                token += tokenGrabber; // The player's token goes up by 1 because of the TokenGrabber variable
                if(tokenGrabber == 1) { // if the token grabber is one(player wins the minigame) then diceToken will be false, meaning you've beat the minigame so you cant select the 1st path anymore.
                    letterToken = false;
                }
                attemptsLeft --;
                pathNumber = '0'; // takes you to path '0'
                slowPrintCounterLetter ++;
                if(slowPrintCounterLetter > 0) {
                    slowPrintCounterLetter++;
                }
            }
            else if(pathNumber == '3' && copyToken) { // path to Copy Cat game
                System.out.println("COPY CAT CHOSEN");
                tokenGrabber += copyCat(slowPrintCounterCopy); // returns token if player wins //tokenGrabber turns into 1.
                token += tokenGrabber; // The player's token goes up by 1 because of the TokenGrabber variable
                if(tokenGrabber == 1) { // if the token grabber is one(player wins the minigame) then diceToken will be false, meaning you've beat the minigame so you cant select the 1st path anymore.
                    copyToken = false;
                }
                attemptsLeft --;
                pathNumber = '0'; // takes you to path '0'
                slowPrintCounterCopy ++;
                if(slowPrintCounterCopy > 0) {
                    slowPrintCounterCopy++;
                }   
            }
            else {
                if((diceToken == false || letterToken == false || copyToken == false) && (pathNumber <= '3' && pathNumber >= 0)) {
                    System.out.println("\n ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                    slowPrint("Dorthy: You've already beat this game. Please choose another. ");
                    System.out.println("\n ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                    System.out.println("");
                }
                    else {
                        System.out.println("\n ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                        slowPrint("Dorthy: " + characterName +"! Can you even read?!? Only input these numbers: 1, 2, or 3");
                        System.out.println("\n ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                        System.out.println("");
                    }
                    pathNumber = '0';
                }
            }
        
        while(true) { // boss fight game loop
            if(token >= 3) { // good ending
                int trueWinEnding = bossBattle();
                if(trueWinEnding == 1) {
                    System.out.println("\n ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                    slowPrint("Dorthy: You beat the monster " + characterName +"!"
                            +"\n        And it looks like you have 3 tokens"
                            +"\n        to help you get the resources you need to go back home. "
                            +"\n        I'll provide the ship.");
                    System.out.println("\n ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                    System.out.println("");
                    System.out.println("                                       _,'/" +
                           "\n                                  _.-''._:" +
                           "\n                          ,-:`-.-'    .:.|" +
                           "\n                         ;-.''       .::.|" +
                           "\n          _..------.._  / (:.       .:::.|" +
                           "\n       ,'.   .. . .  .`/  : :.     .::::.|" +
                           "\n     ,'. .    .  .   ./    \\ ::. .::::::.|" +
                           "\n   ,'. .  .    .   . /      `.,,::::::::.;\\" +
                           "\n  /  .            . /       ,',';_::::::,:_:" +
                           "\n / . .  .   .      /      ,',','::`--'':;._;" +
                           "\n: .             . /     ,',',':::::::_:'_,''" +
                           "\n|..  .   .   .   /    ,',','::::::_:'_,'' " +
                           "\n|.              /,-. /,',':::::_:'_,''    " +
                           "\n| ..    .    . /) /-:/,'::::_:',-'       " +
                           "\n: . .     .   // / ,'):::_:',' ;          " +
                           "\n \\ .   .     // /,' /,-.','  ./           " +
                           "\n  \\ . .  `::./,// ,'' ,'   . /            " +
                           "\n   `. .   . `;;;,/_.'' . . ,'" +
                           "\n    ,`. .   :;;' `:.  .  ,'" +
                           "\n   /   `-._,'  ..  ` _.-'" +
                           "\n  (     _,'``------''  " +
                           "\n   `--''");
                    slowPrint("System: You are leaving planet Titan...");
                    System.out.println("");
                    break;
                }
                else {
                    break;
                }
            }
            else { // bad ending
                int trueLoseEnding = bossBattle();
                if(trueLoseEnding == 1) {
                    System.out.println("\n ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                    slowPrint("Dorthy: You beat the monster!  " + characterName + "! However, you didnt beat my games so you don't have enough tokens. Unfortunately, I must leave you here. I got more business to take care of.");
                    System.out.println("\n ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                    System.out.println("");
                }
                else {
                    break;
                }
            }
            break;
        }
    }

    public static int diceGame(int slowPrintCounterDice) {
        Scanner input = new Scanner(System.in);
        if(slowPrintCounterDice > 0) { // makes it so the user doesnt have to sit and wait on the slow print once they've already sat through the first slow print
            System.out.println("\n ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");  
            System.out.println("Dorthy: Okay so here are the rules."
                        +"\n             I have a deck of cards that have numbers from 1-100."
                        +"\n             I will shuffle and grab a random card from the deck."
                        +"\n             Each of us will have a pair of dice"
                        +"\n             and must roll them to get as close as possible to the number of the card"
                        +"\n             But here's the twist *evil laugh.*"
                        +"\n             We won't know what the number is until we both choose to stop rolling."
                        +"\n             The closest one wins." 
                        +"\n             If we tie, then you will be given a bonus token for being so lucky! "
                        +"\n             Oh, I forgot to mention, You will be able to see half of my rolls."
                        +"\n             LET THE GAMES BEGIN!");
            System.out.println("\n ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("");
        }
        else { // makes it so the very first time the playr must sit through the slow print
            System.out.println("\n ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            slowPrint("Dorthy: Okay so here are the rules."
                    +"\n        I have a deck of cards that have numbers from 1-100."
                    +"\n        I will shuffle and grab a random card from the deck."
                    +"\n        Each of us will have a pair of dice" 
                    +"\n        and must roll them to get as close as possible to the number of the card"
                    +"\n        But here's the twist *evil laugh.*"
                    +"\n        We won't know what the number is until we both choose to stop rolling."
                    +"\n        The closest one wins." 
                    +"\n        If we tie, then you will be given a bonus token for being so lucky! "
                    +"\n        Oh, I forgot to mention, You will be able to see half of my rolls."
                    +"\n        LET THE GAMES BEGIN!");
            System.out.println("\n ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("");
        }
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("System: Type \"Y\" to roll dice and \"N\" to stop rolling.");
        int answer = (int)(Math.random() * 101 + 1); // answer will be generated from 1-100
        int playerTotal = 0; // total number the player rolls
        int cpuTotal = 0; // total number the cpu rolls
        int numOfCPURollTimes = (int)(Math.random() * 13 + 2); // cpu can roll from 1 - 13 times.
        int timeRolled = 0; // will increase every time cpu has rolled
        int token = 0; 

        while(true) {
            if(timeRolled > 0) {
                System.out.println("Roll again? [Y/N]");
            }
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            char determineRoll = input.nextLine().toUpperCase().charAt(0); 
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

            if(determineRoll == 'Y') {
                int playerRoll = playerRoll(); // calls the player roll method and gets whatever the player rolls
                playerTotal += playerRoll;
                if(timeRolled <= numOfCPURollTimes) { // keeps track of total cpu rolls
                    int cpuRoll = cpuRoll(); // calls the cpu roll method and gets whatever the cpu rolls
                    cpuTotal += cpuRoll; // keeps track of cpu total
                    if(timeRolled <= (numOfCPURollTimes / 2)) { // makes it so player can see half of the cpu rolls
                        System.out.println("Player             |  DORTHY       ");
                        System.out.print("You rolled: " + playerRoll );
                        System.out.println("         "+"Dorthy rolled: " + cpuRoll);
                        System.out.print("Your total: " + playerTotal);
                        System.out.println("         "+"Dorty's total: " + cpuTotal);
                    }
                    else {
                        System.out.println("Player             |  DORTHY       ");
                        System.out.print("You rolled: " + playerRoll );
                        System.out.println("         *Dorthy rolled*");
                        System.out.println("Your total: " + playerTotal);
                    }
                    timeRolled++;
            }
                else { // if rolls are done, cpu stops rolling
                    System.out.println("Player             |  Dorthy       ");
                    System.out.print("You rolled: " + playerRoll );
                    System.out.println("         *Dorthy Stopped rolling*");
                    System.out.println("Your total: " + playerTotal);
                }
  
            }
            else if (determineRoll == 'N') { // once player decides to stop, the total from both cpu and player is calculated
                if(playerTotal == 0) { // checks if "n" is typed at the start of the game. if it is then the game tells you to type "Y" and loops
                    System.out.println("You must roll at least once. Type \"Y\"");
                    continue;
                }
                while(timeRolled <= numOfCPURollTimes) { // this while loop will make it so that the cpu keeps rolling if it has any rolls left once the player decides to not roll
                    int cpuRoll = cpuRoll(); // calls the cpu roll method and gets whatever the cpu rolls
                    cpuTotal += cpuRoll;
                    if(timeRolled <= (numOfCPURollTimes / 2)) { // makes it so player can see half of the cpu rolls
                        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                        System.out.println("Player                 |  Dorthy       ");
                        System.out.print("*You stopped rolling* ");
                        System.out.println("   "+"Dorthy rolled: " + cpuRoll);
                        System.out.print("Your total: " + playerTotal); 
                        System.out.println("         "+"Dorthy's total: " + cpuTotal);                   

                    }
                    else {
                        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                        System.out.println("Player                 |  Dorthy       ");
                        System.out.print("*You stopped rolling* ");
                        System.out.println("   *Dorthy rolled*");
                        System.out.println("Your total: " + playerTotal); 
                    }
                   timeRolled++;
                }               
                
                int finalPlayerNum = playerTotal; // gets final total of player
                int finalCpuNum = cpuTotal; // gets final total of cpu
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                System.out.println("Player's total: " + playerTotal);
                System.out.println("Dorthy's total: " + cpuTotal);
                String winner = determinWinner(answer, finalPlayerNum, finalCpuNum); // determines winnner
                System.out.println("The number was: " + answer);
                System.out.println(winner);
                token += getToken(answer, finalPlayerNum, finalCpuNum); 
                pause(2000);
                break;

            }
            else {
                if(playerTotal == 0) { // checks if "n" is typed at the start of the game. if it is then the game tells you to type "Y" and loops
                    System.out.println("You must roll at least once. Type \"Y\"");
                    continue;
                }
                else if(playerTotal != 0) {
                    System.out.println("Please type \"Y\" or \"N\"");
                    continue;
                }
            }
        }
        return token;
    }

    public static int letterGuess(int slowPrintCounterLetter) {
    Scanner input = new Scanner(System.in);
    int token = 0;
    String[] words = {"ORBIT","COINS","SCORE","BONUS","SKILL","TOKEN","PRIZE", "QUEST","SPACE","COMET","TITAN","FLOAT","PLUTO","NIGHT","EARTH","STARS","ALIEN","SOLAR","VENUS","LUNAR","COSMO"}; // list of words
    String answer = words[(int)(Math.random() * 21)]; // randomly chooses a word from list

    String colorString = ""; // later used to change text color
    boolean win = false;
    if(slowPrintCounterLetter > 0) { // makes it so the user doesnt have to sit and wait on the slow print once they've already sat through the first slow print
        System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");           
        System.out.println("Dorthy: The rules for this game are simple (and completely original)."
                        +"\n         I will think of a random word in my head and"
                        +"\n         you must guess what that word is."
                        +"\n         I will give you a total of 5 attempts only."
                        +"\n         If you guess the word within those attempts then you win a mystery token!"
                        +"\n         Once you type a 5 letter word then I will let you know if you're correct."
                        +"\n         If you guess a letter in the correct spot than that letter will be green."
                        +"\n         If you guess a letter correctly but in the wrong spot "
                        +"\n         than the letter will turn yellow."
                        +"\n         And lastly, if you guess a letter completely wrong than it will turn red." 
                        +"\n         GOOD LUCK! You may start whenever you're ready.");
        System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        }
        else { // makes it so the very first time the playr must sit through the slow print
            System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            slowPrint("Dorthy: The rules for this game are simple (and completely original)."
                        +"\n    I will think of a random word in my head and"
                        +"\n    you must guess what that word is."
                        +"\n    I will give you a total of 5 attempts only."
                        +"\n    If you guess the word within those attempts then you win a mystery token!"
                        +"\n    Once you type a 5 letter word then I will let you know if you're correct." 
                        +"\n    If you guess a letter in the correct spot than that letter will be green."
                        +"\n    If you guess a letter correctly but in the wrong spot "
                        +"\n    than the letter will turn yellow."
                        +"\n    And lastly, if you guess a letter completely wrong than it will turn red." 
                        +"\n    GOOD LUCK! You may start whenever you're ready.");
            System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("");
            System.out.println("System: Enter a 5 letter word.");
        }

        for(int numOfLifes = 5; numOfLifes > 0 && !win;) { // runs only if player still has lives left and hasnt won
            String guess = input.next().toUpperCase();
                if(guess.length() == 5) {} // makes sure the user inputs 5 letter word, if not it skips the whole prgram and asks again.
                    else {
                        System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                        System.out.println("Dorthy: Please enter a 5 letter word. ");
                        continue;
                    }
                for(int i = 0; i <= answer.length() -1; i++ ) { // runs a loop depending on how long the word is (5 times) 
                    char g = guess.charAt(i);
                    char a = answer.charAt(i);

                    if(g == a) {
                        colorString +=  "\u001B[32m" + guess.charAt(i) + "\u001B[0m"; // Turns letter green if  words match
                    }
                    else if(answer.contains(Character.toString(g))) {
                        colorString +=  "\u001B[33m" + guess.charAt(i) + "\u001B[0m"; // turns letter yellow if letter is correct but in wrong place
                    }
                    else {
                        colorString +=  "\u001B[31m" + guess.charAt(i) + "\u001B[0m"; // turns letter red of words dont match
                    }
                }
                System.out.println(colorString); // prints out your guess but with color
                colorString = ""; // resets string
                if(guess.equals(answer)) { // if player guesses the word, game ends. win is true.
                    win = true;
                }
                else if(!guess.equals(answer)) { // if player hasnt guessed it right, number of lives is decresed, game continues. (as long as theyre lives left)
                    numOfLifes--;
                    System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                    System.out.println("Dorthy: Not quite. You have " + numOfLifes + " attempt/s");
                }
            }
            if(win) {
                System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                System.out.println("Dorthy: You Win!");
                token++;
            }
            else { // if no more lives then it tells you what the word was, you lose.
                System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                System.out.println("Dorthy: The word was: " + answer);
                System.out.println("Dorthy: Better luck next time.");
            }   
            return token;
}

    // methods for dice game.
    public static int playerRoll() { // rolls two dices for the player and returns the sum of them 
        int dice1 = (int)(Math.random() * 6 + 1);
        int dice2 = (int)(Math.random() * 6 + 1);
        return dice1 + dice2;
    }

    public static int cpuRoll() { // rolls two dices for the cpu and returns the sum of them
        int dice1 = (int)(Math.random() * 6 + 1);
        int dice2 = (int)(Math.random() * 6 + 1);
        return dice1 + dice2;
    }

    public static String determinWinner(int target, int player, int cpu) { // finds the closest number to the answer and then returns a string based on who won.
        String winner = "";
        int diff1 = Math.abs(target - player);
        int diff2 = Math.abs(target - cpu);

        if(diff1 < diff2) { // if player is closer then cpu
            winner = "Dorthy: You win! You earned a token.";
        }
        else if(diff1 > diff2) { // if cpu is closer than player
            winner = "Dorthy: I Win! No token for you.";
        }
        else if(diff1 == diff2) { // if player and cpu tie
            winner = "Dorthy: Tie! You earn an extra token for being so lucky.";
        }
        return winner;
    }

    public static int getToken(int target, int player, int cpu) { // finds the closest number to the answer and then returns a string based on who won.
        int token = 0;
        int diff1 = Math.abs(target - player);
        int diff2 = Math.abs(target - cpu);

        if(diff1 < diff2) { // if player is closer then cpu
            token = 1;
        }
        else if(diff1 > diff2) { // if cpu is closer than player
            token = 0;
        }
        else if(diff1 == diff2) { // uf player and cpu tie
            token = 2; // player gets a bonus con because this outcome is far miuch more rare
        }
        return token;
    }

    public static boolean diceBoolean(int token) {
        boolean b = true;
        if(token == 1) {
            return b;
        }
        else{
            return false;
        }
    }
 
    public static int copyCat(int slowPrintCounterCopy) {
        int points = 0;
        if(slowPrintCounterCopy > 0) { // makes it so the user doesnt have to sit and wait on the slow print once they've already sat through the first slow print
            System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");       
            System.out.println("Dorthy: Ooo Copy Cat, My Favorite! To beat this game, I will shout out a word."
                            +"\n         Your goal is to type that word as quickly as possible."
                            +"\n         You have 5 seconds to type the word and you must type it correctly."
                            +"\n         Once you typed the first word correctly the time will reset and"
                            +"\n         I will shout out another word, so you better be ready!"
                            +"\n         You will get a point for every word you get correct. "
                            +"\n         Once you earn 5 points, you will complete this game and earn a token."
                            +"\n         If you get the word wrong you must restart."
                            +"\n         In this game you only have 3 attempts. GOOD LUCK!");
            System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        }
        else { // makes it so the very first time the playr must sit through the slow print
            System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            slowPrint("Dorthy: Ooo Copy Cat, My Favorite! To beat this game, I will shout out a word."
                    +"\n        Your goal is to type that word as quickly as possible."
                    +"\n        You have 5 seconds to type the word and you must type it correctly."
                    +"\n        Once you typed the first word correctly the time will reset and"
                    +"\n        I will shout out another word, so you better be ready!"
                    +"\n        You will get a point for every word you get correct."
                    +"\n        Once you earn 5 points, you will complete this game and earn a token."
                    +"\n        If you get the word wrong you must restart."
                    +"\n        In this game you only have 3 attempts. GOOD LUCK!");
            System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("");
        }
       
        Scanner input = new Scanner(System.in);
        while (true) { // Asks the user to enter ready to start the game
            System.out.print("System: Type 'ready' to start: ");
            String userInput = input.nextLine().trim().toLowerCase();

            if (userInput.equalsIgnoreCase("ready")) { // Start the typing game when the user enters 'ready'
                points += playCopyCat(); //
                break; // Ends the loop
            } else { // Will keep asking until the user inputs ready
                System.out.println("Invalid input. Please type 'ready' to start.");
            }
        }
        return points;
    }

    // methods for copy cat game
    public static int collectPoints(int currentPoints) {
        // Method to handle points collection 
        currentPoints++;  // Increment the points count
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        slowPrint("Dorthy: Congratulations! You collected a mystery token!");
        System.out.println("");
        return currentPoints;  // Return the updated points count
    }

    public static int playCopyCat() {
        Scanner scanner = new Scanner(System.in);
        int token= 0;
        String[] words = {"apple", "banana", "orange", "grape", "mango", "strawberry", "kiwi", "pineapple", "peach"}; // Stored words

        int timeLimitInSeconds = 5; // Time set at 5 seconds
        int pointsToWin = 5; // Set the points required to win
        int maxChances = 3; // Maximum chances to play again

        int chancesLeft = maxChances; // Set the amount of chances to 4, but since the game starts, it's technically 3.

        while (chancesLeft > 0) { // Once the user uses their chance, it will restart their score and points.
            int score = 0; // Score will start at 0
            int points = 0; // Points will start at 0

            while (true) { // Endless loop, no playAgain feature
                String randomWord = words[(int) (Math.random() * words.length)]; // Randomly chooses a word from words string.
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                System.out.println("Your word is: " + randomWord); // Print the random word
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                System.out.println("You have " + timeLimitInSeconds + " seconds to type the word."); // Prints the time limit to the user.

                long startTime = System.currentTimeMillis(); // Start the timer 
                String userTypedWord = scanner.nextLine().trim().toLowerCase(); // Waiting for the user to type in the word and converting to lowercase
                long endTime = System.currentTimeMillis(); // Will end the timer 

                // User types the correct word & meets within the time limit.
                if (userTypedWord.equals(randomWord) && (endTime - startTime) < (timeLimitInSeconds * 1000)) {
                    System.out.println("Correct! You typed the word in time.");
                    score++;
                    System.out.println("Your current score: " + score);

                    // Users score is compared to points needed to win
                    if (score == pointsToWin) {
                        System.out.println("You reached 5 points. You win!");
                        token = collectPoints(points);  // Call the method to collect a points
                        chancesLeft = 0;
                        break;
                    }
                } else {
                    // User either types the incorrect word or does not type in time.
                    System.out.println("Incorrect or time exceeded. Game Over!");
                    System.out.println("Your score: " + score); // Displays the total score accumulated
                    break; // Exit the loop to end the game directly
                }
            }

            // Once the game ends, it will subtract from one of their 3 given chances.
            chancesLeft--;

            // Will ask the user to enter ready to try the level again
            while (chancesLeft > 0) {
                System.out.println("You have " + chancesLeft + " chances left.");
                System.out.println("Please enter 'ready' when you want to start again: ");
                String playAgain = scanner.nextLine().trim().toLowerCase();
                
                // Reset the game state.
                // Continue to the next iteration of the outer loop to restart the game
                if (playAgain.equals("ready")) {
                    break;
                } else {
                    System.out.println("Invalid input. Please enter 'ready' ");
                }
            }
        }
        return token;    
    }

    public static int bossBattle() {
        Scanner input = new Scanner(System.in);
        String fullChars = ""; // This gathers all the characters that the player can see and must match.
        int monsterHealth = 4;
        int numOfLifes = 5; // count will decrease everytime the player messes up, meanig they could only mess up 5 times or they lose.
        pause(2000);
        slowPrint("*LOUD ROARS*");
        System.out.println("");
        pause(2000);
        System.out.println("\n ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        slowPrint("Dorthy: ON NO, THE TITAN MONSTERS HAVE BEEN AWOKEN");
        System.out.println("\n ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("");
        pause(2000);
        System.out.println("            _.------.                        .----.__\r\n" + //
                "           /         \\_.       ._           /---.__  \\\r\n" + //
                "          |  O    O   |\\\\___  //|          /       `\\ |\r\n" + //
                "          |  .vvvvv.  | )   `(/ |         | o     o  \\|\r\n" + //
                "          /  |     |  |/      \\ |  /|   ./| .vvvvv.  |\\\r\n" + //
                "         /   `^^^^^'  / _   _  `|_ ||  / /| |     |  | \\\r\n" + //
                "       ./  /|         | O)  O   ) \\|| //' | `^vvvv'  |/\\\\\r\n" + //
                "      /   / |         \\        /  | | ~   \\          |  \\\\\r\n" + //
                "      \\  /  |        / \\ Y   /'   | \\     |          |   ~\r\n" + //
                "       `'   |  _     |  `._/' |   |  \\     7        /\r\n" + //
                "         _.-'-' `-'-'|  |`-._/   /    \\ _ /    .    |\r\n" + //
                "    __.-'            \\  \\   .   / \\_.  \\ -|_/\\/ `--.|_\r\n" + //
                " --'                  \\  \\ |   /    |  |              `-\r\n" + //
                "                       \\uU \\UU/     |  /   ");
        pause(1000);

        System.out.println("\n ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        slowPrint("Dorthy: No worries, I'm always prepared for situations like these."
                +"\n        In my bag I have a bombs that you can use to throw at the monster." 
                +"\n        The way it works is that once you click on a key or take too long"
                +"\n        a combination will be given for a short period of time."
                +"\n        You must memorize it and type into the correct code."
                +"\n        The combination will get harder and harder. Sounds pretty simple right?" 
                +"\n        Oh, make sure not to mess up five times though or we will explode too."
                +"\n        No pressure though, I know you got this.");
        System.out.println("\n ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("");

    while(numOfLifes > 0 && monsterHealth > 0) {
        System.out.println("\n ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        slowPrint("Dorthy: The monsters have a total of " + monsterHealth + " hp, while you have a total of " + numOfLifes + " attempts left.");
        System.out.println("\n ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println(""); 

        slowPrint("        Let's get ready!.");
        System.out.println(""); 
        System.out.println("System: Type \"start\" to begin.");
        String continueString = input.next();
        if(continueString.equalsIgnoreCase("start")) {
            for(int i = 0; i<1; i++) {
                if(monsterHealth == 4) { // This will display one letter when monster has 3 health left
                    char lowerLetter = (char)('a' + Math.random() * ('z' - 'a' + 1)); // get random character from a - z
                    char upperLetter = (char)('A' + Math.random() * ('Z' - 'A' + 1));  // get random character from A - Z
                    fullChars += upperLetter;
                    fullChars += lowerLetter;
                }
                if(monsterHealth == 3) {
                    char lowerLetter = (char)('a' + Math.random() * ('z' - 'a' + 1));  // get random character from a - z
                    char upperLetter = (char)('A' + Math.random() * ('Z' - 'A' + 1));  // get random character from A - Z
                    char num = (char)('1' + Math.random() * ('9' - '0'));  // get random character from 9 - 0
                    fullChars += upperLetter;
                    fullChars += lowerLetter;
                    fullChars += num;
                }
                if(monsterHealth == 2) {
                    char lowerLetter = (char)('a' + Math.random() * ('z' - 'a' + 1)); // get random character from A - Z
                    char upperLetter = (char)('A' + Math.random() * ('Z' - 'A' + 1));    // get random character from A - Z                   
                    char num = (char)('1' + Math.random() * ('9' - '0')); // get random character from A - Z
                    char symbol = (char)('!' + Math.random() * ('/' - '!')); // get random character from ! - /
                    fullChars += lowerLetter;
                    fullChars += upperLetter;
                    fullChars += num;
                    fullChars += symbol;
                }
                if (monsterHealth == 1) {
                    char lowerLetter = (char)('a' + Math.random() * ('z' - 'a' + 1)); // get random character from A - Z
                    char upperLetter = (char)('A' + Math.random() * ('Z' - 'A' + 1));    // get random character from A - Z                   
                    char num = (char)('1' + Math.random() * ('9' - '0')); // get random character from A - Z
                    char symbol = (char)('!' + Math.random() * ('/' - '!')); // get random character from ! - /
                    fullChars += upperLetter;
                    fullChars += symbol;
                    fullChars += num;
                    fullChars += lowerLetter;
                }
            }
            System.out.println(fullChars);
            pause(1500);
            for(int i =0; i <10000;i++) { // the purpose of this is to make it so that so many lines will be printed, in other words it makes it so that the word looks like they dissapeared.
                System.out.println("");
            }
            System.out.println("\n ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            slowPrint("Dorthy: HURRY! QUICKILY ENTER THE COMBINATION!");
            System.out.println("\n ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("");
            String attempt = input.next();
            if(attempt.equals(fullChars)) {
                System.out.println("\n ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                slowPrint("Dorthy: THATS IT! YOU HIT THE MONSTER!");
                System.out.println("\n ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                System.out.println("");
                fullChars = ""; // string resets
                monsterHealth--; // monster loses health
            }
            else {
                System.out.println("\n ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                slowPrint("Dorthy: NO NO NO! YOU MESSED UP THE COMBINATION!");
                System.out.println("\n ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                System.out.println("");
                fullChars = ""; // string resets
                numOfLifes--;// you loses health
            }
        }
        else {
            System.out.println("\n ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            slowPrint("Dorthy: HURRY! PRESS THE BUTTON!");
            System.out.println("\n ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("");
        }    
    }
        int monsterDeadEnding = 0; // keeps track of the different endings

    if(monsterHealth == 0) {
        monsterDeadEnding ++;
        System.out.println("                    The monster is dead!");
        pause(2000);
        System.out.println("     _.-^^---....,,--       \r\n" + //
                " _--                  --_  \r\n" + //
                "<                        >)\r\n" + //
                "|                         | \r\n" + //
                " \\._                   _./  \r\n" + //
                "    ```--. . , ; .--'''       \r\n" + //
                "          | |   |             \r\n" + //
                "       .-=||  | |=-.   \r\n" + //
                "       `-=#$%&%$#=-'   \r\n" + //
                "          | ;  :|     \r\n" + //
                " _____.,-#%&$@%#&#~,._____");     
        pause(1000);   
        return monsterDeadEnding;
    }
    else {
        monsterDeadEnding--;
        System.out.println("\n ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        slowPrint("Dorthy: ... is this the end?..");
        System.out.println("\n ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("");
        pause(2000);
        System.out.println("     _.-^^---....,,--       \r\n" + //
                " _--                  --_  \r\n" + //
                "<                        >)\r\n" + //
                "|                         | \r\n" + //
                " \\._                   _./  \r\n" + //
                "    ```--. . , ; .--'''       \r\n" + //
                "          | |   |             \r\n" + //
                "       .-=||  | |=-.   \r\n" + //
                "       `-=#$%&%$#=-'   \r\n" + //
                "          | ;  :|     \r\n" + //
                " _____.,-#%&$@%#&#~,._____");}  
        pause(1000);   
        return monsterDeadEnding;
    }

    public static void pause(long milliseconds) { // makes it so theres a pause in the game for the boss fight
        try {
          Thread.sleep(milliseconds);
        } catch (InterruptedException ie) {}
    }

    public static void slowPrint(String output) { // slow print
        for (int i = 0; i < output.length(); i++) {
            char c = output.charAt(i);
            System.out.print(c);
            try {
                TimeUnit.MILLISECONDS.sleep(25); //25
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public static void displayHelp() {
        System.out.println("Using java [-help]");
        System.out.println("This program will have 3 levels.");
        System.out.println("Level 1: Lucky Dice");
        System.out.println("How to play: The computer will randomly generate a number" +
                            "\nand your goal is to roll the dice till you feel you have"+
                            " reached the randomized number");
        System.out.println("This is a game of luck remember..."+
                            "Trust your gut!");
        System.out.println("");
        System.out.println("Level 2:Letter Guess");
        System.out.println("How to play: This is a typing game similar to wordle where you" +
                            " \nwill guess the randomized 5 letter word. There will be three colors," +
                            " \nGreen letters mean there is a match and its in the correct spot" +
                            " \nYellow means the letter is part of the word but in wrong place" +
                            " \nRed Means that letter is not in the 5 letter word.");
        System.out.println("Hints: Lookout for the color of the letters!");
        System.out.println("");
        System.out.println("Level 3:Copy Cat");
        System.out.println("How to play: This is a timed typing game where the computer" +
                            " \nwill generate a word to copy and the user must rewrite the word" +
                            " \nbefore the 5 seconds are up");
        System.out.println ("Hints: All words are fruits.. Yummy ^.x.^ ");
        System.out.println("");
        System.out.println("Final Level: Big Bosses");
        System.out.println("How to play: This will be the final level. For this game" +
                            " \nyou must destroy the bosses with bombs. Bombs can be unlocked by memorizing the randomized code" +
                            " \nAnd typing it exactly as was displayed. ");
        System.out.println ("Hints: Words are case sensitive! ");
} {
    
}
}
