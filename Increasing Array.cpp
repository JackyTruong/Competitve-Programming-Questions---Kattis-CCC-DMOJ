#include <bits/stdc++.h>
using namespace std;

const int mxN = 2e5;

int n, arr[mxN];

int main(){
	cin.sync_with_stdio(0);
	cin.tie(0);
	cin >> n;
	for(int i = 0; i < n ;i++){
		cin >> arr[i];
	}
	long long moves = 0;
	for(int i = 1; i < n; i++){
		if(arr[i] < arr[i-1]){
			long temp = arr[i-1] - arr[i];
			arr[i] += temp;
			moves += temp;
		}
	}
	
	cout << moves;
	
}
