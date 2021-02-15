#include <bits/stdc++.h>
using namespace std;

int n;

int LCP(string s, string t){
	int num = min(s.size(), t.size());
	int counter = 0;
	for(int i = 0; i < num; i++){
		if(s[i] != t[i]){
			break;
		}
		counter++;
	}
	return counter;
}

int main(){
	cin.sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);
	cin >> n;
	for(int i = 0 ; i < n; i++){
		string temp;
		cin >> temp;
		int size = temp.size();
		string suffix[size];
		for(int o = 0 ; o < size; o++){
			suffix[o] = temp.substr(o);
		}
		sort(suffix, suffix+size);
		int count = suffix[0].size()+1;
		for(int o = 0; o < temp.size()-1; o++){
			count += suffix[o+1].size() - LCP(suffix[o], suffix[o+1]);
		}
		cout << count << "\n";
	}
	return 0;
}
