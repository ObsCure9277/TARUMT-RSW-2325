#include <iostream>

using namespace std;

int main()
{
	int num, divisor;
	cout << "Enter a number: ";
	cin >> num;
	cout << "The divisors are: ";

	for (divisor = 1; divisor <= num; ++divisor) {
		if (num % divisor == 0) {
			cout << " " << divisor;
		}
	}

	return 0;
}