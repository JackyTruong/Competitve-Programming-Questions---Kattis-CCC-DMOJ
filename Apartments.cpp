#include <bits/stdc++.h>
#define scan(x) do{while((x=getchar())<'0'); for(x-='0'; '0'<=(_=getchar()); x=(x<<3)+(x<<1)+_-'0');}while(0)
char _;
using namespace std;

const int mxN = 2e5;

int n, m, k, applics[mxN], apart[mxN];

int main(){
	scan(n);scan(m);scan(k);
	for(int i = 0 ; i < n; i++){
		scan(applics[i]);
	}
	for(int i = 0; i < m ;i++){
		scan(apart[i]);
	}
	sort(applics, applics+n);
	sort(apart, apart+m);
	int count = 0;
	for(int i = 0, j = 0; i < n; i++){
		while(j < m && apart[j] < applics[i] - k){
			j++;
		}
		if(j < m && apart[j] <= applics[i] + k){
			count++;
			j++;
		}
	}
	cout << count;
}
