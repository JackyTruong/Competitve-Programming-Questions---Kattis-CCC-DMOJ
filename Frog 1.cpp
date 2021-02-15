#include<bits/stdc++.h>
using namespace std;

int main(){
	int n;
	cin >> n;
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
		int val1 = abs(arr[i-1]-arr[i]) + dp[i-1];
		int val2 = abs(arr[i-2]-arr[i]) + dp[i-2];
		val = min(val, val1);
		val = min(val, val2);
		dp[i] = val;
	}
	cout << dp[n-1];
}
