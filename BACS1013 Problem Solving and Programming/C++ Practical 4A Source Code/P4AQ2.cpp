#include <iostream>
using namespace std;

int main()
{
	int temp;
	cout << "Enter temperature: ";
	cin >> temp;
	if (temp > 85)
		cout << "Swimming" << endl;
	else if (temp > 70)
		cout << "Tennis" << endl;
	else if (temp > 32)
		cout << "Golf" << endl;
	else if (temp > 0)
		cout << "Skiing" << endl;
	else
		cout << "Dancing" << endl;

	return 0;
}