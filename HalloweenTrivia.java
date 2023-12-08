import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.nio.file.Paths;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class HalloweenTrivia extends Application{
    
    public static void main(String [] args){
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {

        
        primaryStage.setTitle("Halloween Trivia");
        Button btn1 = new Button();
        Button btn2 = new Button();
        Button btn3 = new Button();
        Button btn4 = new Button();
        Button next = new Button();
        
    
        
        GridPane root = new GridPane();
        root.setPadding(new Insets(10,10,10,200));
        root.setAlignment(Pos.CENTER_LEFT);
        root.setVgap(60);
        root.setHgap(60);
        
        

        root.setStyle("-fx-background-image: url(mike.png)");

        Text question = new Text("");
        question.setFont(Font.font("Cinzel",FontWeight.BOLD,FontPosture.ITALIC,26));
        question.setFill(Color.LIME);
        GridPane.setConstraints(question, 0, 0);
        root.getChildren().add(question);

        btn1.setText("");
        GridPane.setConstraints(btn1, 0, 1);
        root.getChildren().add(btn1);
        btn2.setText("");
        GridPane.setConstraints(btn2, 0, 2);
        root.getChildren().add(btn2);
        btn3.setText("");
        GridPane.setConstraints(btn3, 0, 3);
        root.getChildren().add(btn3);
        btn4.setText("");
        GridPane.setConstraints(btn4, 0, 4);
        root.getChildren().add(btn4);

        btn1.setTextFill(Color.LIME);
        btn1.setFont(Font.font("Cinzel",FontWeight.BOLD,FontPosture.ITALIC,20));
        btn1.setBackground(Background.EMPTY);
        btn2.setTextFill(Color.LIME);
        btn2.setFont(Font.font("Cinzel",FontWeight.BOLD,FontPosture.ITALIC,20));
        btn2.setBackground(Background.EMPTY);
        btn3.setTextFill(Color.LIME);
        btn3.setFont(Font.font("Cinzel",FontWeight.BOLD,FontPosture.ITALIC,20));
        btn3.setBackground(Background.EMPTY);
        btn4.setTextFill(Color.LIME);
        btn4.setFont(Font.font("Cinzel",FontWeight.BOLD,FontPosture.ITALIC,20));
        btn4.setBackground(Background.EMPTY);
        next.setTextFill(Color.HOTPINK);
        next.setFont(Font.font("Cinzel",FontWeight.BOLD,FontPosture.ITALIC,20));
        next.setBackground(Background.EMPTY);

        
        btn1.setOnMouseEntered(e -> {btn1.setCursor(Cursor.HAND); btn1.setTextFill(Color.LIGHTBLUE);});
        btn1.setOnMouseExited(e -> {btn1.setCursor(Cursor.DEFAULT);btn1.setTextFill(Color.LIME);});
        btn2.setOnMouseEntered(e -> {btn2.setCursor(Cursor.HAND);btn2.setTextFill(Color.LIGHTBLUE);});
        btn2.setOnMouseExited(e -> {btn2.setCursor(Cursor.DEFAULT);btn2.setTextFill(Color.LIME);});
        btn3.setOnMouseEntered(e -> {btn3.setCursor(Cursor.HAND);btn3.setTextFill(Color.LIGHTBLUE);});
        btn3.setOnMouseExited(e -> {btn3.setCursor(Cursor.DEFAULT);btn3.setTextFill(Color.LIME);});
        btn4.setOnMouseEntered(e -> {btn4.setCursor(Cursor.HAND);btn4.setTextFill(Color.LIGHTBLUE);});
        btn4.setOnMouseExited(e -> {btn4.setCursor(Cursor.DEFAULT);btn4.setTextFill(Color.LIME);});
        next.setOnMouseEntered(e -> {next.setCursor(Cursor.HAND);next.setTextFill(Color.LIGHTBLUE);});
        next.setOnMouseExited(e -> {next.setCursor(Cursor.DEFAULT);next.setTextFill(Color.HOTPINK);});
        

        primaryStage.setFullScreen(true);

        Text response = new Text("");
        response.setFont(Font.font("Cinzel",FontWeight.BOLD,FontPosture.ITALIC,26));
        response.setFill(Color.LIME);
        GridPane.setConstraints(response, 0, 5);
        root.getChildren().add(response);

        QuestionsAndAnswers QA = new QuestionsAndAnswers();
            
            QA.randomizer();
            question.setText(QA.getQuestion());
            QA.addToQuestionCounter();
            QA.usedUP(QA.getQuestion());
            btn1.setText(QA.getAnswer1());
            btn2.setText(QA.getAnswer2());
            btn3.setText(QA.getAnswer3());
            btn4.setText(QA.getAnswer4());
        


        Image image = new Image("correct.JPG");
        Image image1 = new Image("wronh.GIF");
        
        ImageView imageView = new ImageView();
        //imageView.setImage(image);
        imageView.setPreserveRatio(false);
        GridPane.setConstraints(imageView,0,6);
        imageView.setFitHeight(200);
        imageView.setFitWidth(200);

        next.setText("NEXT");
        GridPane.setConstraints(next, 0, 7);

        MediaPlayer media;
        String s = "Halloween.mp3";
        Media m = new Media(Paths.get(s).toUri().toString());
        media = new MediaPlayer(m);
        media.setCycleCount(MediaPlayer.INDEFINITE);
        media.play();
                
        primaryStage.setScene (new Scene(root, 600, 600));
        primaryStage.show(); 

        
        btn1.setOnAction(new EventHandler<ActionEvent>(){
            
            @Override 
                public void handle(ActionEvent event)        
                {
                    if (btn1.getText().equalsIgnoreCase(QA.getCorrectAnswer())) 
                    {
                        response.setText("That is correct!");

                        QA.addToCorrect();
                        question.setText("");
                        root.getChildren().remove(imageView);
                        imageView.setImage(image);
                        root.getChildren().add(imageView);
                        root.getChildren().add(next);
                        root.getChildren().remove(btn1);
                        root.getChildren().remove(btn2);
                        root.getChildren().remove(btn3);
                        root.getChildren().remove(btn4);
                        System.out.println("You're on a roll! " + QA.getCounter() + " correct so far");
                    }

                    else
                    {
                        response.setText("Sorry, incorrect");
                        question.setText("");
                        root.getChildren().remove(imageView);
                        imageView.setImage(image1);
                        root.getChildren().add(imageView);
                        root.getChildren().add(next);
                        root.getChildren().remove(btn1);
                        root.getChildren().remove(btn2);
                        root.getChildren().remove(btn3);
                        root.getChildren().remove(btn4);
                    }
                }
            });       

            btn2.setOnAction(new EventHandler<ActionEvent>(){
            
                @Override
                    public void handle(ActionEvent event)
                    {
                        if (btn2.getText().equalsIgnoreCase(QA.getCorrectAnswer())) 
                        {
                            response.setText("That is correct!");
                            QA.addToCorrect();
                            question.setText("");
                            root.getChildren().remove(imageView);
                            imageView.setImage(image);
                            root.getChildren().add(imageView);
                            root.getChildren().add(next);
                            root.getChildren().remove(btn1);
                            root.getChildren().remove(btn2);
                            root.getChildren().remove(btn3);
                            root.getChildren().remove(btn4);
                            System.out.println("You're on a roll! " + QA.getCounter() + " correct so far");
                        }
                        
                        else{
                            response.setText("Sorry, incorrect");
                            question.setText("");
                            root.getChildren().remove(imageView);
                            imageView.setImage(image1);
                            root.getChildren().add(imageView);
                            root.getChildren().add(next);
                            root.getChildren().remove(btn1);
                            root.getChildren().remove(btn2);
                            root.getChildren().remove(btn3);
                            root.getChildren().remove(btn4);
                            
                        }
                    }});

            btn3.setOnAction(new EventHandler<ActionEvent>(){
            
                @Override
                    public void handle(ActionEvent event)
                    {
                        if (btn3.getText().equalsIgnoreCase(QA.getCorrectAnswer())) 
                        {
                            response.setText("That is correct!");
                            question.setText("");
                            QA.addToCorrect();
                            root.getChildren().remove(imageView);
                            imageView.setImage(image);
                            root.getChildren().add(imageView);
                            root.getChildren().add(next);
                            root.getChildren().remove(btn1);
                            root.getChildren().remove(btn2);
                            root.getChildren().remove(btn3);
                            root.getChildren().remove(btn4);
                            System.out.println("You're on a roll! " + QA.getCounter() + " correct so far");
                        }
                        
                        else
                        {
                            response.setText("Sorry, incorrect");
                            question.setText("");
                            root.getChildren().remove(imageView);
                            imageView.setImage(image1);
                            root.getChildren().add(imageView);
                            root.getChildren().add(next);
                            root.getChildren().remove(btn1);
                            root.getChildren().remove(btn2);
                            root.getChildren().remove(btn3);
                            root.getChildren().remove(btn4);
                        }
                    }
                });

            btn4.setOnAction(new EventHandler<ActionEvent>(){
            
                @Override
                    public void handle(ActionEvent event)
                    {
                        if (btn4.getText().equalsIgnoreCase(QA.getCorrectAnswer())) 
                        {
                            response.setText("That is correct!");
                            question.setText("");
                            QA.addToCorrect();
                            root.getChildren().remove(imageView);
                            imageView.setImage(image);
                            root.getChildren().add(imageView);
                            root.getChildren().add(next);
                            root.getChildren().remove(btn1);
                            root.getChildren().remove(btn2);
                            root.getChildren().remove(btn3);
                            root.getChildren().remove(btn4);
                            System.out.println("You're on a roll! " + QA.getCounter() + " correct so far");
                        }
                        
                        else
                        {
                            response.setText("Sorry, incorrect");
                            question.setText("");
                            root.getChildren().remove(imageView);
                            imageView.setImage(image1);
                            root.getChildren().add(imageView);
                            root.getChildren().add(next);
                            root.getChildren().remove(btn1);
                            root.getChildren().remove(btn2);
                            root.getChildren().remove(btn3);
                            root.getChildren().remove(btn4);
                        }
                    }
                });

            next.setOnAction(new EventHandler<ActionEvent>(){
                    
                @Override
                    
                    public void handle(ActionEvent event)
                    {   
                        if(QA.getQuestionCounter() == 5){
                            //You have to increment your question counter for this to work

                            root.getChildren().remove(next);
                            root.getChildren().remove(btn1);
                            root.getChildren().remove(btn2);
                            root.getChildren().remove(btn3);
                            root.getChildren().remove(btn4);
                            root.getChildren().remove(imageView);
                            response.setText("You got " + QA.getCounter() + " correct!");
                            question.setText("GAME OVER");


                        }
                        else{
                        
                        QA.randomizer();
                        QA.wasUsed(QA.getQuestion());
                        while(QA.wasUsed(QA.getQuestion()) == true){
                            QA.randomizer();
                        }
                        question.setText(QA.getQuestion());
                        QA.addToQuestionCounter();
                        QA.usedUP(QA.getQuestion());
                        btn1.setText(QA.getAnswer1());
                        btn2.setText(QA.getAnswer2());
                        btn3.setText(QA.getAnswer3());
                        btn4.setText(QA.getAnswer4());
                        root.getChildren().remove(imageView);
                        response.setText(" ");
                        root.getChildren().remove(next);
                        root.getChildren().add(btn1);
                        root.getChildren().add(btn2);
                        root.getChildren().add(btn3);
                        root.getChildren().add(btn4);
                        }
                    }
                });



}
}