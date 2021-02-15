#include <bits/stdc++.h>
using namespace std;

const int mxN = 2e5;

int n, m;

int main(){
	cin.sync_with_stdio(0);
	cin.tie(0);
	cin >> n >> m;
	set<array<int, 2>> set;
	for(int i = 0 ; i < n ;i++){
		int temp;
		cin >> temp;
		set.insert({temp, i});
	}
	for(int i = 0 ; i < m; i++){
		int cust;
		cin >> cust;
		auto temp = set.lower_bound({cust+1, 0});
		if(temp == set.begin()){
			cout << "-1\n";
		}
		else{
			temp--;
			cout << (*temp)[0] << "\n";
			set.erase(temp);
		}
	}
}
