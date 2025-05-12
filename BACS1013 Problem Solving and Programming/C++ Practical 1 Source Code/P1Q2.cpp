#include <iostream>
#include <iomanip>
using namespace std;

int main() {
	//declare variables
	//data type followed by variable name
	string username;
	int age;
	char gender;
	double income;

	cout << "Input/n-------" << endl;
	cout << "Enter <name> <age> <gender> <income> :";
	//read input using single cin
	cin >> username >> age >> gender >> income;
	//print blank space
	cout << endl;
	cout << "Output/n-------" << endl;
	cout << "Name/t:" << username << endl;
	cout << "Age/t:" << age << endl;
	cout << "Gender/t:" << gender << endl;
	//set two decimal places
	cout << "Income/t:" << fixed << setprecision(2) << showpoint << income << endl;

	return 0;
}