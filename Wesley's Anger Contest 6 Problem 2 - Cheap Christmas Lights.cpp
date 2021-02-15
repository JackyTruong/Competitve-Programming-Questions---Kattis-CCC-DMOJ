#include <bits/stdc++.h>
using namespace std;

const int mxN = 200001;

int n, m, l[mxN], s[mxN];

int lightsOn(int lights[], int size){
	int count = 0;
	for(int i = 1 ; i <= size; i++){
		if(lights[i] == 1){
			count++;
		}
	}
	return count;
}

int main(){
	cin.sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);
	cin >> n >> m;
	for(int i = 1 ;i <= n;i++){
		cin >> l[i];
	}
	for(int i = 1 ; i <= m ;i++){
		cin >> s[i];
	}
	int lightsOnNow = lightsOn(l, n);
	if(lightsOnNow == 0){
		cout << 0 << "\n";
	}
	else{
		int i = 1;
		while(true){
				if(i <= m){
					if(l[s[i]] == 1){
					l[s[i]] = 0;
					lightsOnNow--;
				}	
				else{
					l[s[i]] = 1;
					lightsOnNow++;
				}
			}
			if(lightsOnNow<= i){
				cout << i << "\n";
				return 0;
			}
			i++;
		}
	}
	
}
