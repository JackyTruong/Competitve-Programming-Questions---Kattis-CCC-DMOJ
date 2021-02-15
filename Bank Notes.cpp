#include <bits/stdc++.h>
using namespace std;

const int mxN = 2e2;

int n;

class Spot{
	public:
	int notesUsed[], countNotes;
	
	void createSpot(int n){
		this -> notesUsed[n+1];
		this -> countNotes = 0; 
	}
};


int note(int note[], int cost[], int money, int l){
	Spot dp[money+1];
	for(int i = 0 ; i < money+1; i++){
		dp[i].createSpot(money+1);
	}
	int min, t, spotTaken;
	Spot temp;
	for(int i = 1; i <= money; i++){
		min = 99999999;
		for(int o = 0 ; o < l; o++){
			t = i - cost[o];
			int num = note[o] - dp[t].notesUsed[o];
			if(t >= 0 && num > 0 && dp[t].countNotes >= 0 && dp[t].countNotes < min){
				min = dp[t].countNotes;
				spotTaken = o;
				temp = dp[t];
			}
		}
		if(min < 99999999){
			temp.countNotes++;
			temp.notesUsed[spotTaken]++;
			dp[i] = temp;
		}
		else{
			dp[i].countNotes = -1;
		}
	}
	return dp[money].countNotes-1;
}

int main(){
	cin.sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);
	cin >> n;
	int arr[n];
	int notes[n];
	for(int i = 0 ; i < n;  i++){
		cin >> arr[i];
	}
	for(int i = 0 ; i < n; i++){
		cin >> notes[i];
	}
	int money;
	cin >> money;
	cout << note(notes, arr, money, n);
}
