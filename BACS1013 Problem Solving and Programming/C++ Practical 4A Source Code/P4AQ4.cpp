#include <iostream>
#include <iomanip>
using namespace std;

int main() {

	const float overtimePayRate = 0.5;
	float hourWage, hour, grossPay1, grossPay2;

	cout << "Enter hourly wage: ";
	cin >> hourWage;
	cout << "Enter hours: ";
	cin >> hour;

	if (hour <= 40) {
		grossPay1 = hour * hourWage;
		cout << "You have earned RM" << fixed << setprecision(2) << grossPay1 << "." << endl;
		cout << "You are underworked.";
	}
	else {
		grossPay2 = hour * hourWage + hourWage * ((hour - 40) * overtimePayRate);
		cout << "You have earned RM" << fixed << setprecision(2) << grossPay2 << "." << endl;
		cout << "";
	}

	return 0;
}