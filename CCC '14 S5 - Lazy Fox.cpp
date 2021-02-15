#include <bits/stdc++.h>
using namespace std;

int n;

class Path{
	
	public:
		
	int x, y;
	double weight;	
	Path(int x, int y, double weight){
		this -> x = x;
		this -> y = y;
		this -> weight = weight;
	}
	
};

bool ValueCmp(Path const & a, Path const & b){
		return b.weight > a.weight;
	}

int main(){
	cin.sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);
	cin >> n;
	int inputs[n+1][2];
	inputs[0][0] = 0;
	inputs[0][1] = 0;
	vector<Path> dist;
	for(int i = 1; i <= n; i++){
		cin >> inputs[i][0];
		cin >> inputs[i][1];
	}
	for(int i = 0 ; i <= n; i++){
		for(int o = i+1 ; o <= n ; o++){
			int dx = inputs[i][0] - inputs[o][0];
			int dy = inputs[i][1] - inputs[o][1];
			dist.push_back(Path(i, o, (double)dx*dx + dy*dy));
			}
	}
	sort(dist.begin(), dist.end(), ValueCmp);
	int best[n+1];
	fill(best, best+n+1, 0);
	double pDist[n+1];
	fill(pDist, pDist+n+1, 0);
	int pBest[n+1];
	fill(pBest, pBest+n+1, 0);
	for(int i = 0 ; i < dist.size(); i++){
		double distance = dist[i].weight;
		int x = dist[i].x;
		int y = dist[i].y;
		if(distance != pDist[x]){
			pDist[x] = distance;
			pBest[x] = best[x];
		}
		if(distance != pDist[y]){
			pDist[y] = distance;
			pBest[y] = best[y];
		}
		if(x == 0){
			best[x] = max(best[x], pBest[y]);
		}
		else{
			best[x] = max(best[x], pBest[y] + 1);
			best[y] = max(best[y], pBest[x] + 1);
		}
	}
	cout << (best[0]+1);
}
