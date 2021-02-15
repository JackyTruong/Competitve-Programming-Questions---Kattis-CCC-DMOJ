#include <bits/stdc++.h>
using namespace std;


int main(){
	cin.sync_with_stdio(0);
	cin.tie(0);
	string temp;
	cin >> temp;
	int count = 1;
	int largest = 0;
	for(int i = 1 ; i < temp.length(); i++){
		if(temp.at(i) != temp.at(i-1)){
			if(largest < count){
				largest = count;
			}
			count = 1;
		}
		else{
			count++;
		}
	}
	if(largest < count){
		largest = count;
	}
	cout << largest;
	
}
