#include <cstdio>
#include <algorithm>
#include <iostream>
#include <string>
#include <cstring>
#include <cmath>
using namespace std;

const int MAXN=50;

int a[MAXN][MAXN];//增广矩阵
int x[MAXN];//解集
bool free_x[MAXN];//标记是否是不确定的变元


inline int gcd(int a,int b){
    int t;
    while(b!=0){
        t=b;
        b=a%b;
        a=t;
    }
    return a;
}

inline int lcm(int a,int b){
    return a/gcd(a,b)*b;//先除后乘防溢出
}



// 高斯消元法解方程组(Gauss-Jordan elimination).(-2表示有浮点数解，但无整数解，
//-1表示无解，0表示唯一解，大于0表示无穷解，并返回自由变元的个数)
//有equ个方程，var个变元。增广矩阵行数为equ,分别为0到equ-1,列数为var+1,分别为0到var.
int gauss(int equ,int var){
    int i,j,k;
    int max_r;// 当前这列绝对值最大的行.
    int col;//当前处理的列
    int ta,tb;
    int LCM;
    int temp;
    int free_x_num;
    int free_index;

    for(int i=0;i<=var;i++){
        x[i]=0;
        free_x[i]=1;
    }

    col=0;
    for(k = 0;k < equ && col < var;k++,col++){
        max_r=k;
        for(i=k+1;i<equ;i++){
            if(abs(a[i][col])>abs(a[max_r][col])) max_r=i;
        }
        if(max_r!=k){
            for(j=k;j<var+1;j++)swap(a[k][j],a[max_r][j]);
        }
        if(a[k][col]==0){
            k--;
            continue;
        }
        for(i=k+1;i<equ;i++){
            if(a[i][col]!=0){
                for(j=col;j<var+1;j++){
                    a[i][j] ^= a[k][j];
                }
            }
        }
    }

    for (i = k; i < equ; i++){ 
        if (a[i][col] != 0)return -1;
    }
    return var-k;
}

int s[MAXN],e[MAXN];

int main(void){
	int t;
	cin>>t;
	while(t--){
		int n;
		cin>>n;
		for(int i=0;i<n;i++)cin>>s[i];
		for(int i=0;i<n;i++)cin>>e[i];
		int u,v;
		memset(a,0,sizeof(a));
		while(cin>>u>>v){
			if(u==0&&v==0)break;
			a[v-1][u-1]=1;
		}
		for(int i=0;i<n;i++)a[i][i]=1;
		for(int i=0;i<n;i++){
			a[i][n]=s[i]^e[i];
		}
		int ans=gauss(n,n);
		if(ans==-1)cout<<"Oh,it's impossible~!!"<<endl;
		else cout<<(1<<ans)<<endl;
	}

    return 0;
}