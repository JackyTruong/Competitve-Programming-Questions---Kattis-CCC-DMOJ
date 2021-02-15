#include<bits/stdc++.h>
using namespace std;

const int M = 1e9+7;

int main(){
	cin.sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);
	string s;
	cin >> s;
	int used[26];
	fill(used, used+26, 1);
	for(int i = 0 ; i < s.length(); i++){
		used[s[i]-97]++;
	}
	long long count = 1;
	for(int i = 0 ; i < 26; i++){
		used[i]%=M;
		count *= used[i];
		count %= M;
	}
	
	cout << count << "\n";
}
