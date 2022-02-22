package mymatome;

import java.util.*;

public class Print{ //出力関数(System.out...を打ちたくない人用)
  public static <T>void pr(T str){ //改行しない方
    System.out.print(str);
  }
  public static void pr(boolean flg,String a,String b){
    if(flg){
      pr(a);
    }else{
      pr(b);
    }
  }
  public static <T>void pl(T str){ //改行する方
    System.out.println(str);
  }
  public static void pl(boolean flg,String a,String b){
    if(flg){
      pl(a);
    }else{
      pl(b);
    }
  }
  public static void pr(short[]a){
    int s = a.length;
    pr(a[0]);
    for(int i=1;i<s;i++){
      sp();
      pr(a[i]);
    }
    n();
  }
  public static void pr(int[]a){
    int s = a.length;
    pr(a[0]);
    for(int i=1;i<s;i++){
      sp();
      pr(a[i]);
    }
    n();
  }
  public static void pr(Integer[]a){
    int s = a.length;
    pr(a[0]);
    for(int i=1;i<s;i++){
      sp();
      pr(a[i]);
    }
    n();
  }
  public static void pr(String[]a){
    int s = a.length;
    pr(a[0]);
    for(int i=1;i<s;i++){
      sp();
      pr(a[i]);
    }
    n();
  }
  public static void pr(double[]a){
    int s = a.length;
    pr(a[0]);
    for(int i=1;i<s;i++){
      sp();
      pr(a[i]);
    }
    n();
  }
  public static void pr(short[][] a){ //2次元配列の出力
    for(short i[]:a){
      pr(i);
    }
  }
  public static void pr(int[][] a){ //2次元配列の出力
    for(int i[]:a){
      pr(i);
    }
  }
  public static void pr(String[][] a){ //2次元配列の出力
    for(String s[]:a){
      pr(s);
    }
  }
  public static void pr(double[][] a){ //2次元配列の出力
    int s = a.length;
    for(double d[]:a){
      pr(d);
    }
  }
  public static <T>void pr(ArrayList<T>list){ //リストの出力
    int s = list.size();
    for(int i=0;i<s;i++){
      pr(list.get(i));
      if(i!=s-1){
        sp();
      }
    }
    n();
  }
  public static void pr(boolean flg[],String a,String b){
    int n = flg.length;
    pr(flg[0],a,b);
    for(int i=1;i<n;i++){
      sp();pr(flg[i],a,b);
    }
    n();
  }
  public static void pr(boolean flg[][],String a,String b){
    for(boolean f[]:flg){
      pr(f,a,b);
    }
  }
  public static void n(){ //改行
    System.out.println("");
  }
  public static void sp(){ //空白
    System.out.print(" ");
  }
}
