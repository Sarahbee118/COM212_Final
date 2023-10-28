import java.util.Scanner;
import java.io.*;
public class newUserEnd {
    private  static int n = 0;
    //private int IdeaD = 9;
    public static int studentCount = 28;
    private static int IdeaID = 0;
   // private Person[] = new Person[510];
    private static BST yggdrasil = new BST();
    private static ideaList allIdeas = new ideaList();
    private static Best heap = new Best();

    public static void main(String[] args) {
        System.out.println("Welcome to Student Idea Database.");
        // Person a = new Person("Bee", 6969, "prigg@conncoll.edu", 0002);
        // Person b = new Person ("Beau", 4201, "bma@conncoll.edu", 0001);
        // Person c = new Person ("Mary", 8723, "mrigg@conncoll.edu",0003);
        // Desc aa = new Desc(99, "Trans Rights", 1001, a.getSSN());
        // IdeaID = IdeaID+1;
        // Desc bb = new Desc(40, "Dogs Should Vote", 1002, b.getSSN());
        // IdeaID = IdeaID+1;
        // a.addToList(aa);
        // b.addToList(bb);
        // System.out.println(b.getIdea(0));
        // yggdrasil.insert(a);
        // yggdrasil.insert(b);
        // yggdrasil.printTree();
        try{
            FileInputStream fileIn = new FileInputStream("BST.ser");
           FileInputStream file2 = new FileInputStream("ideaList.ser");
            FileInputStream file3 = new FileInputStream("best.ser");
          FileInputStream file4 = new FileInputStream("IdeaCount.ser");
          FileInputStream file5 = new FileInputStream("StudentCount.ser");
           FileInputStream file6 = new FileInputStream("N.ser");


            ObjectInputStream in = new ObjectInputStream(fileIn);
            ObjectInputStream in2 = new ObjectInputStream(file2);
            ObjectInputStream in3 = new ObjectInputStream(file3);
          ObjectInputStream in4 = new ObjectInputStream(file4);
          ObjectInputStream in5 = new ObjectInputStream(file5);
          ObjectInputStream in6 = new ObjectInputStream(file6);

           
          

            yggdrasil = (BST) in.readObject();
            allIdeas = (ideaList) in2.readObject();
            heap = (Best) in3.readObject();
           studentCount = (int) in5.readObject();
          IdeaID = (int) in4.readObject();
          n = (int) in6.readObject();

            in.close();
            fileIn.close();
           file2.close();
           in2.close();
            file3.close();
            in3.close();
          in4.close();
          in5.close();
          in6.close();
        }
        catch (IOException i){
            i.printStackTrace();
            return;
        }
        catch (ClassNotFoundException c){
            System.out.println("class not found");
            c.printStackTrace();
            return;
        }
        mainMenu();        

    }

    public static void mainMenu(){
      
        
        System.out.println("(0) Look Up Student Record");
        System.out.println("(1) Add Student Record");
        System.out.println("(2) Look Up Student Email");
        System.out.println("(3) View All Students");
        System.out.println("(4) View/Delete Best Idea");
        System.out.println("(5) Save and Quit");
        System.out.println("(6) List of All Ideas (Extra Credit)");
        Scanner userInput = new Scanner(System.in).useDelimiter("\n");
        int choice = userInput.nextInt();

        if (choice == 0){
            recordLookUp(userInput);
        }
        if (choice == 1){
            newRecord(userInput);
        }
        if (choice == 2){
            emailLookUp(userInput);
        }
        if (choice == 3){
             allStudents();
        }
         if (choice == 4){
             choice = 0;
             System.out.println("(0) View Max" + "\n"  +"(1) Delete Max");
             choice = userInput.nextInt();
             if (choice == 0){
                System.out.println(heap.findMax().getIdea());
             }
             if (choice == 1){
                 System.out.println(heap.deleteMax());
             }
             mainMenu();
         }
         if (choice == 5){
            saveAndQuit();
        }
         if (choice == 6){
             extraCredit(userInput);
            
         }
    }
    private static void recordLookUp(Scanner input){
        System.out.println("Please Enter the SSN of the Student You Wish to Look Up");
        int currentSSN = input.nextInt();
        Person assembly = yggdrasil.search(currentSSN);
        
        recordLookUp2(input, assembly);
    }
    

