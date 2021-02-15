#include<bits/stdc++.h>
using namespace std;

int t;

int main(){
	cin >> t;
	for(int a = 0; a < t; a++){
		int n, k;
		cin >> n >> k;
		int base[n];
		int danger = 0;
		for(int i = 0 ; i < n; i++){
			cin >> base[i];
		}
		for(int i = 0 ; i < n-1; i++){
			//cout << abs(base[i]-base[i+1]) << " ";
			danger = max(danger, abs(base[i]-base[i+1]));
		}
		cout << danger << "\n";
	}
}
