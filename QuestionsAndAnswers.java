import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class QuestionsAndAnswers {

    private ArrayList <String> quizstuff = new ArrayList<>();
    private ArrayList <Integer> randos = new ArrayList<>();
    private String [] QandA = new String[5];
    private int correctCounter = 0;
    private ArrayList <String> usedQuestions = new ArrayList<>();
    private int questionCounter = 0;


    public void randomizer(){
        quizstuff.clear();
        randos.clear();
        randos.add(1);
        randos.add(2);
        randos.add(3);
        randos.add(4);

        try
        {
            File dataset = new File("QA.csv");
            Scanner input = new Scanner(dataset);

            while (input.hasNextLine())
            {
                String info = input.nextLine();
                quizstuff.add(info);
            }

        input.close();

        }
        
        catch (IOException e)
        {
            System.out.println("IO Exception!");
        }

        Collections.shuffle(quizstuff);
        Collections.shuffle(randos);

        for (int i = 0; i<5; i++)
         {
            QandA = quizstuff.get(i).split(",");
         }


    }

    public String getQuestion(){
        return QandA[0];
    }

    public String getAnswer1(){
        return QandA[randos.get(0)];
    }

    public String getAnswer2(){
        return QandA[randos.get(1)];
    }

    public String getAnswer3(){
        return QandA[randos.get(2)];
    }

    public String getAnswer4(){
        return QandA[randos.get(3)];
    }

    public String getCorrectAnswer(){
        return QandA[1];
    }

    public void addToCorrect(){
        correctCounter++;
    }

    public int getCounter(){
        return correctCounter;
    }

    public void addToQuestionCounter(){
        questionCounter++;
    }

    public int getQuestionCounter(){
        return questionCounter;
    }

    public void usedUP(String quesion){
        usedQuestions.add(quesion);
    }

    public boolean wasUsed(String question){ 
        int usedcounter = 0;
        for(int i = 0; i<usedQuestions.size(); i++){
            if(question.equals(usedQuestions.get(i)))
            {
                usedcounter++;
            }
        }

        return usedcounter>0;
    }



        
      

}
