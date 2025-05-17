#include <iostream>
#include <iomanip>
using namespace std;


int main()
{
	const double rate = 0.2;
	const int period = 14;
	int quantity = 0, day = 0, overdue = 0;
	double fine = 0.0;
	cout << "----------------\n";
	cout << "BOOK LOAN SYSTEM\n";
	cout << "----------------\n";
	cout << "Enter the number of books\t: ";
	cin >> quantity;
	cout << "Enter the days of the loan\t: ";
	cin >> day;
	cout << "---------------------------------------------------\n";
	overdue = day - period;
	if (overdue > 0)
	{
		cout << "Days overdue\t\t\t: " << overdue << endl;
		fine = overdue * rate * quantity;
		cout << "Fine\t\t\t\t: RM " << fixed << setprecision(2) << fine << endl;
	}
	else
		cout << "NO OVERDUE, NO FINE, EVERYTHING IS FINE" << endl;


	return 0;
}

