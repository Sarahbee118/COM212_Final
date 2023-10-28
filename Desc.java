import java.io.*;
import java.util.*;
import java.lang.*;
import java.io.Serializable;

public class Desc implements Serializable{
    private int score;
    private String ideaText;
    private int id;
    private int SSNid;
    private Desc left;
    private Desc right;
    private Desc next;


    public Desc(int i_score, String i_ideaFile, int i_id, int i_SSNid){
        SSNid = i_SSNid;
        ideaText = i_ideaFile;
        score = i_score;
        id = i_id;
    }
    public int getScore(){
        return score;
    }
   /* public String getFile() throws FileNotFoundException{
        FileReader reader = new FileReader(ideaFile);
        Scanner in = new Scanner(reader);
        String total = ("");
        while (in.hasNextLine()){
        String inputLine = in.nextLine();
        total = total.concat(inputLine);
        }
        in.close();
        return total;
    }
    */

    

    public String getIdea(){
        return ideaText;
    }

    public int getID(){
        return id;
    }
    public int getSSNid(){
        return SSNid;
    }
    public void setNext(Desc key){
        next = key;
    }
    

    public Desc getNext(){
        return next;
    }
    public void setLeft(Desc key){
        next = key;
    }
    public void setRight(Desc key){
        next = key;
    }
}
