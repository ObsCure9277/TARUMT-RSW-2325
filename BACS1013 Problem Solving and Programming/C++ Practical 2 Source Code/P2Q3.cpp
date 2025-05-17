#include <iostream>
#include <string>
#include <iomanip>
#define PI 3.14159
using namespace std;

int main()
{
	double radius, circumference;
	cout << "Enter radius: ";
	cin >> radius;

	circumference = 2 * PI * radius;
	cout << "Radius is " << fixed << setprecision(2) << radius << endl;
	cout << "Circumference is " << fixed << setprecision(2) << circumference << endl;

	return 0;
}
