#include <iostream>

using namespace std;

int main()
{
	int num1, num2, odds = 0;

	cout << "Enter first number\t: ";
	cin >> num1;
	cout << "Enter second number\t: ";
	cin >> num2;
	cout << "The odd numbers between " << num1 << " and " << num2 << " : " << endl;

	for (int count = num1; count <= num2; count++)
	{
		if (count % 2 == 1)
			cout << count << endl;
			odds++;
	}
	cout << "The number of odd numbers is " << odds << endl;

	return 0;
}