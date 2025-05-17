#include <iostream>

using namespace std;

int main() {
    int num;
    int product = 1;

    do {
        cout << "Enter a number: ";
        cin >> num;

        if (num <= 0) {
            break;
        }

        product *= num;
    } while (num > 0);

    cout << "The product of all your positive numbers is " << product << "." << endl;

    return 0;
}
