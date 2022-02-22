package mymatome;

import java.util.*;
import java.io.*;

public class FileRW {
  public static File makeFile(String str){
    return new File(str);
  }

  public static String input(String name){
    try{
      File file = makeFile(name);
      if(cheakReadFile(file)){
        BufferedReader brf = new BufferedReader(new FileReader(file));
        StringBuilder sb = new StringBuilder();
        String str=brf.readLine();
        while(str!=null){
          sb.append(str+"\n");
          str = brf.readLine();
        }
        brf.close();
        return sb.toString();
      }else{
        System.out.println("ファイルが存在しないか開けません");
        System.exit(0);
      }
    }catch(IOException e){
      e.printStackTrace();
      System.exit(0);
    }
    return null;
  }

  public static void output(String name,String str){
    try{
      File file = makeFile(name);
      if(cheakWriteFile(file)){
        BufferedWriter bwf = new BufferedWriter(new FileWriter(file));
        bwf.write(str);
        bwf.newLine();
        bwf.close();
      }else{
        System.out.println("ファイルが開けません");
        System.exit(0);
      }
    }catch(IOException e){
      e.printStackTrace();
      System.exit(0);
    }
  }

  private static boolean cheakReadFile(File file){
    if (file.exists()){
      if (file.isFile() && file.canRead()){
        return true;
      }
    }
    return false;
  }

  private static boolean cheakWriteFile(File file){
    if (file.exists()){
      if (file.isFile() && file.canWrite()){
        return true;
      }
    }else{
      try{
        if(file.createNewFile()){
          return cheakWriteFile(file);
        }
      }catch(IOException e){
        e.printStackTrace();
      }
    }
    return false;
  }
}
