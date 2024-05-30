package mastermind;

import java.util.Scanner;
import java.util.ArrayList;

public class mastermind {
    game.file();
    player.readAllPlayers("saveMastermind.txt");

    System.out.println("Vul in hoeveel spelers er zijn.");
    Scanner sc = new Scanner(System.in);
    String aantalSpelers = sc.nextLine();
    int aSpelers = integer.parseInt(aantalSpelers);
    System.out.println(aSpelers + " spelers \n");

    ArrayList<player> actualPlayers = new ArrayList<player>();

    System.out.println("Vul de namen in van de spelers.");
    for (int i=0; i<aSpelers; i++){
        System.out.println("De naam van speler " + (i+1) + " is: ");
        String userName = sc.nextLine();
        player actualPlayer = player.findPlayer(userName);
        actualPlayers.add(actualPlayer);
    }

    //de lengte van de code wordt hier bepaald
    int lengthOfCode = 4;

    game Game = new game(lengthOfCode);

    //uitleg spel
    System.out.println("Je hebt zometeen 12 rondes om de code van 4 letters te raden.");
    System.out.println("Lukt het jou om de code te kraken? \n");

    //de game wordt gespeeld met het aantal spelers wat is aangegeven
    for (int i=0; i<aSpelers; i++){
        System.out.print("Start spel ");
        actualPlayers.get(i).displayName();
        actualPlayers.get(i).addTotalGamesPlayed();
        System.out.println("Voer 4 letters in. Kies uit a, b, c, d, e en f.");

        Game.setCode(lengthOfCode);
        Game.getCode();

        for (int j=1; j<=12; j++){
            actualPlayers.get(i)addPointsInThisGame();
            System.out.println("Ronde " + j + "\n");
            Game.userCode();
            Game.exitProgram();
            if (Game.correctCodeCheck()==true){
                System.out.println("Correct!");
                System.out.println("De correcte code was: " + Game.getCode() + "\n");
                actualPlayers.get(i).setFinalPointsOfTheGame(actualPlayers.get(i).pointsInThisGame);
                actualPlayer.get(i).addNumberOfCorrectCodes();
                break;
            } else {
                Game.codeChecken();
            }
            if (Game.correctCodeCheck()==false){
                actualPlayers.get(i).addPointsInThisGame();
                actualPlayers.get(i).setFinalPointsOfTheGame(actualPlayers.get(i).pointsInThisGame);
                System.out.println("Game over");
            }
        }

        int lowestScore=13;
        for (int=0; i<aSpelers; i++){
            int finalScore = actualPlayers.get(i).getFinalPointsOfTheGame();
            if (finalScore < lowestScore){
                lowestScore = fainalScore;
            }
        }

        for (int i=0; i<aSpelers; i++){
            actualPlayers.get(i).setTotalPoints();
            if (lowestScore==actualPlayers.get(i).getFinalPointsOfTheGame()){
                System.out.println(actualPlayers.get(i).getName() + " heeft gewonnen!");
                actualPlayers.get(i).addTotalWon();
                actualPlayers.get(i).resetFinalPointsOfTheGame();
                actualPlayers.get(i).resetPointsInThisGame();
            }
        }
        player.saveAllPlayers("saveMastermind.txt");

        System.out.println("Wil je de statestieken zien? Vul in ja of nee.");
        String statics = sc.nextLine();
        if (statics.equals("ja")){
            for (int i=0; i<aSpelers; i++){
                actualPlayers.get(i).Info(actualPlayers.get(i).getName());
            }
        }
    }
}
