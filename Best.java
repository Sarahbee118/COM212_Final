import java.io.Serializable;
import java.io.*;

public class Best implements Serializable {
    private int n;
    private Desc heap[];
    private int cap;

    public Best(){
        n = 0;
        cap = 511;
        heap = new Desc[cap];
    }

    public boolean isEmpty(){
        return n == 0;
    }

    public Desc findMax(){
        return heap[0];
    }

    public void insert(Desc x){
        heap[n] = x;   //setting end of heap to node inserted
        int pos = n;        
        while (heap[pos].getScore() > heap[getParent(pos)].getScore()){   //compare to parent
            swap(pos, getParent(pos)); //swap nodes when proper position is found
            pos = getParent(pos);
        }
        n++;
    }

     public Desc deleteMax(){
         Desc removed = heap[0];   //set variable 'removed' to p[0]
         heap[0] = heap[--n];         //set curr to end of heap
         sortDown(0);           //sort the heap 
         return removed;        //return original max
    }

    public int leftChild(int i){    //helper functions
        return (2*i) + 1;       
    }

    public int rightChild(int i){
        return (2*i) + 2;
    }

    public int getParent(int i){
        return (i-1)/2;
    }

    public void swap(int x, int y){
        Desc temp = heap[x];              
        heap[x] = heap[y];
        heap[y] = temp;
    }

    private boolean hasRight(int i){
        return rightChild(i) < n;
    }

    private boolean hasLeft(int i){
        return leftChild(i) < n;
    }

    public void sortDown(int i){
        int leftChild = leftChild(i);
        int rightChild = rightChild(i); 
        int max = i;    

        if(hasLeft(i) && heap[leftChild].getScore() > heap[max].getScore()){ 
            max = leftChild;    //if so max = left child
        }
        if(hasRight(i) && heap[rightChild].getScore() > heap[max].getScore()){  
            max = rightChild;                                                   
        }
        if(heap[max] != heap[i]){
            swap(i , max);
            sortDown(max);
        }
    }
}