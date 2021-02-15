#include <bits/stdc++.h>
using namespace std;

int main(){
	cin.sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);
	string big, pat;
	cin >> big >> pat;
	int size = pat.size();
	int bigsize = big.size();
	int count = 0;
	for(int i = 0 ; i < bigsize-size+1; i++){
		if(big[i] == pat[0]){
			string temp = big.substr(i, size);
			if(temp == pat){
				count++;
			}
		}	
	}
	cout << count;
}
