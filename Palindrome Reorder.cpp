#include <bits/stdc++.h>
using namespace std;

int main(){
	cin.sync_with_stdio(0);
	cin.tie(0);
	string temp;
	cin >> temp;
	int count[26];
	for(int i = 0; i < 26; i++){
		count[i] = 0;
	}
	for(int i = 0 ; i < temp.length(); i++){
		count[temp.at(i)-65]++;
	}
	if(temp.length() % 2 == 0){
		bool broken = false;
		string entire = "";
		for(int i = 0 ; i < 26 && !broken; i++){
			if(count[i] % 2 == 1){
				broken = true;
			}
			else{
				int half = count[i]/2;
				char tempa = (char)(i+65);
				string front = string(half, tempa);
				entire += front;
				entire = front + entire;
			}
		}
		if(broken){
			cout << "NO SOLUTION";
		}
		else{
			cout << entire;
		}
	}
	else{
		int odd = -1;
		bool broken = false;
		for(int i = 0 ; i < 26 && !broken; i++){
			if(count[i]%2 == 1 && odd == -1){
				odd = i;
			}
			else if(count[i]%2 == 1 && odd != -1){
				broken = true;
			}
		}
		if(broken){
			cout << "NO SOLUTION";
		}
		else{
			string entire = string(count[odd], (char)(odd+65));
			for(int i = 0 ; i < 26; i++){
				if(odd != i){
					int half = count[i]/2;
					char tempa = (char)(i+65);
					string front = string(half, tempa);
					entire += front;
					entire = front + entire;
				}
			}
			cout << entire;
		}
	}
}
