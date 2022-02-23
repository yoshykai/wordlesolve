import mymatome.*;
import java.util.*;

class Dordle{
  static int n;
  static int count;
  static MyMap<String> map;
  public static void main(String args[]){
    Input br = new Input();
    count = 4;
    ArrayList<String> anslist = new ArrayList<>();
    ArrayList<ArrayList<String>> list = new ArrayList<>();
    for(int i=0;i<count;i++){
      list.add(new ArrayList<>());
    }
    String str[] = FileRW.input("dordle1.txt").split("\n");
    for(String temp:str){
      anslist.add(temp);
      for(int i=0;i<count;i++){
        list.get(i).add(temp);
      }
    }
    str = FileRW.input("dordle2.txt").split("\n");
    for(String temp:str){
      anslist.add(temp);
    }
    n=anslist.get(0).length();
    int first = 0;
    boolean okFlg[]=new boolean[count];
    while(true){
      for(int i=0;i<count;i++){
        Print.pr(list.get(i).size()+" ");
      }
      Print.n();
      String maxS="";
      if(allgrean(list)){
        for(int i=0;i<count;i++){
          Print.pr(list.get(i).get(0)+" ");
        }
        Print.n();
        break;
      }
      /*if(list1.size()<=2&&list2.size()<=2){
        anslist.clear();
        for(String temp:list1){
          anslist.add(temp);
        }
        for(String temp:list2){
          anslist.add(temp);
        }
      }*/
      if(first==0){
        maxS = "soare";
        first=1;
      }else{
        boolean flg=true;
        for(int i=0;i<count;i++){
          if(list.get(i).size()==1&&!okFlg[i]){
            flg=false;
            maxS = list.get(i).get(0);
            break;
          }
        }
        if(flg){
          for(int i=0;i<count;i++){
            if(list.get(i).size()==2){
              flg=false;
              double max = -1;
              for(String ans:list.get(i)){
                double d=entropy(ans,list);
                if(d>max){
                  max=d;maxS=ans;
                }
              }
              break;
            }
          }
        }
        if(flg){
          double max = -1;
          for(String ans:anslist){
            double d=entropy(ans,list);
            if(d>max){
              max=d;maxS=ans;
            }
          }
        }
      }
      Print.pl(maxS);
      int rnum[][] = new int[count][n];
      while(true){
        String stemp=" ";
        while(stemp.length()!=n*count&&stemp.length()!=0){
          Print.pr("input return >>");
          stemp = br.readLine();
        }
        if(stemp.length()==0){
          System.exit(0);
        }
        boolean flg=true;
        for(int i=0;i<n*count;i++){
          if(!Trans.isNumber(stemp.substring(i,i+1))){
            flg=false;break;
          }else{
            rnum[i/n][i%n]=Trans.stoi(stemp.substring(i,i+1));
            if(rnum[i/n][i%n]<0||2<rnum[i/n][i%n]){
              flg=false;break;
            }
          }
        }
        if(flg){break;}
        else{
          Print.pl("please number 0~2");
        }
      }
      for(int i=0;i<count;i++){
        Iterator<String> it = list.get(i).iterator();
        if(!okFlg[i]){
          while(it.hasNext()){
            String prob = it.next();
            int result[] = decide(prob,maxS);
            if(!same(rnum[i],result)){
              it.remove();
            }
          }
        }
        if(all2(rnum[i])){
          okFlg[i] = true;
        }
      }
    }
  }

  public static double entropy(String ans,ArrayList<ArrayList<String>> list){
    double d = 0;
    for(int i=0;i<count;i++){
      map = new MyMap<>();
      for(String prob:list.get(i)){
        int result[] = decide(prob,ans);
        map.add(is2s(result),1);
      }
      d = func(0,new int[n],d,list.get(i));
    }
    return d;
  }

  public static double func(int i,int a[],double d,ArrayList<String>list){
    if(i==n){
      if(!map.exist(is2s(a))){
        return d;
      }
      double p = (double)(map.get(is2s(a)))/list.size();
      d+=-p*(Math.log(p)/Math.log(2));
      return d;
    }else{
      for(int j=0;j<=2;j++){
        a[i]=j;
        d = func(i+1,a,d,list);
      }
      return d;
    }
  }

  public static int[] decide(String probS,String ansS){
    char[] prob = Trans.stocs(probS);
    char[] ans = Trans.stocs(ansS);
    int n = ans.length;
    int pexist[] = new int[n];
    int aexist[] = new int[n];
    for(int i=0;i<n;i++){
      if(prob[i]==ans[i]){
        aexist[i]=2;
        pexist[i]=1;
      }
    }
    for(int i=0;i<n;i++){
      if(aexist[i]!=0){continue;}
      for(int j=0;j<n;j++){
        if(pexist[j]!=0){continue;}
        if(ans[i]==prob[j]){
          aexist[i]=1;
          pexist[j]=1;
          break;
        }
      }
    }
    return aexist;
  }

  public static String is2s(int a[]){
    int n=a.length;
    String s = "";
    for(int i=0;i<n;i++){
      s=s+a[i];
    }
    return s;
  }

  public static boolean all2(int a[]){
    for(int i=0;i<n;i++){
      if(a[i]!=2){
        return false;
      }
    }
    return true;
  }

  public static boolean allgrean(ArrayList<ArrayList<String>> list){
    for(int i=0;i<count;i++){
      if(list.get(i).size()>1){
        return false;
      }
    }
    return true;
  }

  public static boolean same(int a[],int b[]){
    for(int i=0;i<n;i++){
      if(a[i]!=b[i]){
        return false;
      }
    }
    return true;
  }

  static class MyMap<K>{
    HashMap<K,Integer> map;
    public MyMap(){
      map = new HashMap<>();
    }

    public void add(K key,int value){
      if(map.containsKey(key)){
        map.replace(key,map.get(key)+value);
      }else{
        map.put(key,value);
      }
    }

    public int get(K key){
      return map.get(key);
    }

    public boolean exist(K key){
      return map.containsKey(key);
    }

    public void remove(K key){
      map.remove(key);
    }
  }
}
