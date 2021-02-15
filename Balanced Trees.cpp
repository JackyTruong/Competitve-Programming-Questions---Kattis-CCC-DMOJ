#include <bits/stdc++.h>
using namespace std;
typedef long long ll;

int n;
unordered_map <int,ll> tree;

ll treeFind(int n){
	if(n == 1 || n == 2){
		return 1;
	}
	if(tree.count(n)){
		return tree[n];
	}
	ll total = 0;
	int w = n;
	while(w >= 2){
		int b = n/w;
		int a = n/(b+1);
		total += (w-a)*treeFind(b);
		w = a;
	}
	tree[n] = total;
	return total;
}


int main(){
	cin.sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);
	cin >> n;
	cout << treeFind(n);
}