    private static void recordLookUp2(Scanner input, Person current){
        
        System.out.println("Name:" + current.getName());
        System.out.println("SSN:" + current.getSSN());
        System.out.println("ID #:" +  current.getSN());
        System.out.println("Email: "+ current.getEmail());
        System.out.println("Student has "+current.ideaAmount()+" ideas in system");
        if (current.ideaAmount() > 0){
            System.out.println("With an average idea score of " + current.getAverage());
        }
        System.out.println("Would you like to make any changes?");
        System.out.println("(0) Access Ideas (View/Add/Delete)");
        System.out.println("(1) Modify Student Name");
        System.out.println("(2) Modify Student Email");
        System.out.println("(3) Delete Record");
        System.out.println("(4) Save and Look Up Different Student");
        System.out.println("(5) Save Changes and Return to Main Menu");
        int choice = input.nextInt();
        if (choice == 0 ){
            vad(input,current);
        }
        if (choice == 1){
            System.out.println("Please Enter the New Name:");
            current.setName(input.next());
            recordLookUp2(input, current);
        }
        if (choice == 2){
            System.out.println("Please Enter the New Email:");
            current.setEmail(input.next());
            recordLookUp2(input, current);
        }
        if (choice == 3){
            yggdrasil.delete(current);
            
            mainMenu();
        }
        if (choice == 4){
            n = n - current.ideaAmount();
            yggdrasil.delete(current); //deletes Person(Node) in BST currently
            yggdrasil.insert(current); //adds modified one
            recordLookUp(input);
        }
        if (choice == 5){
            yggdrasil.delete(current); //deletes Person(Node) in BST currently
            yggdrasil.insert(current); //adds modified one
            mainMenu();

        }
    }
    private static void vad(Scanner input, Person current){

        current.printIdeas();
        System.out.println("(0) Add New Idea");
        System.out.println("(1) Delete Oldest Idea");
        System.out.println("(2) Delete Newest Idea");
        System.out.println("(3) Save and Quit to Record Menu");
        int choice = input.nextInt();
        if (choice == 0 ){
            if (n == 511){
                System.out.println("Max Ideas Reached Unable to Add More");
                vad(input, current);
            }
            System.out.println("Please Enter The Description of the New Idea, then Idea Score");
            String newIdea = input.next();
           // input.nextLine();
            int newScore = input.nextInt();
            Desc newDesc = new Desc(newScore, newIdea, IdeaID, current.getSN());
            IdeaID = IdeaID +1;
            if (current.ideaAmount() < 10){
                n = n+1;
            }
            current.addToList(newDesc);
            allIdeas.add(newDesc);
            heap.insert(newDesc);
            vad(input, current);
        }
        if (choice == 1){       
            n = n -1;     
            current.deleteOld();
            vad(input, current);
        }
        if (choice == 2){    
            n = n - 1;        
            current.deleteNew();
            vad(input, current);
        }
        if (choice == 3){
           recordLookUp2(input, current);
        }
    }

    private static void newRecord(Scanner input){
        System.out.println("Enter New Student Name");
        String nombre = input.next();
        System.out.println("Student's SSN?");
        int social = input.nextInt();
        System.out.println("Student's email");
        String correo = input.next();
        Person newPerson = new Person(nombre, social, correo, studentCount);
        yggdrasil.insert(newPerson); 
        System.out.println("Student Added");
        System.out.println("(0) Return to Main Menu");
        System.out.println("(1) Modify New Student Ideas");
        System.out.println("(2) Add Another Student");
        int choice = input.nextInt();
        if (choice == 0){
            mainMenu();
        }
        if (choice == 1){
            recordLookUp2(input, newPerson);
        }
        if (choice == 2){
            newRecord(input);
        }
    }

    private static void emailLookUp(Scanner input){
        System.out.println("What is the ID of Student who's email you are looking for?");
        int lookUpInt = input.nextInt();
        yggdrasil.traverseEmail(lookUpInt);
        mainMenu();
       
    }

    private static void allStudents(){
       //BSTSN yggy2 = yggdrasil.scanCopy();
       yggdrasil.printTree();
       mainMenu();
    }


    private static void saveAndQuit(){
        try{

            FileOutputStream fileout = new FileOutputStream("BST.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileout);
            out.writeObject(yggdrasil);
            out.close();
            fileout.close();
        }
        catch (IOException i){
            i.printStackTrace();

        }

        try{

            FileOutputStream fileout = new FileOutputStream("StudentCount.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileout);
            out.writeObject(studentCount);
            out.close();
            fileout.close();
        }
        catch (IOException i){
            i.printStackTrace();

        }

        try{

            FileOutputStream fileout = new FileOutputStream("IdeaCount.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileout);
            out.writeObject(IdeaID);
            out.close();
            fileout.close();
        }
        catch (IOException i){
            i.printStackTrace();

        }
        
    

        try{

            FileOutputStream fileout = new FileOutputStream("StudentCount.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileout);
            out.writeObject(studentCount);
            out.close();
            fileout.close();
        }
        catch (IOException i){
            i.printStackTrace();

        }

        try{

            FileOutputStream fileout = new FileOutputStream("N.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileout);
            out.writeObject(n);
            out.close();
            fileout.close();
        }
        catch (IOException i){
            i.printStackTrace();

        }

    try{

        FileOutputStream fileout = new FileOutputStream("ideaList.ser");
        ObjectOutputStream out = new ObjectOutputStream(fileout);
        out.writeObject(allIdeas);
        out.close();
        fileout.close();
    }
    catch (IOException i){
        i.printStackTrace();

    }
    try{

        FileOutputStream fileout = new FileOutputStream("best.ser");
        ObjectOutputStream out = new ObjectOutputStream(fileout);
        out.writeObject(heap);
        out.close();
        fileout.close();
    }
    catch (IOException i){
        i.printStackTrace();

    }


}

    private static void extraCredit(Scanner input){
        System.out.println("(0) Print all ideas");
        System.out.println("(1) Delete idea by SSN number:");
        if(input.nextInt() == 0){
            allIdeas.printList();
            mainMenu();
        }
        else{
            System.out.println("Enter idea number:");
            Scanner choice = new Scanner(System.in);
            allIdeas.searchRemove(choice.nextInt());
            mainMenu();

        }
        
    }
}
