#include <bits/stdc++.h>
using namespace std;

int n;

int findGreatest(vector<int> arr, int pos, int large){
	//CLEAN THIS UP INSTEAD OF HAVING A FOR LOOP JUST RECURSIVELY ADD 1 TO THE POS AND KEEP TRACK OF THE LARGEST IN AN INPUT FOR THE RECURSIVE FUNCTION
	large = max(large, arr[pos]);
	if(pos == arr.size()-1){
		return large;
	}
	if(pos < arr.size()-1 && arr[pos] == arr[pos+1]){
		vector<int> temp;
		temp = arr;
		temp.erase(temp.begin()+pos, temp.begin()+pos+2);
		temp.insert(temp.begin()+pos, arr[pos]*2);
		large = max(large, findGreatest(temp, max(pos-2,0), large));
	}
	if(pos < arr.size()-2 && arr[pos] == arr[pos+2]){
		vector<int> temp;
		temp = arr;
		temp.erase(temp.begin()+pos, temp.begin()+pos+3);
		temp.insert(temp.begin()+pos, arr[pos]*2+arr[pos+1]);
		large = max(large, findGreatest(temp, max(pos-2,0), large));
	}
	large = max(large, findGreatest(arr, pos+1, large));
	return large;
}

int main(){
	cin.sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);
	cin >> n;
	vector<int> arr;
	for(int i = 0 ; i < n; i++){
		int temp;
		cin >> temp;
		arr.push_back(temp);
	}
	cout << findGreatest(arr, 0, 0);
}


