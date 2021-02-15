#include <bits/stdc++.h>
using namespace std;

const int M = 1e9+7, mxN = 1e3;

int n, dp[mxN][mxN];
string s[mxN];

int main(){
	cin.sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);
	cin >> n;
	for(int i = 0 ; i < n; i++){
		cin >> s[i]; 
	}
	dp[0][0] = 1;
	for(int i = 0 ; i < n; i++){
		for(int o = 0 ; o < n; o++){
			if(i){
				dp[i][o] = dp[i-1][o];
			}
			if(o){
				dp[i][o] += dp[i][o-1];
			}
			dp[i][o]%=M;
			if(s[i][o] == '*'){
				dp[i][o] = 0;
			}
		}
	}
	cout << dp[n-1][n-1];
}
