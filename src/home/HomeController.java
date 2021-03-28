/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package home;


import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXToggleButton;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.beans.Observable;
import javafx.beans.value.ObservableValue;
import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.AudioEqualizer;
import javafx.scene.media.EqualizerBand;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaPlayer.Status;
import javafx.scene.media.MediaView;
import javafx.scene.text.Text;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Duration;
import javax.imageio.ImageIO;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import org.controlsfx.control.textfield.TextFields;
import test.FindTime;


/**
 * FXML Controller class
 *
 * @author VICKY
 */
public class HomeController implements  ChangeListener ,Initializable {

    @FXML
    private HBox home_top;
    @FXML
    private VBox home_left;
    @FXML
    private FontAwesomeIconView minbtn;
    @FXML
    private FontAwesomeIconView maxbtn;
    @FXML
    private FontAwesomeIconView closebtn;

    double x,y;
    
    @FXML
    private StackPane playingfield;
    @FXML
    private Label strttime;
    @FXML
    private Label endtime;
    @FXML
    private FontAwesomeIconView next;
    @FXML
    private FontAwesomeIconView repeat;
    @FXML
    private FontAwesomeIconView stop;
    @FXML
    private Slider volume;
    @FXML
    private FontAwesomeIconView snapshot;
    private FontAwesomeIconView record;
   
    @FXML
    private FontAwesomeIconView random;
    @FXML
    private FontAwesomeIconView equliger;
    @FXML
    private FontAwesomeIconView previous;
    @FXML
    private FontAwesomeIconView computer;
    @FXML
    private FontAwesomeIconView tv;
    @FXML
    private FontAwesomeIconView setting;
    @FXML
    private HBox searchbar;
    @FXML
    private FontAwesomeIconView zoomInOut;
    @FXML
    private AnchorPane controlArea;
    @FXML
    private MediaView mediaview;
    @FXML
    private FontAwesomeIconView open;
    @FXML
    private FontAwesomeIconView jumpleft;
    @FXML
    private FontAwesomeIconView plyandpause;
    @FXML
    private FontAwesomeIconView jumpright;
    SongList songList;
    File folderName=null;
    ArrayList<File> playSong = new ArrayList<File>();
    ArrayList<String> listForTextfield=new ArrayList<String>();
    private int songNumber=0;
    private int numberOfSong=0;
    private Random rand;
    MediaPlayer mediaplayer;
    @FXML
    private Slider process;
    private AnchorPane plate;
    @FXML
    private Label songname;
    
    @FXML
    private ImageView image;
    List<File> list;
    
    @FXML
    private Pane settingpane;
    @FXML
    private JFXToggleButton voicebtn;
    @FXML
    private FontAwesomeIconView home;
    Double totaltime=0.0;
   
    @FXML
    private AnchorPane home_center;
    @FXML
    private TextField searchsong;
    @FXML
    private Slider playbakcspeed;
    @FXML
    private FontAwesomeIconView btnplaybackspeed;
    @FXML
    private Pane playbackpane;
    @FXML
    private Label playbackspeedvalue;
    @FXML
    private Pane equeligerbar;
    @FXML
    private HBox equalizerbar;
    @FXML
    private JFXToggleButton equalizerbtn;
    @FXML
    private Pane equalizerpane;
    @FXML
    private JFXButton custom;
    @FXML
    private JFXButton normal;
    @FXML
    private JFXButton classical;
    @FXML
    private JFXButton dance;
    @FXML
    private JFXButton flat;
    @FXML
    private JFXButton folk;
    @FXML
    private Slider eqslider1;
    @FXML
    private Slider eqslider2;
    @FXML
    private Slider eqslider3;
    @FXML
    private Slider eqslider4;
    @FXML
    private Slider eqslider5;
    @FXML
    private FontAwesomeIconView volumbtn;
    private boolean isShow=false;
    private boolean isActiveRandom=false;
    private boolean isActiveCurrent=false;
    private boolean isSinglePlay=false;
    private boolean isRandomPlay=false;
    private double posX,posY;
    private int noOfShot=1;
    
