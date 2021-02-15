#include<bits/stdc++.h>
using namespace std;


int main(){
	cin.sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);
	int n, q;
	cin >> n >> q;
	int arr[n];
	for(int i = 0 ; i < n; i++){
		cin >> arr[i];
	}
	int rev[n];
	fill(rev, rev+n, 0);
	for(int i = 0 ; i < q; i++){
		int c, l, r;
		cin >> c >> l >> r;
		if(c == 1){
			int x;
			cin >> x;
			for(int o = l-1; o < r; o++){
				arr[o] += x;
			}
		}
		else{
			for(int o = l-1; o < r; o++){
				rev[o] += arr[o];
			}
		}
	}
	for(int i = 0 ;i  < n; i++){
		cout << rev[i] << " ";
	}
}
