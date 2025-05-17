#include <iostream>

using namespace std;

int main() {

	int num, digit;
	do {
		cout << "Enter an integer > ";
		cin >> num;
		num = num / 10;
		digit++;

	} while (num != 0);

		cout << "Number " << num << "contains" << digit << "digit(s)";

	return 0;
}