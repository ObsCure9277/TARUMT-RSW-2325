#include <iostream>

using namespace std;

int main()
{
	enum months { January, February, March, April, May, June, July, August, September, October, November, December };
	months month;
	string monthly[12] = { "January","February","March","April","May","June","July","August","September","October","Movember","December" };
	double temperature[12] = { 1.1, 2.4, 3.2, 4.6, 5.4, 6.7, 7.9, 8.2, 9.1, 7.4, 5.4, 4.3 };
	double mon;

	for (int monthIndex = 0; monthIndex < 12; monthIndex++)
	{
		month = months(monthIndex);
		mon = temperature[month];
		cout << "Coldest temperature recorded in " << monthly[monthIndex] << " is " << mon << " degrees Celcius." << endl;
		month = months(month + 1);
	}
}


