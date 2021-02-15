#include<bits/stdc++.h>
using namespace std;

int main(){
	int n, k;
	cin >> n >> k;
	int arr[n];
	int dp[n];
	fill(dp, dp+n, 999999999);
	for(int i = 0 ; i < n; i++){
		cin >> arr[i];
	}
	dp[0] = 0;
	dp[1] = abs(arr[1]-arr[0]);
	for(int i = 2; i < n; i++){
		int val = dp[i];
		for(int o = 1 ; o <= k && i-o >= 0; o++){
			int val1 = abs(arr[i-o]-arr[i]) + dp[i-o];
			val = min(val, val1);
		}
		dp[i] = val;
	}
	cout << dp[n-1];
}
