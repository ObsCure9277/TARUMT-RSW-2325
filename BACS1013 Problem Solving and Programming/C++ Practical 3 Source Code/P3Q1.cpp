#include <iostream>
using namespace std;

int main()
{
    int numDays, weeks, balanceDays;

    cout << "Enter the number of days: ";
    cin >> numDays;
    weeks = numDays / 7;
    balanceDays = numDays % 7;

    if (weeks <= 1 && balanceDays <= 1)
        cout << numDays << "days = " << weeks << " week and " << balanceDays << " day. " << endl;

    else if (balanceDays == 1)
        cout << numDays << "day = " << weeks << " week and " << balanceDays << " day. " << endl;

    else
        cout << numDays << " days = " << weeks << " weeks and " << balanceDays << " days. " << endl;

    return 0;
}