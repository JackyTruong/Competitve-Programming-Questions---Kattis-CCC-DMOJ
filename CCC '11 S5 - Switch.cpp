#include <bits/stdc++.h>
using namespace std;

int k;

class Lights{
	public:
	int amount, start, end;
	Lights(int amount, int start, int end){
		this -> amount = amount;
		this -> start = start;
		this -> end = end;
	}
};

int main(){
	cin.sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);
	cin >> k;
	int count = 0;
	int start = 0;
	int in[k];
	
	
	//REDO ALL SO FROM EACH GROUP OF LIGHTS CHECK THE LEFT AND RIGHT AND LOOK AT WHICH HAS THE LEAST DIST AND IF THE DIST IS < 4 - THE SIZE OF THE GROUP
	//IF IT IS THEN U CONNECT THE TWO GROUPS AND REMOVE BOTH
	//IF IT ISNT THEN JUST REMOVE THE GROUP AND ADD 4 - THE SIZE OF THE GROUP TO THE COUNT
	
	
	
	vector<Lights> arr;
	for(int i = 0 ; i < k; i++){
		cin >> in[i];
		if(count == 0){
			start = i;
		}
		if(in[i] == 1){
			count++;
		}
		else if(in[i] == 0 && count != 0){
			arr.push_back(Lights(count, start, i));
			count = 0;
		}
	}
	if(count != 0){
		arr.push_back(Lights(count, start, k+1));
	}
	int spot = 0;
	count = 0;
	while(spot < arr.size()-1){
		if(arr[spot+1].start - arr[spot].end <= (4 - arr[spot].amount) + (4-arr[spot+1].amount)){
			//cout << arr[spot+1].start - arr[spot].end << " this is the ";
			count += arr[spot+1].start - arr[spot].end;
			arr.erase(arr.begin()+spot, arr.begin()+spot+2);
			spot--;
		}
		else{
			count += 4-arr[spot].amount;
			arr.erase(arr.begin()+spot+1);
			spot--;
		}
	}
	for(int i = 0 ; i < arr.size(); i++){
		count += 4-arr[i].amount;
	}
	
	cout << count << "\n";
}

