/*Idea claass takes Desc class and puts it into this class, which is an array, before we pass it into
the person class.
*/
import java.io.Serializable;
public class Ideas implements Serializable{
  //  private int size;
    private Desc arr[];
    private int n; 
    private int front;
    private int tail;
    private Desc maxScore;

    public Ideas(){
      //  size = 9;
        arr =  new Desc[10];
        n = 0;
        front = 0;
        tail = 0;
    }
    /*public void addIdea(Desc x){
            if (n == 0){
                maxScore = x;
            }
            else{
                if (x.getScore() > maxScore.getScore()){
                    maxScore = x;                 
                }
            }
            tail = (front + n)%10;
            arr[tail] = x;
            n++;
            System.out.println(tail);
            System.out.println("owo");
    } */

    public void addIdea(Desc x){
        System.out.println(tail);
        if (n == 0){
            maxScore = x;
        }
        else{
            if (x.getScore() > maxScore.getScore()){
                maxScore = x;                 
            }
        }
        arr[tail] = x;
        tail = (1 + tail)%10;
        // if (tail == front){
        //     front = (1+front)%10;
        // }
        if (n > 9){
            n = 10;
        }
        else {
            n = n+1;
        }
    }

    public Desc deleteIdea(int x){
        Desc temp = arr[front];
        front = (front +1)%9;
        n--;
        return temp;
    }

    public void deleteTail(){
        if (tail == 0){
            arr[9] = null;
            tail = 9;
        }
        else {
            arr[tail-1] = null;
            tail = (tail-1)%10;
        }
        
        if (tail == front){
            front = (front-1)%10;
        }
        n = n-1;
    }

    public void deleteFront(){
        arr[front] = null;
        front = (front + 1)%10;
        // if (tail == front){
        //     tail = (tail+1)%10;
        // }
        n = n-1;
    }

    public Desc getNewest(){
        return arr[front];
    }

    public Desc getLast(){
        return arr[tail];
    }
    public Desc getDescID(int id){
        int i;
         for(i=0; i < n;i++){
            if (arr[i].getID() == id){
                return arr[i];
            }
        }
        return null;
         }

    public Desc getSpecific(int placement){
        if (arr[placement] != null){
            return arr[placement];
        }
        else {
            return null;
        }
    }
    public int getAvg(){
      
        int tot = 0;
        for(int i = 0; i < n; i++){
            if (arr[i] != null){
                tot = tot + arr[i].getScore();
            }
        }
        
        int average = tot/n;
        return average;
    }

    public Desc getMax(){
        return maxScore;

    }

    public int getIdeaAmount(){
        return n;
    }

    public void deleteId(int x){
        arr[x] = null;
        n = n-1;
    }

    public void printQueue() {
        for(int i = 0; i < 10; i++){
            if (arr[i] != null){
                System.out.println("Idea Number:" + arr[i].getID() + " " + arr[i].getIdea() + " with a score of " + arr[i].getScore());
                
            }
    }          
    }


}




    


