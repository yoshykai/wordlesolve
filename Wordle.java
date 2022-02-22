import mymatome.*;
import java.util.*;

class Wordle{
  public static void main(String args[]){
    Input br = new Input();
    ArrayList<String> anslist = new ArrayList<>();
    ArrayList<String> list = new ArrayList<>();
    String str[] = FileRW.input("wordle1.txt").split("\n");
    for(String temp:str){
      anslist.add(temp);
      list.add(temp);
    }
    str = FileRW.input("wordle2.txt").split("\n");
    for(String temp:str){
      anslist.add(temp);
    }
    int n=list.get(0).length();
    WordleCore wc = new WordleCore(n,anslist,list);
    wc.solve("soare");
  }
}
