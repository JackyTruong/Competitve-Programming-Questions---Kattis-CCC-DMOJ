#include <bits/stdc++.h>
using namespace std;

int m, n, room[1000][1000];
bool foundE = false;
bool used[1000001];
bool beenTo[1000][1000];


vector<int> findF(int num){
	vector<int> factors;
	for(int i = 1 ; i <= sqrt(num); i++){
		if(num % i == 0 && ((i-1 < m && num/i-1 < n) || (i-1 < n && num/i-1 < m))){
			factors.push_back(i);
		}
	}
	used[num] = true;
	return factors;
}

void findEnd(int row, int col){
	if(!foundE && !beenTo[row][col]){
		beenTo[row][col] = true;
		if(row == m-1 && col == n-1 || row == n-1 && col == m-1){
			foundE = true;
		}
		if(!used[room[row][col]]){
			vector<int> keepF = findF(room[row][col]);
			for(int i = 0 ; i < keepF.size() && !foundE; i++){
				int a = keepF.at(i);
				int b = room[row][col]/a;
				a--;
				b--;
				if(a < m && b < n){
					findEnd(a, b);
				}
				if(a < n && b < m){
					findEnd(b ,a);	
				}
			}
		}
	
	}
}

int main(){
	cin.sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);
	cin >> m >> n;
	fill(used, used+1000001, false);
	
	for(int i = 0 ; i < m; i++){
		for(int o = 0 ; o < n; o++){
			cin >> room[i][o];
			beenTo[i][o] =false;
		}
	}
	findEnd(0, 0);
	cout << (foundE ? "yes" : "no");
}
