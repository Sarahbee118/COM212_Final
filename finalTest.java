import java.util.Scanner;
import java.io.*;
public class finalTest {
private static BST yggdrasil = new BST();
  
  public static void main(String[] args){
    
    int TestID = 0;
    Person a = new Person("Rigg", 1108, "prigg@conncoll.edu", 1);
    Person b = new Person ("Ma", 9104, "bma@conncoll.edu", 2);
    Person c = new Person ("Rigg", 7723, "mrigg@conncoll.edu",3);
    Person d = new Person("Wozniak",6297 , "swoz@conncoll.edu", 4);
    Person e = new Person ("Celeste", 1258, "mcele@conncoll.edu", 5);
    Person f = new Person ("Major", 1199, "mmajor@conncoll.edu",6);
    Person g = new Person("Rose",5510 , "srose@conncoll.edu", 7);
    Person h = new Person ("Rose", 1128, "brose@conncoll.edu", 8);
    Person i = new Person ("Sapphire",1122 , "psapp@conncoll.edu",9);
    Person j = new Person("Prouty", 7012, "aprou@conncoll.edu", 10);
    Person k = new Person ("Aran", 8686, "saran@conncoll.edu", 11);
    Person l = new Person ("Mario", 7981, "mmario@conncoll.edu",12);
    Person m = new Person("Mario", 4483, "lmario@conncoll.edu", 13);
    Person n = new Person ("Jackson", 2121, "pjack@conncoll.edu", 14);
    Person o = new Person ("Crow", 1228, "ecrow@conncoll.edu",15);
    Person p = new Person("Travers", 7143, "dtrav@conncoll.edu", 16);
    Person q = new Person ("Smith", 7131, "asmit@conncoll.edu", 17);
    Person r = new Person ("Friend", 4353, "kfrie@conncoll.edu",18);
    Person s = new Person ("Katein", 5645, "lkate@conncoll.edu", 19);
    Person t = new Person ("Rigg", 8267, "mrigg1conncoll.edu",20);
    Person u = new Person("Printz", 1265, "sprin@conncoll.edu", 21);
    Person v = new Person ("Afton", 1987, "wafto@conncoll.edu", 22);
    Person w = new Person ("Sauce",1985 , "vsauc@conncoll.edu",23);
    Person x = new Person("Faz", 6334, "gfazconncoll.edu", 24);
    Person y = new Person ("Balentine", 4201, "abale@conncoll.edu", 25);
    Person z = new Person ("Fyre", 9382, "bfyre@conncoll.edu", 26);
    Person zz = new Person ("Parker", 7214, "gparker@conncoll.edu", 27);
   
 

    // for (int he =0; he< 9; he = he+1){
    //   Desc aa = new Desc(50, "Test Idea", TestID, a.getSSN());
    //   a.addToList(aa);
    // }

    // for (int ha =0; ha < 8; ha = ha+1){
    //   Desc aa = new Desc(50, "Test Idea", TestID, a.getSSN());
    //   b.addToList(aa);
    // }

    // Desc gg = new Desc(50, "Idea 1", 1, g.getSSN());
    // g.addToList(gg);
    // gg = new Desc(50, "Idea 2", 2, g.getSSN());
    // g.addToList(gg);
    // gg = new Desc(50, "Idea 3", 3, g.getSSN());
    // g.addToList(gg);
    // gg = new Desc(50, "Idea 4", 4, g.getSSN());
    // g.addToList(gg);
    // gg = new Desc(50, "Idea 5", 5, g.getSSN());
    // g.addToList(gg);
    // gg = new Desc(50, "Idea 6", 6, g.getSSN());
    // g.addToList(gg);
    // gg = new Desc(50, "Idea 7", 7, g.getSSN());
    // g.addToList(gg);
    // gg = new Desc(50, "Idea 8", 8, g.getSSN());
    // g.addToList(gg);
    // gg = new Desc(50, "Idea 9", 9, g.getSSN());
    // g.addToList(gg);


  
    //System.out.println(b.getIdea(0));
    yggdrasil.insert(a);
    yggdrasil.insert(b);
    yggdrasil.insert(c);
    yggdrasil.insert(d);
    yggdrasil.insert(e);
    yggdrasil.insert(f);
    yggdrasil.insert(g);
    yggdrasil.insert(h);
    yggdrasil.insert(i);
    yggdrasil.insert(j);
    yggdrasil.insert(k);
    yggdrasil.insert(l);
    yggdrasil.insert(m);
    yggdrasil.insert(n);
    yggdrasil.insert(o);
    yggdrasil.insert(p);
    yggdrasil.insert(q);
    yggdrasil.insert(r);
    yggdrasil.insert(s);
    yggdrasil.insert(t);
    yggdrasil.insert(u);
    yggdrasil.insert(v);
    yggdrasil.insert(w);
    yggdrasil.insert(x);
    yggdrasil.insert(y);
    yggdrasil.insert(z);
    yggdrasil.insert(zz);
 
 
    try{

      FileOutputStream fileout = new FileOutputStream("BST.ser");
      ObjectOutputStream out = new ObjectOutputStream(fileout);
      out.writeObject(yggdrasil);
      out.close();
      fileout.close();
  }
  catch (IOException pop){
      pop.printStackTrace();

  }



 

  }


  
}
