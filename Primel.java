import mymatome.*;
import java.util.*;

class Primel{
  public static void main(String args[]){
    Input br = new Input();
    ArrayList<String> anslist = new ArrayList<>();
    ArrayList<String> list = new ArrayList<>();
    String str[] = FileRW.input("prime.txt").split("\n");
    for(String temp:str){
      anslist.add(temp);
      list.add(temp);
    }
    int n=list.get(0).length();
    int first=0;
    while(true){
      Print.pl(list.size());
      String maxS="";
      if(list.size()<=10){
        anslist=list;
      }
      if(first==0){
        maxS = "12953";
        first=1;
      }else{
        double max = -1;
        for(String ans:anslist){
          MyMap<String> map = new MyMap<>();
          for(String prob:list){
            int result[] = decide(prob,ans);
            map.add(is2s(result),1);
          }
          double d = func(n,0,new int[n],map,0,list.size());
          if(d>max){
            max=d;maxS=ans;
          }
        }
      }
      Print.pl(maxS);
      String ss[]=new String[0];
      int rnum[] = new int[n];
      while(true){
        while(ss.length!=n){
          Print.pr("input return >>");
          ss = br.readLine().split(" ");
        }
        boolean flg=true;
        for(int i=0;i<n;i++){
          if(!Trans.isNumber(ss[i])){
            flg=false;break;
          }else{
            rnum[i]=Trans.stoi(ss[i]);
            if(rnum[i]<0||2<rnum[i]){
              flg=false;break;
            }
          }
        }
        if(flg){break;}
        else{
          Print.pl("please number 0~2");
        }
      }
      if(all2(rnum)){break;}
      Iterator<String> it = list.iterator();
      while(it.hasNext()){
        String prob = it.next();
        int result[] = decide(prob,maxS);
        if(!same(rnum,result)){
          it.remove();
        }
      }
    }
  }

  public static double func(int n,int i,int a[],MyMap<String>map,double d,int size){
    if(i==n){
      if(!map.exist(is2s(a))){
        return d;
      }
      double p = (double)(map.get(is2s(a)))/size;
      d+=-p*(Math.log(p)/Math.log(2));
      return d;
    }else{
      for(int j=0;j<=2;j++){
        a[i]=j;
        d = func(n,i+1,a,map,d,size);
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
    int n = a.length;
    for(int i=0;i<n;i++){
      if(a[i]!=2){
        return false;
      }
    }
    return true;
  }

  public static boolean same(int a[],int b[]){
    int n = a.length;
    for(int i=0;i<n;i++){
      if(a[i]!=b[i]){
        return false;
      }
    }
    return true;
  }
}

class MyMap<K>{
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
