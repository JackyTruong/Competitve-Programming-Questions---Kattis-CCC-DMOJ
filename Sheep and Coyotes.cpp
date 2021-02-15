#include<bits/stdc++.h>
using namespace std;

class Pair{
	public:
	double key, value;
	Pair(double key, double value){
		this->key = key;
		this->value = value;
	}
};

bool findSpot(Pair x, vector<Pair> caught){
	for(int i = 0 ; i < caught.size(); i++){
		if(x.key == caught[i].key && x.value == caught[i].value){
			return true;
		}
	}
	return false;
}

void closest(vector<Pair> locations, Pair wolf, vector<Pair>& caught){
	double shortest = 999999999;
	int spot = -1;
	for(int i = 0 ; i < locations.size(); i++){
		double keyD = locations[i].key - wolf.key;
		double valD = locations[i].value - wolf.value;
		double dist = sqrt(keyD*keyD + valD*valD);
		if(dist < shortest){
			shortest = dist;
			spot = i;
		}
	}
	if(!findSpot(locations[spot], caught)){
		caught.push_back(locations[spot]);
	}
}

int main(){
	cin.sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);
	int n;
	cin >> n;
	vector<Pair> locations;
	for(int i = 0 ; i < n; i++){
		double a, b;
		cin >> a >> b;
		locations.push_back(Pair(a, b));
	}
	vector<Pair> caught;
	for(double i = 0; i < 1001; i += 0.01){
		closest(locations, Pair(i, 0.0), caught);
	}
	cout << fixed;
	cout << setprecision(2);
	for(int i = 0 ; i < caught.size(); i++){
		cout << "The sheep at (" << caught[i].key << ", " << caught[i].value << ") might be eaten." << '\n';
	}
}
