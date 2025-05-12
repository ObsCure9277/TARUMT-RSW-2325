#include <iomanip>
#include <iostream>
using namespace std;

int main()
{
    cout << setw(3) << "*" << endl;
    cout << setw(2) << "*" << setw(2) << "*" << endl;
    cout << setw(1) << "*" << setw(4) << "*" << endl;
    cout << setw(2) << "*" << setw(2) << "*" << endl;
    cout << setw(3) << "*" << endl;

    return 0;
}