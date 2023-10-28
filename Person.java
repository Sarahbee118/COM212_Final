import java.io.Serializable;
public class Person implements Serializable{
    private int SSN;
    private String name;
    private Person next;
    private Person right;
    private Person left;
    private String email;
    private int SN;
   private Ideas ideaList = new Ideas();
   
   // private int id;

    public Person(String i_name, int i_ssn, String i_email, int i_sn/*, idea i_idea, int i_id*/){
        SSN = i_ssn;
        name = i_name;
        SN = i_sn;
        email = i_email;
       // idea = i_idea;
        // id = i_id;
    }
    public String getName(){
        return name;
    }
    public int getSSN(){
        return SSN;
    }
    public void setName(String i_name){
        name = i_name;
    }
    public void setSSN(int i_ssn){
        SSN = i_ssn;
    }
    public void setNext(Person SN){
        next = SN;
    }
    public Person getNext(){
        return next;
    }
    public Person getRight(){
        return right;
    }
    public Person getLeft(){
        return left;
    }
    public void setLeft(Person SN){
        left = SN;
    }
    public void setRight(Person SN){
        right = SN;
    }
    public String getEmail(){
        return email;
    }
    public int getSN(){
        return SN;
    }
    public void setEmail(String i_email){
        email = i_email;
    }
    public void setSN(int i_sn){
        SN = i_sn;
    }
    
    public Desc getIdea(int idNum){
       return ideaList.getSpecific(idNum);
    }

    public int ideaAmount(){
        return ideaList.getIdeaAmount();
    }

    public void deleteIdea(int x){
        ideaList.deleteId(x);
    }

    public void deleteNew(){
        ideaList.deleteTail();
    }

    public void deleteOld(){
        ideaList.deleteFront();
    }

    public Desc maxIdea(){
        return ideaList.getMax();
    }

    public void printIdeas(){
        ideaList.printQueue();
    }


    public void addToList(Desc newIdea){
       // System.out.println("OWO");
        ideaList.addIdea(newIdea);
    }

    public int getAverage(){
        return ideaList.getAvg();
    }
    public Desc getBestDesc(){
        return ideaList.getMax();
    }
    public int getBestID(){
        return ideaList.getMax().getID();
    }

}