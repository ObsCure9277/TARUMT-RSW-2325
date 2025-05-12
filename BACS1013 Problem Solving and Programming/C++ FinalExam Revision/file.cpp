#include <iostream>
#include <fstream>
#include <iomanip>

using namespace std;

struct Employee
{
	char empname[50];
	int age;
	double salary;
};

Employee employeelist[5];

int main() {
	ifstream inData;
	inData.open("employee.txt");
	char ch;

	if (!inData) 
	{
		cout << "Error opening file" << endl;
		return 0;
	}

	for (int i = 0; i < 5; i++) 
	{
		inData.get(employeelist[i].empname, 51);
		inData >> employeelist[i].age >> employeelist[i].salary;
		inData.get(ch);
	}

	inData.close();
	cout << "Name Age Salary (RM)" << endl;
	cout << "------------------- --- -----------" << endl;

	for (int i = 0; i < 5; i++) 
	{
		cout << setw(21) << left << employeelist[i].empname;
		cout << setw(5) << left << employeelist[i].age;
		cout << setw(11) << right << setprecision(2) << fixed << employeelist[i].salary <<
			endl;
	}

	return 0;
}