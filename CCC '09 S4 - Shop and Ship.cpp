#include <bits/stdc++.h>
using namespace std;

class Path{
	public:
		int to, cost;
		Path(int to, int cost){
			this -> to = to;
			this -> cost = cost;
		}
};

vector<vector<Path>> graph;
vector<int> dist;
int n, t, e, k;

void bfs(){
	for(int i = 0 ; i <= n; i++){
		dist[i] = 99999999;
	}
	dist[e] = 0;
	bool inq[n+1];
	fill(inq, inq+n+1, false);
	queue<int> q;
	q.push(e);
	while(!q.empty()){
		int p = q.front();
		q.pop();
		inq[p] = false;
		//cout << "this work " << graph[p].size() << " "  << p <<"\n";
		for(int i = 0; i < graph[p].size(); i++){
			int v = graph[p][i].to;
			int cost = graph[p][i].cost;
			
			if(dist[v] > cost + dist[p]){
				dist[v] = cost + dist[p];
				
				if(!inq[v]){
					q.push(v);
					inq[v] = true;
				}
			}
		}
	}
}

int main(){
	cin.sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);
	cin >> n >> t;
	for(int i = 0 ; i <= n; i++){
		vector<Path> temp;
		graph.push_back(temp);
		dist.push_back(0);
	}
	for(int i = 0 ; i < t; i++){
		int f, s, w;
		cin >> f >> s >> w;
		graph[f].push_back(Path(s, w));
		graph[s].push_back(Path(f, w));
		//cout << graph[f].size() << " this do be" << graph[s].size() << " \n";
	}
	cin >> k;
	vector<Path> buy;
	for(int i = 0 ; i < k ;i++){
		int f, w;
		cin >> f >> w;
		buy.push_back(Path(f, w));
	}
	cin >> e;
	//cout << "herer";
	
	bfs();
	
	int low = 99999999;
	for(int i = 0 ; i < k; i++){
		//cout << buy[i].cost << " " << dist[buy[i].to] << " thisssssss\n";
		if(buy[i].cost + dist[buy[i].to] < low){
			low = buy[i].cost + dist[buy[i].to];
		}
	}
	cout << low;
}
