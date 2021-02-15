#include <bits/stdc++.h>
using namespace std;
#define ll long long;

int n, x;

int main(){
	cin.sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);
	cin >> n >> x;
	int coins[n];
	for(int i = 0 ; i < n ;i++){
		cin >> coins[i];
	}
	int dp[x+1];
	sort(coins, coins+n);
	dp[0] = 0;
	int min, spot;
	for(int i = 1; i <= x; i++){
		min = 99999999;
		for(int o = 0 ; o < n; o++){
			spot = i-coins[o];
			if(spot >= 0 && dp[spot] >= 0 && dp[spot] < min){
				min = dp[spot];
			}
		}
		if(min < 99999999){
			dp[i] = min+1;
		}
		else{
			dp[i] = -1;
		}
	}
	cout << dp[x];
	
}
