#include <iostream>
#include <iomanip>

using namespace std;

int main()
{
	float num1 = 169.50;
	float num2 = 230.85;
	float discount;
	float total;

	cout << "Order Summary (RM)\n";
	cout << "------------------\n";
	cout << "Member ID: X1234\n";
	cout << "Item" << setw(1) << "1" << setw(15) << ":" << setw(15) << fixed << setprecision(2) << num1 << endl;
	cout << "Item" << setw(1) << "2" << setw(15) << ":" << setw(15) << fixed << setprecision(2) << num2 << endl;
	discount = (num1 + num2) * 20 / 100;
	cout << "Minus" << setw(15) << "Discount:" << setw(5) << "-20%" << setw(10) << fixed << setprecision(2) << discount << endl;
	cout <<  setw(36) << "---------------\n";
	total = num1 + num2 - discount;
	cout << "Total" << setw(15) << ":" << "*********" << fixed << setprecision(2) << total;

	return 0;
}