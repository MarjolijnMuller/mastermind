package mastermind;
import java.io.BufferedWriter;

public class game{
    public int lengthOfCode;

    public game(int length){
        lengthOfCode = length;
    }

    String code;

    public void setCode (int length){
        String letters = "abcdef";

        StringBuffer randomString = new StringBuffer(length);
        Random random = new Random();

        for (int i=0; i<length; i++){
            int randomIndex = random.nextInt(letters.length());
            char randomChar = letters.charAt(randomIndex);
            randomString.append(randomChar);
        }
        System.out.println(randomString.toString());
        code = randomString.toString();
    }

    public String getCode(){
        return code;
    }

    String userNum;

    //invoer code van de player
    public void userCode(){
        Scanner sc = new Scanner(System.in);
        userNum = sc.newLine();
        System.out.println(userNum);
    }

    Boolean[] done = new Boolean [4];

    public boolean correctCodeCheck(){
        boolean correctCode=false;
        if (userNum.equals(code)){
            done[0]=true;
            done[1]=true;
            done[2]=true;
            done[3]=true;
            correctCode=true
        }
        return correctCode;
    }

    //exit programma
    public void exitProgram(){
        if (userNum.equals("q")){
            System.out.println("exit...");
            System.exit(0);
        }
    }


    //de player voert een code in en deze wordt vergeleken met de methode setCode
    public void codeChecken(){
        char userNum1 = userNum.charAt(0);
        char userNum2 = userNum.charAt(1);
        char userNum3 = userNum.charAt(2);
        char userNum4 = userNum.charAt(3);

        int correct = 0;
        int wrongLocation = 0;

        if (!userNum.equals(code)){
            Arrays.fill(done, Boolean.FALSE);
            for (int j=0; j<4; j++){
                while (userNum.charAt(j)==(code.charAt(j))){
                    correct++;
                    done[j]=true;
                    break;
                }
                while (userNum1==code.charAt(j) && !done[j]){
                    done[j]=true;
                    wrongLocation++;
                    break;
                }
                while (userNum2==code.charAt(j) && !done[j]){
                    done[j]=true;
                    wrongLocation++;
                    break;
                }
                while (userNum3==code.charAt(j) && !done[j]){
                    done[j]=true;
                    wrongLocation++;
                    break;
                }
                while (userNum4==code.charAt(j) && !done[j]){
                    done[j]=true;
                    wrongLocation++;
                    break;
                }
            }
            for (int j=0; j<correct; j++){
                System.out.print("+");
            }
            for (int j=0; j<wrongLocation; j++){
                System.out.print("?");
            }
        System.out.println("");
        }
    }

    public static void file(){
        File log = new File("saveMastermind.txt");

        try{
            if(!log.exists()){
                System.out.println("We had to make a new file.");
                log.createNewFile();
            }
        FileWriter fileWriter = new FileWriter(log, true);

        BufferedWriter bufferedWriter - new BufferedWriter(fileWriter);
        bufferedWriter.close();

        System.out.println("File found");
        }catch(IOException e){
            System.out.println("COULD NOT LOG!");
        }
    }
}
