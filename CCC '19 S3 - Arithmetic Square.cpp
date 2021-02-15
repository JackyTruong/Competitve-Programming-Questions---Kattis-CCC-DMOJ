#include <bits/stdc++.h>
using namespace std;

int numPlace(int arr[3][3], int r, int c){
	if(r == 0){
		if(c == 0){
			if(arr[0][1] != 999999999 && arr[0][2] != 999999999){
				arr[0][0] = arr[0][1] - (arr[0][2] - arr[0][1]);
			}
			else if(arr[1][0] != 999999999 && arr[2][0] != 999999999){
				arr[0][0] = arr[1][0] - (arr[2][0] - arr[1][0]); 
			}
		}
		else if(c == 1){
			if(arr[0][0] != 999999999 && arr[0][2] != 999999999){
				arr[0][1] = (arr[0][2] + arr[0][0])/2;
			}
			else if(arr[1][1] != 999999999 && arr[2][1] != 999999999){
				arr[0][1] = arr[1][1] - (arr[2][1] - arr[1][1]);
			}
		}
		else{
			if(arr[0][0] != 999999999 && arr[0][1] != 999999999){
				arr[0][2] = (arr[0][1] - arr[0][0]) + arr[0][1];
			}
			else if(arr[1][2] != 999999999 && arr[2][2] != 999999999){
				arr[0][2] = arr[1][2] - (arr[2][2] - arr[1][2]);
			}
		}
	}
	else if(r == 1){
		if(c == 0){
			if(arr[1][1] != 999999999 && arr[1][2] != 999999999){
				arr[1][0] = arr[1][1] - (arr[1][2] - arr[0][1]);
			}
			else if(arr[0][0] != 999999999 && arr[2][0] != 999999999){
				arr[1][0] = (arr[2][0] + arr[1][0])/2;
			}
		}
		else if(c == 1){
			//row 1 col 1
			if(arr[1][2] != 999999999 && arr[1][0] != 999999999){
				arr[1][1] = (arr[1][2] + arr[1][0])/2;
			}
			else if(arr[0][1] != 999999999 && arr[0][2] != 999999999){
				arr[1][1] = (arr[0][2] + arr[0][1])/2;
			}
		}
		else{
			//row 1 col 2
			if(arr[1][0] != 999999999 && arr[1][1] != 999999999){
				arr[1][2] = arr[1][1] + (arr[1][1] - arr[1][0]);
			}
			else if(arr[0][2] != 999999999 && arr[2][2] != 999999999){
				arr[1][2] = (arr[2][2] + arr[0][2])/2;
			}
		}
	}
	else{
		if(c == 0){
			//row 2 col 0
			if(arr[0][0] != 999999999 && arr[1][0] != 999999999){
				arr[2][0] = arr[1][0] + (arr[1][0] - arr[0][0]);
			}
			else if(arr[2][1] != 999999999 && arr[2][2] != 999999999){
				arr[2][0] = arr[2][1] - (arr[2][2] - arr[2][1]);
			}
		}
		if(c == 1){
			//row 2 col 1
			if()
		}
	}

}

int main(){
	cin.sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);
	int arr[3][3];
	for(int i = 0 ; i < 3; i++){
		for(int o = 0 ; o < 3; o++){
			string temp;
			cin >> temp;
			if(temp == "X"){
				arr[i][o] = 999999999;
			}
			else{
				arr[i][o] = stoi(temp);
			}
		}
	}
	for(int i = 0 ; i < 3; i++){
		for(int o = 0; o < 3; o++){
			if(arr[i][o] == 999999999){
				numPlace(arr, i, o);	
			}
		}
	}
	for(int i = 0 ; i < 3; i++){
		for(int o = 0; o < 3; o++){
			cout << arr[i][o] << " ";
		}
		cout << "\n";
	}
	int count = 0;
	
	
}
