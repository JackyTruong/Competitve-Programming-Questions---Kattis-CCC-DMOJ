#include <bits/stdc++.h>
using namespace std;

int n;

int main(){
	cin.sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);
	cin >> n;
	set<array<int, 2>> s;
	for(int i = 0 ; i < n ;i++){
		int a, b;
		cin >>  a >> b;
		s.insert({2*a, 1});
		s.insert({2*b+1, -1});
	}
	int out = 0, temp = 0;
	for(array<int,2> a : s){
		temp += a[1];
		out = max(out, temp);
	}
	cout << out;
}
