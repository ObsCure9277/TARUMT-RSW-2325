#include <iostream>

using namespace std;

int main()
{
	for (int j = 1; j < 7; j++)
	{
		for (int i = 6; i >= j; i--)
		{
			cout << i;
		}
		cout << endl;
	}

	return 0;
}