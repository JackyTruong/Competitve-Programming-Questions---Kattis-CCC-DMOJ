#include <bits/stdc++.h>
#include <algorithm>
using namespace std;

const int mxN = 2e5;

int nS, k;
bool beenTo[mxN];

class cHeight{
	public:  void setNum(int student){
		this -> student = student;
	}
	int student;
	vector<int> taller, shorter;
};

void isTaller(int taller, int spot, vector<cHeight> &students, bool &answerTaller){
	if(!answerTaller){
		beenTo[spot] = true;
		int temp = spot;
		if(!(find(students.at(temp).taller.begin(), students.at(temp).taller.end(), taller) != students.at(temp).taller.end())){
			for(int i = 0 ; i < students.at(temp).taller.size();i++){
				if(!beenTo[students.at(temp).taller.at(i)]){
					isTaller(taller, students.at(temp).taller.at(i), students, answerTaller);
				}
			}
		}
		else if(students.at(temp).taller.empty()){
			return;
		}
		else{
			answerTaller = true;
		}
	}
}

void isShorter(int shorter, int spot, vector<cHeight> &students, bool &answerShorter){
	if(!answerShorter){
		beenTo[spot] = true;
		int temp = spot;
		if(!(find(students.at(temp).shorter.begin(), students.at(temp).shorter.end(), shorter) != students.at(temp).shorter.end())){
			for(int i = 0 ; i < students.at(temp).shorter.size();i ++){
				if(!beenTo[students.at(temp).shorter.at(i)]){
					isShorter(shorter,students.at(temp).shorter.at(i) ,students, answerShorter);
				}
			}
		}
		else if(students.at(temp).shorter.empty()){
			return;
		}
		else{
			answerShorter = true;
		}
	}
}


int main(){
	cin.sync_with_stdio(0);
	cin.tie(0);
	cin >> nS >> k;
	vector<cHeight> students (nS+1, cHeight());
	bool answerTaller = false;
	bool answerShorter = false;
	for(int i = 0 ; i <= nS; i++){
		students.at(i).setNum(i);
	}
	for(int i = 0 ; i < k; i++){
		int taller, shorter;
		cin >> taller >> shorter;
		students.at(taller).shorter.push_back(shorter);
		students.at(shorter).taller.push_back(taller);
	}
	int tallerNum, shorterNum;
	cin >> tallerNum >> shorterNum;
	isTaller(tallerNum, shorterNum, students, answerTaller);
	if(!answerTaller){
		isShorter(tallerNum, shorterNum, students, answerShorter);
	}
	if(answerTaller && !answerShorter){
		cout << "yes";
	}
	else if(!answerTaller && answerShorter){
		cout << "no";
	}
	else if(!answerTaller){
		cout << "unknown";
	}
}
