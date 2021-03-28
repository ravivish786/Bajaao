/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.control.Alert;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 *
 * @author VICKY
 */
public class FindTime {
    
    List<File> list;
    ArrayList<File> song=new ArrayList<File>();
    
    
    public String getTotalTime(Double dd)
    {
        int value=(int) Math.round(dd);
        String hh="00",mm="00",ss="00";
        if(value>3599)
        {
            if(value/3600>9)
            {
                hh=String.valueOf(value/3600);
            }else{
                hh="0"+String.valueOf(value/3600);
            }
            value=value%3600;
        }
        if(value>59)
        {
            if(value/60>9)
            {
                mm=String.valueOf(value/60);
            }else{
                mm="0"+String.valueOf(value/60);
            }
            value=value%60;
        }
        if(value<60)
        {
            if(value>9)
            {
                ss=String.valueOf(value);
            }else{
                ss="0"+String.valueOf(value);
            }
        }
        
        return hh+":"+mm+":"+ss;
    }
    public static void main(String[] args) {
        FindTime ft=new FindTime();
        System.out.println("Time :"+ft.getTotalTime(227.113));
        
    }
    
    
}
