#include<bits/stdc++.h>
using namespace std;

int main(){
	cin.sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);
	int n, q;
	cin >> n >> q;
	long long arr[100001];
	fill(arr, arr+100001, 0);
	for(int i = 0; i < n; i++){
		long long temp;
		cin >> temp;
		arr[temp]++;
	}
	for(int i = 0 ; i < q; i++){
		long long c1, c2;
		cin >> c1 >> c2;
		if(c1 == 1){
			long long half = c2/2;
			long long oH = c2-half;
			arr[half] += arr[c2];
			arr[oH] += arr[c2];
			arr[c2] = 0;
		}
		else{
			cout << arr[c2] << "\n";
		}
	}
}
