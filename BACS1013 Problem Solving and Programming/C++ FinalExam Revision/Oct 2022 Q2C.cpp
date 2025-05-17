#include <iostream>

using namespace std;

int main()
{
 

	for (int deposit = 100; deposit <= 500; deposit += 50)
	{
		cout << "Your deposit is RM" << deposit << endl;

		for (double interestRate = 0.02; interestRate <= 0.10; interestRate += 0.01)
		{
			cout << "Your interest rate is " << interestRate << endl;
		}
	}

	return 0;
}