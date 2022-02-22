import mymatome.*;

class Wordle{
  public static void main(String args[]){
    int n=5;
    String probS = "sixes";
    String ansS = "those";
    char[] prob = Trans.stocs(probS);
    char[] ans = Trans.stocs(ansS);
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
    Print.pr(aexist);
  }
}
