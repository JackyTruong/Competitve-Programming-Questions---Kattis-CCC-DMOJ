#include <bits/stdc++.h>
using namespace std;

const int mxN = 2e5;

int n, x, weights[mxN];

int main(){
	cin >> n >> x;
	for(int i = 0 ; i < n ; i++){
		cin >> weights[i];
	}
	sort(weights, weights+n);
	int output = 0;
	for(int i = 0, j = n-1; i < j;){
		while(i < j && weights[i] +weights[j] > x){
			j--;
		}
		if(i >= j){
			break;
		}
		output++;
		i++;
		j--;
	}
	cout << n-output;
}
