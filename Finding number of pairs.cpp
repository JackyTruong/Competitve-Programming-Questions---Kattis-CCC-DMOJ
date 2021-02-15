#include <bits/stdc++.h>
using namespace std;

const int mod = 1e9+7;

int n, m;

int main(){
	cin.sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);
	cin >> n >> m;
	int arr[n];
	for(int i = 0 ; i < n ;i++){
		cin >> arr[i];
	}
	sort(arr, arr+n);
	int pairs = 0;
	int prevStop = n-1;
	for(int i = 0 ; i < n-1; i++){
		int r = prevStop;
		while(i < r){
			if(arr[i] + arr[r] > m){
				r--;
			}
			else{
				pairs += r-i;
				prevStop = r;
				pairs %= mod;
				break;
			}
		}
	}
	cout << pairs;
}
