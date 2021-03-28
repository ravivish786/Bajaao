/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bajaao;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author VICKY
 */
public class Bajaao extends Application {
    
    @Override
    public void start(Stage primaryStage) throws IOException {
       
        Parent home=FXMLLoader.load(getClass().getResource("/home/Home.fxml"));
       // Parent home=FXMLLoader.load(getClass().getResource("/demo/test.fxml"));
      Scene home_scene= new Scene(home);
         home_scene.setFill(Color.TRANSPARENT);
         
         home_scene.setOnMouseClicked((MouseEvent event) -> {
             if (event.getClickCount()==2) {
                 primaryStage.setFullScreen(true);
                 
             }
        });
         
//        home_scene.setOnKeyReleased(new EventHandler<KeyEvent>(){
//            @Override
//            public void handle(KeyEvent event) {
//                
//                System.out.println(event.getCode());
//            
//            }
//        
//        });
         
         primaryStage.setScene(home_scene);
          primaryStage.initStyle(StageStyle.TRANSPARENT);
          primaryStage.show();


                
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
