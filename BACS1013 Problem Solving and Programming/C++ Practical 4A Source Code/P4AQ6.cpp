#include <iostream>

using namespace std;

int main() {

	int sales, income;

	cout << "Enter your monthly sales: RM";
	cin >> sales;

	if (sales >= 50000)
	{
		income = 375 + sales * 0.16;
	}		
	else if (sales >= 40000)
	{
		income = 350 + sales * 0.14;
	}
	else if (sales >= 30000)
	{
		income = 325 + sales * 0.12;
	}
	else if (sales >= 20000)
	{
		income = 300 + sales * 0.09;
	}
	else if (sales >= 10000)
	{
		income = 250 + sales * 0.05;
	}
	else
	{
		income = 200 + sales * 0.03;
	}



	cout << "Your income based on monthly sales is RM" << income;
	return 0;
}