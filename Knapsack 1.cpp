#include<bits/stdc++.h>
using namespace std;

class Item{
	public:
	long long w, v;
	Item(int w , int v){
		this->w = w;
		this->v = v;
	}
};

bool compare(Item i, Item o){
	if(i.w == o.w){
		return (i.v < o.v);
	}
	return (i.w < o.w);
}

long long knap(long long w, vector<Item> arr, long long n){
	if(n == 0 || w == 0){
		return 0;
	}
	if(arr[n-1].w > w){
		return knap(w, arr, n-1);
	}
	else{
		return max(arr[n-1].v + knap(w-arr[n-1].w, arr, n-1), knap(w, arr, n-1));
	}
}

int main(){
	long long n, w;
	vector<Item> arr;
	cin >> n >> w; 
	for(int i = 0; i  < n; i++){
		long long a, v;
		cin >> a >> v;
		arr.push_back(Item(a , v));
	}
	sort(arr.begin(), arr.end(), compare);
	cout << knap(w, arr, n) <<'\n';
}
