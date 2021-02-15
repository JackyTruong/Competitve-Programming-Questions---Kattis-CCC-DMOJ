#include<bits/stdc++.h>
using namespace std;
#define ll long long
 
const int M = 1e9+7, mxN = 1e6;
 
int n, x;
long dp[mxN+1];
 
int main(){
	cin.sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);
	cin >> n >> x;
	int coins[n];
	for(int i = 0 ; i < n ;i++){
		cin >> coins[i];
	}
	dp[0] = 1;
	for(int o = 0; o < n; o++){
	for(int i = 1; i <= x; i++){
		
			if(coins[o] <= i){
				dp[i] = (dp[i] + dp[i-coins[o]])%M;
			}
		}
	}
	cout << dp[x];
}
