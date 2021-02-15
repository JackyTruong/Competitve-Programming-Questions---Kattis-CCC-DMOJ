#include <bits/stdc++.h>
using namespace std;

int main(){
	cin.sync_with_stdio(0);
	cin.tie(0);
	int n;
	cin >> n;
	long long total = n;
	for(int i = 0 ; i < n-1; i++){
		total += i+1;
		int temp;
		cin >> temp;
		total -= temp;
	}
	cout << total;
	
}
