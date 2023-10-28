import java.util.Scanner;
import java.io.*;
public class newUserEnd {
    private int n = 0;
    private int IdeaD = 0;
    public int studentCount = 0;
    private Person[] = new Person[510];
    private static BST yggdrasil = new BST();
    public static void main(String[] args) {
        System.out.println("Welcome to Student Idea Database.");
        Person a = new Person("Bee", 6969, "prigg@conncoll.edu", 0001);
        Person b = new Person ("Beau", 4201, "bma@conncoll.edu", 0002);
        Person c = new Person ("Mary", 8723, "mrigg@conncoll.edu",0003);
        Desc aa = new Desc(99, "Trans Rights", 1001);
        Desc bb = new Desc(40, "Dogs Should Vote", 1002);
    
        a.addToList(aa);
        b.addToList(bb);
        System.out.println(b.getIdea(0));
        yggdrasil.insert(a);
        yggdrasil.insert(b);
        yggdrasil.printTree();
        mainMenu();        

    }

    public static void mainMenu(){
       // System.out.println(
           try{
               FileInputStream fileIn = new FileInputStream("/tmp/BST.ser");
               objectInputStream in = new ObjectInputStream(fileIn);
               e = (BST) in.readObject();
               in.close()
               fileIn.close();
           }
           catch (IOException i){
               i.printStackTrace();
               return;
           }
           catch (ClassNotFoundException c){
               System.out.println("class not found")
               c.printStackTrace();
               return;
           }
        
        System.out.println("(0) Look Up Student Record");
        System.out.println("(1) Add New Records");
        System.out.println("(2) Look Up Student Email");
        System.out.println("(3) View All Students");
        System.out.println("(4) View Best Idea");
        System.out.println("(5) Save and Quit");
        System.out.println("(6) Extra Credit");
        Scanner userInput = new Scanner(System.in);
        int choice = userInput.nextInt();

        if (choice == 0){
            recordLookUp(userInput);
        }
        // if (choice == 1){
        //     newRecord(userInput);
        // }
        // if (choice == 2){
        //     emailLookUp(userInput);
        // }
        // if (choice == 3){
        //     allStudents();
        // }
        // if (choice == 4){
        //     bestIdea();
        // }
        // if (choice == 5){
        //     saveAndQuit();
            try{

                FileOutputStream fileout = new FileOutputStream("/tmp/BST.ser");
                ObjectOutputStream out = new ObjectOutputStream(fileout);
                out.writeObject(yggdrasil);
                out.close();
                fileOut.close();
            }
            catch (IOException i){
                i.printStackTrace();

            }

        // }
        // if (choice == 6){
        //     //oh no
        // }
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

    }
}
