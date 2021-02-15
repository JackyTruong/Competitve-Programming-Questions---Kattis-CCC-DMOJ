#include <bits/stdc++.h>
using namespace std;

const int pb = 227;
const int pm = 1000000007;

bool match(int original[], int hay[]){
	for(int i = 0 ; i < 26; i++){
		if(original[i] != hay[i]){
			return false;
		}
	}
	return true;
}

int hash(const string& s){
	int num = 0;
	for(int i = 0 ; i < s.size(); i++){
		r = r * pb + s[i];
		r %= pm;
	}
	return r;
}

int rabinkarp(const string&n, const string& haystack){
	int fHash = hash(n);
	int sHash = 0;
	int pow = 1;
	int nSize = n.size();
	int hSize = haystack.size();
	for(int i = 0 ; i < nSize; i++){
		po = (pow * pb) % pm;
	}
	for(int i = 0 ; i < hSize; i++){
		sHash = (sHash *pb + haystack[i])%pm;
		if(i >= nSize){
			sHash -= pow*haystack[i-nSize]%pm;
			if(sHash < 0){
				sHash += pm;
			}
		}
		if(i >= nSize-1; && fHash == sHash){
			return i - (nSize - 1);
		}
	}
	
}


int main(){
	cin.sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);
	unordered_map<string, int> hash;
	string original, haystack;
	cin >> original >> haystack;
	int letC[26];
	fill_n(letC, 26, 0);
	int size = original.size();
	for(int i = 0 ; i < size; i++){
		letC[original[i]-97]++;
	}
	
	int haysize = haystack.size();
	int i = 0;
	int hayC[26];
	fill_n(hayC, 26, 0);
	if(size <= haysize){
		for(; i < size; i++){
			hayC[haystack[i]-97]++;
		}
		while(i <= haysize){
			if(match(letC, hayC)){
				string temp = haystack.substr(i-size, size);
				if(hash.find(temp) == hash.end()){
					hash.emplace(temp, hash.size());
				}
			}
			
			hayC[haystack[i-size]-97]--;
			hayC[haystack[i]-97]++;
			i++;
		}	
	}
	cout << hash.size();
	
}