    @FXML
    private FontAwesomeIconView curent;
        KeyCombination forOpen;
        KeyCombination forComputer;
        KeyCombination forTv;
        KeyCombination forSetting;
        KeyCombination forHome;
        KeyCombination forSearch;
        KeyCombination forPlayBack;
        KeyCombination forEqualizer;
        KeyCombination forFolder;
    FileChooser filechooser=new FileChooser();
    @FXML
    private FontAwesomeIconView seachbarClose;
    @FXML
    private Pane notificationpane;
    @FXML
    private Text notifyMsg;
    @FXML
    private TabPane homepane;
    @FXML
    private Pane tooltipPane;
    @FXML
    private Label tooltiptitle;
    @FXML
    private Text tooltipdata;
    @FXML
    private FontAwesomeIconView searchbtn;
    @FXML
    private FontAwesomeIconView folder;
    @FXML
    private JFXToggleButton randombtn;
    @FXML
    private JFXToggleButton currentbtn;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
     
        volume.setValue(0);
        forOpen=new KeyCodeCombination(KeyCode.O,KeyCombination.CONTROL_DOWN);
        forComputer=new KeyCodeCombination(KeyCode.C,KeyCombination.CONTROL_DOWN);
        forTv=new KeyCodeCombination(KeyCode.T,KeyCombination.CONTROL_DOWN);
        forSetting=new KeyCodeCombination(KeyCode.S,KeyCombination.CONTROL_DOWN);
        forHome=new KeyCodeCombination(KeyCode.H,KeyCombination.CONTROL_DOWN);
        forSearch=new KeyCodeCombination(KeyCode.F,KeyCombination.CONTROL_DOWN);
        forPlayBack=new KeyCodeCombination(KeyCode.P,KeyCombination.CONTROL_DOWN);
        forEqualizer=new KeyCodeCombination(KeyCode.Q,KeyCombination.CONTROL_DOWN);
        forFolder=new KeyCodeCombination(KeyCode.J,KeyCombination.CONTROL_DOWN);
    }    
    
    
    @FXML
    private void minpage(MouseEvent event) {
         Stage stage= (Stage) ((Node) event.getSource()).getScene().getWindow();
         stage.setIconified(true);
    }

    @FXML
    private void maxpage(MouseEvent event) {
         Stage stage= (Stage) ((Node) event.getSource()).getScene().getWindow();
         stage.setFullScreen(true);
    }

    @FXML
    private void closepage(MouseEvent event) {
         Stage stage= (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }

    @FXML
    private void draged(MouseEvent event) {
        Stage stage= (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setX(event.getScreenX() - x);
        stage.setY(event.getScreenY() - y);
    }

    @FXML
    private void pressed(MouseEvent event) {
        x=event.getX();
        y=event.getY();
        
    }
    
    // Load song in internal list 
    
    private void loadList()
    {
         filechooser.getExtensionFilters().addAll( 
                 new FileChooser.ExtensionFilter("mp4 file","*.mp4"),
                 new FileChooser.ExtensionFilter("mp3 file","*.mp3")
                );
        filechooser.setTitle("Open Multiple File for Playing Song  ");        
        Stage stage=(Stage) home_top.getScene().getWindow();    
        try {
            
            list=filechooser.showOpenMultipleDialog(stage);
            if(list!=null){
                songNumber=0;
                numberOfSong=0;
                    if(playSong!=null) { playSong.clear();  }
                    if(mediaplayer!=null) { mediaplayer.dispose(); } 
                   
                    for (File file:list)
                            playSong.add(file);

                    numberOfSong=list.size();
                       controlArea.setDisable(false);
                      tv.setDisable(false);
                      searchbtn.setDisable(false);
                     
                allPlayAndPause(songNumber);
                folderName=null;
              }else{
                Alert alert=new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information ");
                alert.setHeaderText("Choose song");
                alert.setContentText("Choose song then play ...");
                alert.showAndWait();
            }
               
                
        }catch (NullPointerException e) {
            System.out.println(e);
            
        }
     }
    
    @FXML
    private void selectFileList(MouseEvent event) {  
       
        loadList();  
    }
    @FXML
    private void myComputer(MouseEvent event) {
        loadList();  
    }
    @FXML
    private void seeVideo(MouseEvent event) {
        playingfield.toFront();
        searchbar.toBack();
        isShow=false;
    }
    @FXML
    private void stopSong(MouseEvent event) {
        mediaplayer.stop();
        plyandpause.setIcon(FontAwesomeIcon.PLAY);
    }
    @FXML
    private void repeatSong(MouseEvent event) {
        mediaplayer.dispose();
        allPlayAndPause(songNumber);
    }
    @FXML
    private void previousSong(MouseEvent event) {
        preSong();
    }
    private void preSong()
    {
        mediaplayer.dispose();
        if (songNumber>0) {
            allPlayAndPause(--songNumber);
        } else {
            allPlayAndPause(0);
        }
    }
    @FXML
    private void nextSong(MouseEvent event) {
       nxtSong();
    }
    private void nxtSong()
    {
        mediaplayer.dispose();
        if (songNumber<numberOfSong-1) {
            allPlayAndPause(++songNumber);
        } else {
            allPlayAndPause(numberOfSong-1);
        }
        
    }
    @FXML
    private void randomSong(MouseEvent event) {
        checkRandomStatus();
    }
    private void checkRandomStatus()
    {
        if(isRandomPlay)
            {
                 isRandomPlay=false;
                 notifyMsg.setText("Random Play Off");
                 isActiveRandom=false; 
                 notificationpane.toFront();
                 randombtn.setSelected(false);
                 randombtn.setText("Off");
            }else{
               
                isRandomPlay=true;
                notifyMsg.setText("Random Play On");
                 isActiveRandom=true; 
                 notificationpane.toFront();
                 randombtn.setSelected(true);
                 randombtn.setText("On");
            }   
    }
    @FXML
    private void takeSnapshot(MouseEvent event) {
        takePhoto();
    }
    private void expendVideo(MouseEvent event) {
        home_left.toBack();
         playingfield.toFront();       
    }   
    
    
    @FXML
    private void zoomInOutVideo(MouseEvent event) {
        if (zoomInOut.getGlyphName().equals(FontAwesomeIcon.EXPAND.toString())) {
            zoomInOut.setIcon(FontAwesomeIcon.COMPRESS);
            Stage stage= (Stage) ((Node) event.getSource()).getScene().getWindow();
             stage.setFullScreen(true);
        }else{
            zoomInOut.setIcon(FontAwesomeIcon.EXPAND);
            Stage stage= (Stage) ((Node) event.getSource()).getScene().getWindow();
             stage.setFullScreen(false);
        }
    }
    @FXML
    private void jumpLeft(MouseEvent event) {
        mediaplayer.seek(Duration.seconds(mediaplayer.getCurrentTime().toSeconds()-10));
    }
    @FXML
    private void playAndPause(MouseEvent event) {
        if(mediaplayer.getStatus()==Status.PLAYING)
               {
                   mediaplayer.pause();
                   plyandpause.setIcon(FontAwesomeIcon.PLAY);
               }else{
                   mediaplayer.play();
                   plyandpause.setIcon(FontAwesomeIcon.PAUSE);  
               }
    }
    @FXML
    private void jumpRight(MouseEvent event) {
        mediaplayer.seek(Duration.seconds(mediaplayer.getCurrentTime().toSeconds()+10));
    }
    @Override
    public void stateChanged(ChangeEvent ce) {
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public void allPlayAndPause(int index)
    {
        
        if(playSong.get(index).toString().substring(playSong.get(index).toString().lastIndexOf("."),playSong.get(index).toString().length()).equalsIgnoreCase(".mp4"))
        {
            snapshot.setDisable(false);
            image.setDisable(true);
            image.toBack();
           workingSong(playSong.get(index).toURI().toString());
        }else{
            workingSong(playSong.get(index).toURI().toString());
            snapshot.setDisable(true);
            image.setDisable(false);
            image.toFront();
        }
        
       
    }
    private void workingSong(String song)
    {
            
            Media media=new Media(song);
            songname.setText(song.substring(song.lastIndexOf("/")+1));
            mediaplayer=new MediaPlayer(media);
            mediaview.setMediaPlayer(mediaplayer);
            playingfield.toFront();
            plyandpause.setIcon(FontAwesomeIcon.PAUSE);
            mediaplayer.setRate(playbakcspeed.getValue());
            mediaplayer.setVolume(volume.getValue());
            volume.valueProperty().addListener((Observable observable) -> {
                mediaplayer.setVolume(volume.getValue()/10);
            });
            playbakcspeed.valueProperty().addListener((ObservableValue<? extends Number> observable, Number oldValue, Number newValue) -> {
                if(playbakcspeed.isPressed())
                {
                     mediaplayer.setRate(playbakcspeed.getValue());
                     
                     playbackspeedvalue.setText((String.valueOf(playbakcspeed.getValue())+"00").substring(0, 4)+" fx");
                }
            });
            process.valueProperty().addListener((ObservableValue<? extends Number> observable, Number oldValue, Number newValue) -> {
                 if(process.isPressed())
                 {
                     mediaplayer.seek(Duration.seconds(process.getValue()));
                 }
                
            });
            
            mediaplayer.setOnEndOfMedia(() -> {
                mediaplayer.dispose();
                if(isActiveCurrent)
                {
                    songNumber=songNumber;
                }else if (isActiveRandom) {  
                    Random rand=new Random();
                    songNumber=rand.nextInt(numberOfSong-1);
                    allPlayAndPause(songNumber);
                }else{
                    songNumber++;
                }
          
                if(songNumber<=numberOfSong-1)
                    {
                        allPlayAndPause(songNumber);
                    }
       });
            mediaplayer.currentTimeProperty().addListener((ObservableValue<? extends Duration> observable, Duration oldValue, Duration newValue) -> {
                process.setValue(newValue.toSeconds());
                strttime.setText(new FindTime().getTotalTime(newValue.toSeconds()));
                
            });
            mediaplayer.setOnReady(()->{
                process.setMin(0);
                strttime.setText("00:00:00");
                totaltime=mediaplayer.getMedia().getDuration().toSeconds();
                process.setMax(totaltime);
                endtime.setText(new FindTime().getTotalTime(totaltime) );
                process.setValue(0);
                
                 
            });

            mediaplayer.play();
    }
    private void fullpage(MouseEvent event) {
        mediaview.setFitWidth(1200);
        mediaview.setFitHeight(650);
    }
    
    @FXML
    private void comepage(KeyEvent event) {
     
        if(isShow)
        {
            if(event.getCode()==KeyCode.ENTER)
            {
                goDirectSong(searchsong.getText());
            }
        }else{
            getAction(event);
        }
        
    }
    private void goDirectSong(String name)
    {
        if(name.equalsIgnoreCase("Ravi")||name.equalsIgnoreCase("Jyoti"))
        {
          //  workingSong("video/Cheez Badi Mast.mp4".toString());
        }else{
             if(list!=null||folderName!=null){
                 int no=0;
                      for (File file:playSong) {
                            if(name.equalsIgnoreCase(file.getName()))
                            {
                                mediaplayer.dispose();
                                allPlayAndPause(no);
                                songNumber=no;
                                isShow=false;
                                searchbar.toBack();
                                searchsong.setText("");
                                break;
                            }
                            no++;
                         }
              }
        }
    }
    private void getAction(KeyEvent event)
    {
        if(forOpen.match(event)) //OPEN FILE
        {
            loadList();
           
        }else if(forComputer.match(event)) //OPEN COMPUTER FILE
        {
            loadList();
           
        }else if(forTv.match(event))  //OPEN TV
        {
            playingfield.toFront();
            searchbar.toBack();
            isShow=false;
        }else if(forSetting.match(event))  //OPEN SETTING 
        {
            playbackpane.toBack();
            settingpane.toFront();
            equeligerbar.toBack();
            searchbar.toBack();
            isShow=false;
        }else if(forHome.match(event)) //OPEN HOME
        {
            homepane.toFront();
        }else if(forSearch.match(event))  //OPEN SEARCH BAR 
        {
          showSearchData();
        }else if(forPlayBack.match(event))  //OPEN PLAY BACK
        {
            playbackpane.toFront();
            settingpane.toBack();
            equeligerbar.toBack();
        }else if(forEqualizer.match(event))  // OPEN EQUALIZER
        {
            settingpane.toBack();
            playbackpane.toBack();
            equeligerbar.toFront();
        }else if(forFolder.match(event))  // select folder
        {
            selectFolder();
        }else if(event.getCode()==KeyCode.X) //// full page 
        {
             Stage stage= (Stage) ((Node) event.getSource()).getScene().getWindow();
             stage.setFullScreen(false);    
             mediaview.setFitWidth(700);
             mediaview.setFitHeight(450);
        } else if(event.getCode()==KeyCode.F){  //// comepage 
             Stage stage= (Stage) ((Node) event.getSource()).getScene().getWindow();
             stage.setFullScreen(true);
             mediaview.setFitWidth(1200);
             mediaview.setFitHeight(650);
        }
        else if(event.getCode()==KeyCode.Y){  //// photo 
                takePhoto();
        }else if(event.getCode()==KeyCode.J){  //// stop song 
            mediaplayer.dispose();
            plyandpause.setIcon(FontAwesomeIcon.PLAY);
        }else if(event.getCode()==KeyCode.R){  //// repeat song 
            mediaplayer.dispose();
            allPlayAndPause(songNumber);
        }else if(event.getCode()==KeyCode.P){  //// previous song 
            preSong();
        }else if(event.getCode()==KeyCode.N){  //// next song 
               nxtSong();
        }else if(event.getCode()==KeyCode.M){  //// random song 
               checkRandomStatus();
        }else if(event.getCode()==KeyCode.I){  //// single  song 
               checkCurentStstus();
        }else if(event.getCode()==KeyCode.SPACE){  //// play pause song  
               if(mediaplayer.getStatus()==Status.PLAYING)
               {
                   mediaplayer.pause();
                   plyandpause.setIcon(FontAwesomeIcon.PLAY);
               }else{
                   mediaplayer.play();
                   plyandpause.setIcon(FontAwesomeIcon.PAUSE);
               }
        }else if(event.getCode()==KeyCode.RIGHT){  //// jump right song 
            mediaplayer.seek(Duration.seconds(mediaplayer.getCurrentTime().toSeconds()+10));
        }else if(event.getCode()==KeyCode.LEFT){  //// jump left song 
            mediaplayer.seek(Duration.seconds(mediaplayer.getCurrentTime().toSeconds()-10));
        }else if(event.getCode()==KeyCode.UP){  //// volum up song 
              volume.setValue(volume.getValue()+0.5);
              if(volume.getValue()>0)
              {
                  volumbtn.setIcon(FontAwesomeIcon.VOLUME_UP);
                  mediaplayer.setMute(false);
                  volume.setDisable(false);
              }
        }else if(event.getCode()==KeyCode.DOWN){  //// volum down  song 
              volume.setValue(volume.getValue()-0.5);
              if(volume.getValue()<=0)
              {
                  volumbtn.setIcon(FontAwesomeIcon.VOLUME_OFF);
                  mediaplayer.setMute(true);
                  volume.setDisable(true);
              }
        }  
        
    }
    private void takePhoto() {
        WritableImage writableImage = 
            new WritableImage((int)mediaview.getFitWidth(), (int)mediaview.getFitHeight());
        mediaview.snapshot(new SnapshotParameters(), writableImage);
        File file = new File("snapshot"+String.valueOf(noOfShot)+".png");
        try {
            ImageIO.write(SwingFXUtils.fromFXImage(writableImage, null), "png", file);
            System.out.println("snapshot saved: " + file.getAbsolutePath());
            noOfShot++;
        } catch (IOException ex) {
           
        }
    }

    @FXML
    private void showSetting(MouseEvent event) {
        playbackpane.toBack();
        settingpane.toFront();
        equeligerbar.toBack();
        searchbar.toBack();
        isShow=false;
    }

    @FXML
    private void showHome(MouseEvent event) {
      homepane.toFront();
    }

    @FXML
    private void showPlayBackSpeed(MouseEvent event) {
        settingpane.toBack();
        playbackpane.toFront();
      equeligerbar.toBack();
      searchbar.toBack();
      isShow=false;
    }

    @FXML
    private void showVoiceComand(MouseEvent event) {
        if(voicebtn.getText().equals("Off"))
        {
            voicebtn.setText("On");
        }else{
            voicebtn.setText("Off");
        }
    }

    

    @FXML
    private void showEqualigerPane(MouseEvent event) {
        if(equalizerbtn.getText().equals("Off"))
        {
            equalizerbtn.setText("On");
            equalizerpane.setDisable(false);
            
            AudioEqualizer audio=mediaplayer.getAudioEqualizer();
            for (Iterator<EqualizerBand> it = audio.getBands() .iterator(); it.hasNext();)
            {
                EqualizerBand band = it.next();
                System.out.println("Center : "+band.getCenterFrequency());
                System.out.println("Band : "+band.getBandwidth());
                System.out.println("Gain : "+band.getGain());
                
            }
            
           
        }else{
            equalizerbtn.setText("Off");
            equalizerpane.setDisable(true);
        }
    }

    @FXML
    private void showSearchBar(MouseEvent event) {
       showSearchData();
    }

    private void showSearchData()
    {
         searchbar.toFront();
        isShow=true;
        listForTextfield.clear();
        if(list!=null)
        {
            for (File file:list) 
                listForTextfield.add(file.getName());
        }
        if(folderName!=null)
        {
            for (String file:  folderName.list()) 
                listForTextfield.add(new File(folderName.getAbsoluteFile()+"/"+file).getName());     
        }
        
        TextFields.bindAutoCompletion(searchsong, listForTextfield);
    }

    @FXML
    private void volumControl(MouseEvent event) {
        if (volumbtn.getGlyphName().equals(FontAwesomeIcon.VOLUME_UP.toString())) {
            volumbtn.setIcon(FontAwesomeIcon.VOLUME_OFF);
            volume.setDisable(true);
           mediaplayer.setMute(true);
        }else{
            volumbtn.setIcon(FontAwesomeIcon.VOLUME_UP);
            volume.setDisable(false);
           mediaplayer.setMute(false);
        }
    }

    @FXML
    private void showEquiligerBar(MouseEvent event) {
        equeligerbar.toFront();
        settingpane.toBack();
        playbackpane.toBack();
        searchbar.toBack();
        isShow=false;

    }

    @FXML
    private void currentSong(MouseEvent event) {
      checkCurentStstus();
    }

    private void checkCurentStstus()
    { 
        if(isSinglePlay)
            {
                 isSinglePlay=false;
                 notifyMsg.setText("Single Play Off");
                 isActiveCurrent=false; 
                 notificationpane.toFront();
                 currentbtn.setSelected(false);
                 currentbtn.setText("Off");
                 
            }else{
               
                isSinglePlay=true;
                notifyMsg.setText("Single Play On");
                 isActiveCurrent=true; 
                 notificationpane.toFront();
                 currentbtn.setSelected(true);
                 currentbtn.setText("On");
                 
            }   
    }
    @FXML
    private void closeSearchBox(MouseEvent event) {
        isShow=false;
        searchbar.toBack();
        searchsong.setText("");
    }

    @FXML
    private void homeMouseExit(MouseEvent event) {
     tooltipPane.toBack();
    }

    @FXML
    private void homeMouseEnter(MouseEvent event) {
       tooltipPane.setLayoutX(posX);
       tooltipPane.setLayoutY(posY);
       tooltiptitle.setText("Home");
       tooltipdata.setText("This is show all Help And About this aplplication");
        tooltipPane.toFront();
    }

    @FXML
    private void openMouseExit(MouseEvent event) {
        tooltipPane.toBack();
    }

    @FXML
    private void openMouseEnter(MouseEvent event) {
       tooltipPane.setLayoutX(posX);
       tooltipPane.setLayoutY(posY);
       tooltiptitle.setText("Open");
       tooltipdata.setText("Use for load Song list for play  ");
        tooltipPane.toFront();
    }

    @FXML
    private void moved(MouseEvent event) {
        
        posX=event.getX();
        posY=event.getY()-20;
       // System.out.println(" X :"+posX+" Y: "+posY);
    }

    @FXML
    private void computerMouseExit(MouseEvent event) {
        tooltipPane.toBack();
    }

    @FXML
    private void computerMouseEnter(MouseEvent event) {
         tooltipPane.setLayoutX(posX);
       tooltipPane.setLayoutY(posY);
       tooltiptitle.setText("Computer");
       tooltipdata.setText("Load song from Computer for play ");
        tooltipPane.toFront();
    }

    @FXML
    private void tvMouseExit(MouseEvent event) {
        tooltipPane.toBack();
    }

    @FXML
    private void tvMouseEnter(MouseEvent event) {
         tooltipPane.setLayoutX(posX);
       tooltipPane.setLayoutY(posY);
       tooltiptitle.setText("TV ( Show Video)");
       tooltipdata.setText("Show only vedio not any caption ");
        tooltipPane.toFront();
    }

    @FXML
    private void settingMouseExit(MouseEvent event) {
        tooltipPane.toBack();
    }

    @FXML
    private void settingMouseEnter(MouseEvent event) {
         tooltipPane.setLayoutX(posX);
       tooltipPane.setLayoutY(posY);
       tooltiptitle.setText("Setting");
       tooltipdata.setText("Show all setting of this application");
        tooltipPane.toFront();
    }

    @FXML
    private void searchMouseExit(MouseEvent event) {
        tooltipPane.toBack();
    }

    @FXML
    private void searchMouseEnter(MouseEvent event) {
         tooltipPane.setLayoutX(posX);
       tooltipPane.setLayoutY(posY);
       tooltiptitle.setText("Search Song");
       tooltipdata.setText("Find song with in selected song in list");
        tooltipPane.toFront();
    }

    @FXML
    private void folderMouseExit(MouseEvent event) {
        tooltipPane.toBack();
    }

    @FXML
    private void folderMouseEnter(MouseEvent event) {
        tooltipPane.setLayoutX(posX);
       tooltipPane.setLayoutY(posY);
       tooltiptitle.setText(" Folder");
       tooltipdata.setText(" Select foldr for playing song");
        tooltipPane.toFront();
    }

    @FXML
    private void showFolder(MouseEvent event) {
        
        selectFolder();   
    }

    private void selectFolder() {
        try {
            DirectoryChooser dir_chooser = new DirectoryChooser(); 
        Stage stage=(Stage) home_top.getScene().getWindow();           
         folderName = dir_chooser.showDialog(stage); 
        if (folderName != null) { 
            numberOfSong=0;
            songNumber=0;
            if(playSong!=null) { playSong.clear();  }
            if(mediaplayer!=null) { mediaplayer.dispose(); } 
            for (String file:  folderName.list()) 
            {
                playSong.add(new File(folderName.getAbsoluteFile()+"/"+file));
                numberOfSong++;
               
            }
                       controlArea.setDisable(false);
                      tv.setDisable(false);
                      searchbtn.setDisable(false);
                     
                allPlayAndPause(songNumber);
                 list=null;            
        }else{
                Alert alert=new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information ");
                alert.setHeaderText("Choose Folder ");
                alert.setContentText("Choose folder then automatic play ...");
                alert.showAndWait();
        }
        } catch (NullPointerException e) {
            System.out.println("null : " +e);
        }
     
    }

    @FXML
    private void showRandomSong(MouseEvent event) {
      if(randombtn.getText().equals("Off"))
        {
            randombtn.setText("On");
            isRandomPlay=false;
            isActiveRandom=true;
        }else{
            randombtn.setText("Off");
            isRandomPlay=true;
            isActiveRandom=false;
        }  
      checkRandomStatus();
    }

    @FXML
    private void showCurrentSong(MouseEvent event) {
         if(currentbtn.getText().equals("Off"))
        {
            currentbtn.setText("On");
           isSinglePlay=false;
           isActiveCurrent=true;
        }else{
            currentbtn.setText("Off");
            isSinglePlay=true;
            isActiveCurrent=false;
        }
         checkCurentStstus();
    }
  
}
