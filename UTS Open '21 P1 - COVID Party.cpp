#include <bits/stdc++.h>
using namespace std;

int n;

int findSpace(int s){
	int first = 1 + s/2;
	if(s % 2 == 0){
		return first*(s/2+1) + (first-1)*(s/2);
	}
	else{
		return first*(s+1);
	}
}

int main(){
	cin >> n;
	int s = 0;
	int total = 0;
	while(total < n){
		s++;
		total = findSpace(s);
	}
	
	cout << s;
}
