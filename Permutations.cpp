#include <bits/stdc++.h>
using namespace std;

int n;

int main(){
	cin.sync_with_stdio(0);
	cin.tie(0);
	cin >> n;
	if(n > 3){
		if(n % 2 == 0){
			for(int i = 2; i <= n ; i +=2){
				cout << i << " ";
			}
			for(int i = 1; i <= n ; i+=2){
				cout << i << " ";
			}
		}
		else{
			for(int i = 1; i <= n ; i+=2){
				cout << i << " ";
			}
			for(int i = 2; i <= n; i+=2){
				cout << i << " ";
			}
		}
	}
	else{
		if(n == 1){
			cout << 1;
		}
		else{
			cout << "NO SOLUTION";
		}
	}
}
