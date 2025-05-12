#include <iostream>
using namespace std;

int main() {

	int num1, num2, num3, sum, product, average, smallest, largest;

	cout << "Please enter 1st integer: ";
	cin >> num1;
	cout << "Please enter 2nd integer: ";
	cin >> num2;
	cout << "Please enter 3rd integer: ";
	cin >> num3;

	sum = num1 + num2 + num3;
	product = num1 * num2 * num3;
	average = sum / 3;

	cout << "Sum of these numbers: " << sum << endl;
	cout << "Product of these numbers: " << product << endl;
	cout << "Average of these numbers: " << average << endl;

	// Find the smallest number
	smallest = num1;
	if (num2 < smallest)
		smallest = num2;
	if (num3 < smallest)
		smallest = num3;

	// Find the largest number
	largest = num1;
	if (num2 > largest)
		largest = num2;
	if (num3 > largest)
		largest = num3;

	cout << "The largest value is " << largest << endl;
	cout << "The smallest value is " << smallest << endl;

	return 0;
}