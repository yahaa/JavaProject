#include <iostream>
#include <algorithm>
#include <cmath>
using namespace std;
typedef long long ll;
ll a[32];
int main(){
	for(int i=0;i<=31;i++)a[i]=pow(2,i);
	int t;
	cin>>t;
	while(t--){
		ll n,m;
		cin>>n>>m;
		int ans=0;
		if(m>=31)m=31;
		for(int i=m;i>=0;i--){
			ans+=n/a[i];
			n%=a[i];
		}
		cout<<ans<<endl;
	}
	return 0;
}