#include <bits/stdc++.h>
using namespace std;

string base;

void combinations(string soFar, bool used[], unordered_map<string, int> &map, vector<string> &output){
	bool all = true;
	for(int i = 0 ; i < base.length();i ++){
		if(!used[i]){
			all = false;
		}
	}
	if(!all){
		for(int i = 0 ; i < base.length();i++){
			if(!used[i]){
				used[i] = true;
				combinations(soFar + base[i], used, map, output);
				used[i] = false;
			}
		}
	}
	else{
		if(map.find(soFar) == map.end()){
			map.emplace(soFar, map.size());
			output.push_back(soFar);
		}
	}
}

int main(){
	cin.sync_with_stdio(0);
	cin.tie(0);
	unordered_map<string, int> map;
	vector<string> output;
	cin >> base;
	combinations("", new bool[base.length()], map, output);
	sort(output.begin(), output.begin() + output.size());
	cout << output.size() << "\n";
	for(int i = 0 ; i < output.size(); i++){
		cout << output.at(i) << "\n";
	}
}
