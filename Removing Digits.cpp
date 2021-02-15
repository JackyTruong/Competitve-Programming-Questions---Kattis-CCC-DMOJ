#include <bits/stdc++.h>
using namespace std;

int n;

int main(){
	cin.sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);
	cin >> n;
	int dp[n+1];
	for(int i = 0 ; i < 10; i++){
		dp[i] = 1;
	}
	for(int i = 10; i <= n; i++){
		int temp = i;
		dp[i] = 99999999;
		while(temp){
			dp[i] = min(dp[i], dp[i-temp%10]+1);
			temp/=10;
		}
	}
	cout << dp[n];
}
