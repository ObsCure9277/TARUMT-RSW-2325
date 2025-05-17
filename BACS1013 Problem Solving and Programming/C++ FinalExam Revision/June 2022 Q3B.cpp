#include <iostream>

using namespace std;

void swap2int(int* a, int* b);

int main()
{
	int x = 5, y = 10;
	cout << x << y << endl;
	swap2int(&x, &y);
	cout << x << y << endl;

	return 0;
}

void swap2int(int* a, int* b)
{
	int temp = *a;
	*a = *b;
	*b = temp;
}