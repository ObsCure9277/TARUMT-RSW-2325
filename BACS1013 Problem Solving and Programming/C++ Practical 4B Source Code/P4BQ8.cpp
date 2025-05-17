#include <iostream>

using namespace std;

int main() {
    int lower_limit, upper_limit;

    while (true) {
        cout << "Enter lower and upper integer limits: ";
        cin >> lower_limit >> upper_limit;

        if (upper_limit <= lower_limit) {
            cout << "Ended" << endl;
            break;
        }

        int sum = 0;
        for (int i = lower_limit; i <= upper_limit; i++) {
            sum += i * i;
        }

        cout << "The sum of the squares from " << lower_limit * lower_limit << " to " << upper_limit * upper_limit << " is " << sum << "." << endl;
    }

    return 0;
}
