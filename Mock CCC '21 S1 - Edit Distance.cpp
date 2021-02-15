#include <bits/stdc++.h>
using namespace std;

string original, letters;

int main(){
	cin >> letters >> original;
	vector<string> outputs;
	unordered_map<string, int> repeat;
	for(int i = 0; i < letters.length(); i++){
		string temp1 = letters[i] + original;
		string temp2 = original + letters[i];
		if(repeat.find(temp1) == repeat.end()){
			outputs.push_back(temp1);
			repeat.emplace(temp1, repeat.size());	
		}
		if(repeat.find(temp2) == repeat.end()){
			outputs.push_back(temp2);
			repeat.emplace(temp2, repeat.size());	
		}	
		for(int o = 0 ; o < original.length(); o++){
			string temp = original;
			if(letters[i] != original[o]){
				temp[o] = letters[i];
				if(repeat.find(temp) == repeat.end()){
					repeat.emplace(temp, repeat.size());
					outputs.push_back(temp);
				}
			}
			temp = original;
			temp.erase(temp.begin()+o);
			if(repeat.find(temp) == repeat.end()){
				repeat.emplace(temp, repeat.size());
				outputs.push_back(temp);
			}
			temp = original;
			temp.insert(o, string(1, letters[i]));
			if(repeat.find(temp) == repeat.end()){
				//cout << temp << " hereeee \n";
				repeat.emplace(temp,repeat.size());
				outputs.push_back(temp);
			}
		}
	}
	sort(outputs.begin(), outputs.end());
	for(int i = 0 ; i < outputs.size(); i++){
		cout << outputs[i] << "\n";
	}
	
}
