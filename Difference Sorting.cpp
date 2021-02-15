#include <bits/stdc++.h>
using namespace std;

const int mxN = 2001;

int n;

int main(){
	cin.sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);
	cin >> n;
	int arr[mxN];
	int nums[mxN];
	fill(nums, nums+mxN, 0);
	for(int i = 0; i < n; i++){
		cin >> arr[i];
		nums[arr[i]]++;
	}
	int temp[n];
	for(int i = 0 ; i < n; i++){
		temp[i] = arr[i];
	}
	sort(temp, temp+n);
	//TEMP IS THE SORTED ONE
	int lowest = 0;
	for(int i = 0 ; i < n; i++){
		if(temp[i] != arr[i]){
			int larger = max(temp[i], arr[i]);
			int smaller = min(temp[i], arr[i]);
			int num = 0;
			int numWithin = 10000;
			while(num < larger){
				num++;
				numWithin = min(max(larger-num,smaller+num) , numWithin);
			}
			lowest = max(numWithin, lowest);	
			
		}
	}
	cout << lowest << "\n";
}
