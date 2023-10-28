import java.io.Serializable;
public class ideaList implements Serializable{
    private Desc head;
    private int n;

    public ideaList(){
        head = null;
        n = 0;
}
    public int length(){
        return n;
        }    
    public boolean isEmptyList(){
        if (n == 0){
            return true;}
        else{
            return false;}      
    }
    public Desc searchReturn(int key){      
        Desc temp = head;
    
        while (temp != null){
            if (temp.getSSNid()==key){
                return temp;}
            else{
                temp = temp.getNext();
            }     
        }
        return null;
    }
    public void add(Desc x){
        if(isEmptyList()){
            head = x;
            n++;}
        else{
            Desc temp = head;
            head = x;
            head.setNext(temp);
            n++;
        }      
    }
    public void printList(){
        if (isEmptyList()){
            System.out.println("List is empty");
        }
        Desc temp = head;
        System.out.println(length());
        while (temp != null){
            System.out.println(temp.getIdea());
            temp = temp.getNext(); 
        }       
    }
    public Desc searchRemove(int key){
        Desc temp = head;
        Desc before = null;
        if (head.getSSNid() == key){
            Desc t = head;
            head = head.getNext(); 
            n--; 
            return t;}     
        else{
            while (temp.getNext() !=null){
                if (temp.getNext().getSSNid()==key){
                    Desc j = temp;
                    temp.setNext(temp.getNext().getNext());
                    n--;
                    return j;}
                else{
                    temp = temp.getNext();
                    
                }         
             }
        return null;
        }
        }
}
