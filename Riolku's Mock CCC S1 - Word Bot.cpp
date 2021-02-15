#include<bits/stdc++.h>
using namespace std;

int main(){
	cin.sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);
	int n, c, v;
	cin >> n >> c >> v;
	string s;
	cin >> s;
	int countC = 0;
	int countV = 0;
	bool fake = false;
	for(int i = 0 ; i < n; i++){
		char let = s[i];
		if(let == 'a' || let == 'e' || let == 'i' || let == 'o' || let == 'u' ){
			countC = 0;
			countV++;
		}
		else if(let == 'y'){
			countC++;
			countV++;
		}
		else{
			countV = 0;
			countC++;
		}
		if(countC > c || countV > v){
			fake = true;
			break;
		}
	}
	if(fake){
		cout << "NO\n";
	}
	else{
		cout << "YES\n";
	}
}
