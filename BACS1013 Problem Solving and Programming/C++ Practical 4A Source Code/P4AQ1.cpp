#include <iostream>
#include <iomanip>
#include <string>
using namespace std;

int main()
{
	string custName;
	int taxCode;
	double purchAmt, percentage, salesTax, totalAmt, e;
	cout << "Enter customer's name: ";
	getline(cin, custName);
	cout << "Enter purchase amount: ";
	cin >> purchAmt;
	cout << "Enter tax code       : ";
	cin >> taxCode;
	if (taxCode == 0)
		percentage = 0.0;
	else if (taxCode == 1 || taxCode == 4)
		percentage = 0.06;
	else if (taxCode == 2)
		percentage = 0.1;
	else
		percentage = 0.16;

	/*
	switch (taxCode)
	{
		case 0:
			percentage = 0.0;
			break;
		case 1:
		case 4:
			percentage = 0.06;
			break;
		case 2:
			percentage = 0.1;
			break;
		default:
			percentage = 0.16;

	*/
	salesTax = percentage * purchAmt;
	totalAmt = purchAmt + salesTax;
	if (taxCode < 0 || taxCode > 4)
		cout << "INVALID CODE ENTERED" << endl;
	else
	{
		cout << fixed << setprecision(2);
		cout << "Customer Name : " << custName << endl;
		cout << "Purchase Amout: RM " << purchAmt << endl;
		cout << "Sales Tax     : " << salesTax << endl;
		cout << "Total Amount  : " << totalAmt << endl;
	}
	return 0;
}