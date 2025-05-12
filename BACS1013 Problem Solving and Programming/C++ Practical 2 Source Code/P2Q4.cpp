#include <iostream>
#include <string>
#include <iomanip>
#define PI 3.14159
using namespace std;

int main()
{
	double num;
	int intPart = 0;
	cout << "Enter a floating point number: ";
	cin >> num;
	intPart = (int)num;
	num -= intPart;
	cout << "The integral part is " << intPart << endl;
	cout << "The fractional part is " << num << endl;



	return 0;
}