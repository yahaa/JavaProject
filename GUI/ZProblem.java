import java.util.*;
import java.io.BufferedInputStream;
public class ZProblem {
    private int nn;
    private int cc;
    private int bestww;
    private int[] ww;
    private int[] xx;
    private int[] bestxx;
    private boolean f=false;
    private Scanner input=new Scanner(new BufferedInputStream(System.in));
     
    public int maxLoadingRE(int[] w, int c, int[] bestx){
        nn = w.length;
        cc = c;
        bestww = 0;
        ww = w;
        bestxx = bestx;
        xx = new int[nn];
        int r = 0;
        for (int i = 0; i < nn; i++){
            r += ww[i];
        }
        trackback(0, 0, r);
        trackback1(0,0,r);
        return bestww;
    }
     
    private void trackback(int i, int cw, int r){
        if(i==nn){
            if(cw>bestww)bestww=cw;
            return;
        }
        if(cw+ww[i]<=cc){
            xx[i]=1;
            trackback(i + 1, cw + ww[i], r);
        }
        xx[i]=0;
        trackback(i+1, cw, r-ww[i]);
    }


    private void trackback1(int i, int cw, int r){
        if(f)return;
        if(i==nn){
            if(cw==bestww){
                for (int j=0;j<nn;j++)bestxx[j]=xx[j];
                f=true;
            }
            return;
        }
                
        if(cw+ww[i]<=cc){
            xx[i]=1;
            trackback1(i + 1, cw + ww[i], r);
        }
        
        xx[i]=0;
        trackback1(i+1, cw, r-ww[i]);
    }
    private int maxLoading(int[] w, int c, int[] bestx) {
        int i = 0;
        int n = w.length;
        int[] x = new int[n];
        Arrays.fill(x, -1);
         
        int bestw = 0;
        int[] cw = new int[n];
        int[] r = new int[n];
        int tor = 0;
        for (int item : w)tor += item;
        r[0] = tor;
        cw[0] = 0;
        while (i>-1){
            do{
                x[i] += 1;
                if (x[i]==0){
                    if (cw[i]+w[i]<=c) {
                        if (i<n-1){
                            cw[i + 1] = cw[i] + w[i];
                            r[i + 1] = r[i];
                        }
                        break;
                    }
                }
                else {
                    if(r[i]-w[i]>bestw){
                        if (i<n-1) {
                            r[i+1]=r[i]-w[i];
                            cw[i+1]=cw[i];
                        }
                        break;
                    }
                }
            }while (x[i]<2);
            
            if (x[i]<2){
                if (i==n-1){
                    for (int j = 0; j < n; j++)bestx[j] = x[j];
                    if (x[i] == 0)
                        bestw = cw[i] + w[i];
                    else
                        bestw = cw[i]; 
                }
                else{
                    i++;
                    x[i] = -1;
                }
           }
           else i--;
        }
      
        return bestw;
    }
    public void solve(){
        int tt=1;
        
        while(input.hasNext()){
            f=false;
            int n=input.nextInt();
            int []w=new int[n];
            for(int i=0;i<n;i++)w[i]=input.nextInt();
            int c1=input.nextInt();
            int c2=input.nextInt();
            int []bestx = new int[n];
            int bestw = maxLoadingRE(w, c1, bestx);
            int tc1=0,tc2=0;
            for(int i=0;i<n;i++){
                if(bestx[i]==1)tc1+=w[i];
                else tc2+=w[i];
            }

            System.out.println("Case "+tt++);
            if(tc1<=c1&&tc2<=c2){
                System.out.print(bestw+" ");
                for(int i=0;i<n;i++)System.out.print(bestx[i]);
            }
            else System.out.print("No");
            System.out.println();
        }
        
    }

    public static void main(String[]args){
        ZProblem a=new ZProblem();
        a.solve();
    }
}
     