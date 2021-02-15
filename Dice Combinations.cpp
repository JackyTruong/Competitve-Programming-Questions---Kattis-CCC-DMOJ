#include <bits/stdc++.h>
using namespace std;
#define ll long long;

const int mxN = 1e6, M =1e9+7;

int n;
long dp[mxN+1];

int main(){
	cin >> n;
	dp[0] = 1;
	for(int i = 1; i <= n; i++){
		for(int o = 1; o <= min(6, i); o++){
			dp[i] = (dp[i] + dp[i-o])%M;
		}
	}
	cout << dp[n];
}
