#include <bits/stdc++.h>
using namespace std;

int main (){
	cin.sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);
	int n;
	cin >> n;
	for(int i = 0 ; i < n; i++){
		long long sides[3];
		for(int i = 0; i < 3; i++){
			cin >> sides[i];
		}
		sort(sides, sides + 3);
		long long ab = sides[0]*sides[0] + sides[1]*sides[1];
		long long c =sides[2] * sides[2];
		if(ab == c){
			cout << "R\n";
		}
		else if(ab < c){
			cout << "O\n";
		}
		else{
			cout << "A\n";
		}
	}
}
