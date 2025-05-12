#include <iostream>
#include <iomanip>
using namespace std;

int main() {

    float F, C;

    cout << "Please enter temperature in Centigrade(C): ";
    cin >> C;

    F = 32 + (C + (180.0 / 100.0) );

    cout << "The temperature in Fahrenheit(F) is " << F
        << " degrees.";

    return 0;
}
