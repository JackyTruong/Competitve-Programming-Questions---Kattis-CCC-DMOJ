#include <bits/stdc++.h>
using namespace std;

const int mxN = 1e3, mxX = 1e5;

int n, x, h[mxN], s[mxN], dp[mxX+1];

int main(){
	cin.sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);
	cin >> n >> x;
	for(int i = 0 ; i < n ; i++){
		cin >> h[i];
	}
	for(int i = 0 ; i < n ;i++){
		cin >> s[i];
	}
	for(int i = 0 ; i < n ;i++){
		for(int o = x; o >= h[i]; o--){
			//cout << i << " " << o << " " << dp[o] << " " << dp[o-h[i]]+s[i] << " this \n";
			dp[o] = max(dp[o], dp[o-h[i]] + s[i]);
		}
	}
	cout << dp[x];
}
