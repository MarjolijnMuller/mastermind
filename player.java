package mastermind;
import java.io.BufferedWriter;

public class player {
    String name;
    int numberOfCorrectCodes;
    int totalPoints;
    int totalWon;
    int totalGamesPlayed;
    int pointsInThisGame;
    int finalPointsOfTheGame;

    static ArrayList<player> allplayers = new ArrayList<player>();

    public player(String nm){
        name = nm;
        numberOfCorrectCodes=0;
        totalPoints=0;
        totalWon=0;
        totalGamesPlayed=0;
        pointsInThisGame=0;
        finalPointsOfTheGame=0;
        allplayers.add(this);
    }

    public player(String nm, int nocc, int tp, int tw, int tgp){
        name = nm;
        numberOfCorrectCodes=nocc;
        totalPoints = tp;
        totalWon = tw;
        totalGamesPlayed = tgp;
        allplayers.add(this);
    }

    public String getName(){
        return name;
    }

    public void displayName(){
        System.out.println(name);
    }

    public void addNumberOfCorrectCodes(){
        numberOfCorrectCodes++;
    }

    public void setTotalPoints(){
        totalPoints+=finalPointsOfTheGame;
    }

    public void addTotalWon(){
        totalWon++;
    }

    public void addTotalGamesPlayed(){
        totalGamesPlayed++;
    }

    public void addPointsInThisGame(){
        pointsInThisGame++;
    }

    public void resetPointsInThisGame(){
        pointsInThisGame=0;
    }

    public void setFinalPointsOfTheGame(){
        finalPointsOfTheGame=score;
    };

    public int getFinalPointsOfTheGame(){
        return finalPointsOfTheGame;
    }

    public void resetFinalPointsOfTheGame(){
        finalPointsOfTheGame=0;
    }

    public void info(String name){
        System.out.println(name + " heeft " + totalGamesPlayed + " spelletjes gespeeld en heeft hiervan " + totalWon + " gewonnen.\n" + 
        name + " heeft " + numberOfCorrectCodes + " codes opgelost en heeft hier in totaal: " + totalPoints " beurten voor nodig gehad.\n");
    }

    static void readAllPlayers(String filename){
        try{
            File myObj = new File(fileName);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()){
                String data = myReader.nextLine();

                Scanner myDataReader = new Scanner(data);
                myDataReader.useDelimiter("; ");
                String nm = myDataReader.next();
                int nocc = myDataReader.nextInt();
                int tp = myDataReader.nextInt();
                int tw = myDataReader.nextInt();
                int tgp = myDataReader.nextInt();

                new player(nm, nocc, tp, tw, tgp);
            }
            myReader.close();
        }catch (FileNotFoundException e){
        }
    }

    static player findPlayer(String nm){
        player np = null;
        for (int i=0; i<allplayers.size(); i++){
            if(allplayers.get(i).name.equals(nm)){
                np = allplayers.get(i);
                System.out.println("found player\n");
            }
        }
        if (np==null){
            np=new player(nm);
            System.out.println("create new player\n");
        }
        return np;
    }

    static void saveAllPlayers(String fileName){
        File log = new File(fileName);

        try{ 
            if(!log.exists()){
                System.out.println("We had to make a new file.");
                log.createNewFile();
            }
            FileWriter fileWriter = new FileWriter(log, false);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (int i=0; i<allplayers.size(); i++){
                bufferedWriter.write(allplayers.get(i).name + "; " +
                                     allplayers.get(i).numberOfCorrectCodes + ": " +
                                     allplayers.get(i).totalPoints + "; " +
                                     allplayers.get(i).totalWon + "; " +
                                     allplayers.get(i).totalGamesPlayed + "; ");
                bufferedWriter.close();

                System.out.println("Done");
            } catch(IOException e){
                System.out.println("COULD NOT LOG!");
            }
    }
}
