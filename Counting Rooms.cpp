#include <bits/stdc++.h>
using namespace std;
 
 const int mxN = 1e4;
 
int n, m;
string arr[mxN];
 
void fillRoom(int r, int c){
	if(r >= 0 && r < n && c >= 0 && c < m && arr[r][c] != '#'){
		arr[r][c] = '#';
		fillRoom(r + 1, c);
		fillRoom(r - 1, c);
		fillRoom(r, c + 1);
		fillRoom(r, c - 1);
	}
}
 
int main(){
	cin.sync_with_stdio(0);
	cin.tie(0);
	cin >> n >> m;
	for(int i = 0 ; i < n ;i++){
		cin >> arr[i];
	}
	int count = 0;
	for(int i = 0 ; i < n;  i++){
		for(int o = 0 ; o < m; o++){
			if(arr[i][o] != '#'){
				fillRoom(i, o);
				count++;
			}
		}
	}
	cout << count;
	
}
