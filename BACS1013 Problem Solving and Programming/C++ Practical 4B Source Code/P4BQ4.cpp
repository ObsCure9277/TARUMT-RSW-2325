#include <iostream>

using namespace std;

int main()
{
	int input, steps = 0;
	cout << "Initial value: ";
	cin >> input;
	if (input < 1)
	{
		cout << "INVALID INPUT";
	}
	else
	{
		while (input > 1)
		{
			if (input % 2 == 0) //this is an even number
			{
				input /= 2;
			}
			else // this is an odd number
			{
				input *= 3;
				input++;
			}
			cout << "Next value is " << input << endl;
			steps++;
		}
		if (steps > 1)
		{
			cout << "Final value is " << input << " , number of steps are " << steps << endl;
		}
		else {
			cout << "Final value is " << input << " , number of step is " << steps << endl;
		}
	}
	return 0;
}