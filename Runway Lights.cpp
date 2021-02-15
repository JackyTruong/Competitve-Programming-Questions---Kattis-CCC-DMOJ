#include <bits/stdc++.h>
using namespace std;

const int M = 998244353;

int n, k;
string s;

int main(){
	cin.sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);
	cin >> n >> k >> s;
	char arr[] = {'B', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'X', 'Y', 'Z'};
	for(int i = 0 ; i < 23; i++){
		replace(s.begin(), s.end(), arr[i], ' ');
	}
	string::iterator end_pos = std::remove(s.begin(), s.end(), ' ');
    s.erase(end_pos, s.end());
	string full;
	for(int i = 0 ; i < k; i++){
		full += s;
	}
	int A[full.length()];
	int C[full.length()];
	int countA = 0;
	int countC = 0;
	fill(A, A+full.length(), 0);
	fill(C, C+full.length(), 0);
	for(int i = full.length()-1 ; i >= 0; i--){
		if(full[i] == 'C'){
			countC++;
		}
		C[i] = countC;
	}
	for(int i = full.length()-1; i >= 0; i--){
		if(full[i] == 'A'){
			A[i] = C[i];
		}
	}
	int count = 0;
	for(int i = 0 ; i < full.length(); i++){
		if(full[i] == 'W'){
			for(int o = i; o < full.length(); o++){
				count += A[o];
			}
		}
	}
	
	cout << count << "\n";
}
