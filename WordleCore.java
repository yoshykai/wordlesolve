import mymatome.*;
import java.util.*;
public class WordleCore{
  int n;
  ArrayList<String> anslist,list;
  MyMap<String> map;
  Input br;

  public WordleCore(int n,ArrayList<String> ans,ArrayList<String> l){
    this.n = n;
    anslist = ans;
    list = l;
    br=new Input();
  }

  public void solve(String firstS){
    int first=0;
    if(firstS.equals("")){
      first=1;
    }
    while(true){
      Print.pl(list.size());
      String maxS="";
      if(list.size()<=10){
        anslist=list;
      }
      if(first==0){
        maxS = firstS;
        first=1;
      }else{
        double max = -1;
        for(String ans:anslist){
          map = new MyMap<>();
          for(String prob:list){
            int result[] = decide(prob,ans);
            map.add(is2s(result),1);
          }
          double d = func(0,new int[n],0);
          if(d>max){
            max=d;maxS=ans;
          }
        }
      }
      Print.pl(maxS);
      int rnum[] = new int[n];
      while(true){
        String stemp=" ";
        while(stemp.length()!=n&&stemp.length()!=0){
          Print.pr("input return >>");
          stemp = br.readLine();
        }
        if(stemp.length()==0){
          System.exit(0);
        }
        boolean flg=true;
        for(int i=0;i<n;i++){
          if(!Trans.isNumber(stemp.substring(i,i+1))){
            flg=false;break;
          }else{
            rnum[i]=Trans.stoi(stemp.substring(i,i+1));
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

  public double func(int i,int a[],double d){
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
        d = func(i+1,a,d);
      }
      return d;
    }
  }

  public int[] decide(String probS,String ansS){
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

  public String is2s(int a[]){
    int n=a.length;
    String s = "";
    for(int i=0;i<n;i++){
      s=s+a[i];
    }
    return s;
  }

  public boolean all2(int a[]){
    int n = a.length;
    for(int i=0;i<n;i++){
      if(a[i]!=2){
        return false;
      }
    }
    return true;
  }

  public boolean same(int a[],int b[]){
    int n = a.length;
    for(int i=0;i<n;i++){
      if(a[i]!=b[i]){
        return false;
      }
    }
    return true;
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
}
