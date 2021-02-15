#include <bits/stdc++.h>
using namespace std;

int main(){
	cin.sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);
	int n, m;
	cin >> n >> m;
	string s, t;
	cin >> s >> t;
	vector<vector<int>> spotLet;
	bool letS[26];
	bool letT[26];
	fill(letS, letS+26, false);
	fill(letT, letT + 26, false);
	for(int i = 0 ; i < 26; i++){
		vector<int> temp;
		spotLet.push_back(temp);
	}
	for(int i = 0 ; i < n ; i++){
		letS[s[i]-97] = true;
		spotLet[s[i]-97].push_back(i);
	}
	for(int i = 0 ; i < m; i++){
		letT[t[i]-97] = true;
	}
	bool hasLets = true;
	for(int i = 0 ; i < 26; i++){
		if(letT[i] == true && letS[i] == false){
			hasLets = false;
		}
	}
	if(hasLets){
		long long count = 0;
		string temp = "";
		int spotInT = 0;
		int spotInS = 0;
		while(temp.compare(t) != 0){
			bool foundAfter = false;
			//cout << temp << " " << t << "\n";
			for(int i = 0 ; i < spotLet[t[spotInT]-97].size() && !foundAfter; i++){
				if(spotLet[t[spotInT]-97][i] >= spotInS){
					temp += t[spotInT];
					count += spotLet[t[spotInT]-97][i] - spotInS;
					spotInS = spotLet[t[spotInT]-97][i]+1;
					count++;
					foundAfter = true;
					spotInT++;
					
					break;
				}
			}
			if(!foundAfter){
				count += n-spotInS;
				count += spotLet[t[spotInT]-97][0];
				spotInS = spotLet[t[spotInT]-97][0]+1;
				count++;
				temp += t[spotInT];
				spotInT++;
			}
		}
		cout << count << "\n";
	}
	else{
		cout << -1 << "\n";
	}
	
}
