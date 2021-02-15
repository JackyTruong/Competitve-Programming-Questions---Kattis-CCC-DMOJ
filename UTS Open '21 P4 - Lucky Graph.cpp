#include<bits/stdc++.h>
using namespace std;

int n, m;

int main(){
	cin.sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);
	cin >> n >> m;
	vector<vector<int>> graph;
	vector<int> temp;
	for(int i = 0 ; i < n+1; i++){
		graph.push_back(temp);
	}
	int arr[n+1];
	fill(arr, arr+n+1, 0);
	for(int i = 0 ; i < m; i++){
		int a,b;
		cin >> a >> b;
		graph[a].push_back(b);
		graph[b].push_back(a);
		arr[a]++;
		arr[b]++;
	}
	for(int i = 1; i < n+1; i++){
		for(int o = 0 ; o < graph[i].size(); o++){
			cout << graph[i][o] << " ";
		}
		cout << "\n";
	}
	for(int i =1 ; i < n+1; i++){
		cout << arr[i] << " ";
	}
}
