package mymatome;

import java.util.regex.*;

public class Trans{
  public static int stoi(String s){
    return Integer.parseInt(s);
  }
  public static int[] stoi(String s[]){
    int a[]=new int[s.length];
    for(int i=0;i<s.length;i++){
      a[i]=stoi(s[i]);
    }
    return a;
  }
  public static long stol(String s){
    return Long.parseLong(s);
  }
  public static long[] stol(String s[]){
    long a[]=new long[s.length];
    for(int i=0;i<s.length;i++){
      a[i]=stol(s[i]);
    }
    return a;
  }
  public static String itos(int i){
    return String.valueOf(i);
  }
  public static String[] itos(int[] a){
    String s[]=new String[a.length];
    for(int i=0;i<a.length;i++){
      s[i]=itos(a[i]);
    }
    return s;
  }
  public static int[] Itoi(Integer a[]){
    int[]result=new int[a.length];
    for(int i=0;i<a.length;i++){
      result[i]=a[i];
    }
    return result;
  }
  public static Integer[] itoI(int a[]){
    Integer[]result=new Integer[a.length];
    for(int i=0;i<a.length;i++){
      result[i]=a[i];
    }
    return result;
  }
  public static String ctos(char c){
    return String.valueOf(c);
  }
  public static String cstos(char[] c){
    return new String(c);
  }
  public static char stoc(String s){
    return s.charAt(0);
  }
  public static char[] stocs(String s){
    return s.toCharArray();
  }
  static final Pattern p = Pattern.compile("\\A[-]?[0-9]+\\z");
  public static boolean isNumber(String s){
    Matcher m = p.matcher(s);
    return m.find();
  }
}
