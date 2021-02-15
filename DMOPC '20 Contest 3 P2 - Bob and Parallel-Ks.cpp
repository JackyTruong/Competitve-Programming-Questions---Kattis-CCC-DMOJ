#include <bits/stdc++.h>
using namespace std;

int cN = 0;

bool sortCol(vector<int> v1, vector<int> v2){
	return v1[cN] < v2[cN];
}

int main(){
	cin.sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);
	int n, m, k;
	cin >> m >> n >> k;
	vector<vector<int>> arr;
	for(int i = 0 ; i < m; i++){
		vector<int> temp;
		for(int o = 0 ; o < n; o++){
			int num;
			cin >> num;
			temp.push_back(num);
		}
		arr.push_back(temp);
	}
	long count = 0;
	while(cN < n-1){
		sort(arr.begin(), arr.end(), sortCol);
		int l = 0;
		int r = 1;
		while(r < m){
			if(l == r && r + 1 < m){
				r++;
			}
			int num = arr[r][cN] - arr[l][cN];
			if(num < k){
				r++;
			}
			else if(num == k){
				if(arr[r][cN+1] - arr[l][cN+1] == k){
					count++;	
				}
				l++;
				r++;
			}
			else{
				l++;
			}
		}
		cN++;
	}
	/*
	for(int i = 0 ; i < m; i++){
		for(int o = 0 ; o < n; o++){
			cout << arr[i][o] << " ";
		}
		cout << "\n";
	}
	*/

	cout << count;
}

