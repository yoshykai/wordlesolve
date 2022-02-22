package mymatome;

import java.util.*;
import java.io.*;

public class Input{
  private BufferedReader br;
  public Input(){
    br = new BufferedReader(new InputStreamReader(System.in));
  }
  private boolean canprint(int a){
    return 33<=a&&a<=126;
  }
  private int skipread(){
    int a=readC();
    while(a!=-1&&!canprint(a)){
      a=readC();
    }
    return a;
  }
  public char readC(){
    try{
      return (char)br.read();
    }catch(IOException e){
      e.printStackTrace();
      return (char)-1;
    }
  }
  public String readLine(){
    try{
      return br.readLine();
    }catch(IOException e){
      e.printStackTrace();
      return "";
    }
  }
  public String readS(){
    StringBuilder sb = new StringBuilder();
    int k = skipread();
    while(true){
      if(!canprint(k)){break;}
      sb.append((char)k);
      k = readC();
    }
    return sb.toString();
  }
  public int readI(){
    int r = 0;
    int k = skipread();
    int flg = 1;
    if(k=='-'){
      flg=-1;
      k=readC();
    }
    while(true){
      if(!canprint(k)){break;}
      r = r*10+(k-'0');
      k = readC();
    }
    return flg*r;
  }
  public long readL(){
    long r = 0;
    int k = skipread();
    int flg = 1;
    if(k=='-'){
      flg=-1;
      k=readC();
    }
    while(true){
      if(!canprint(k)){break;}
      r = r*10+(k-'0');
      k = readC();
    }
    return flg*r;
  }
  public String[] readSs(int n){
    String[]a = new String[n];
    for(int i=0;i<n;i++){a[i]=readS();}
    return a;
  }
  public int[] readIs(int n){
    int[]a = new int[n];
    for(int i=0;i<n;i++){a[i]=readI();}
    return a;
  }
  public long[] readLs(int n){
    long[]a = new long[n];
    for(int i=0;i<n;i++){a[i]=readL();}
    return a;
  }

}
