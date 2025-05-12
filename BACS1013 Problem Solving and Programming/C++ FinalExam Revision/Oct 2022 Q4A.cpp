#include <iostream>
using namespace std;
#define NUTS 1.50; 
#define CHIPS 2.3; 
#define CANISTER 4.5; 
#define CRISPS 3.5; 
#define RINGS 3.55; 

enum snackTypes { SNS07, SCS03, SCC05, SCP08, SCR01 };
double FindRate(snackTypes code);

double FindRate(snackTypes code) {
    if (code == SNS07) {
        return NUTS;
    }
    else if (code == SCS03) {
        return CHIPS;
    }
    else if (code == SCC05) {
        return CANISTER;
    }
    else if (code == SCP08) {
        return CRISPS;
    }
    else if (code == SCR01) {
        return RINGS;
    }
    else {
        cout << "error";
    }
    return 0;
}

int main() {
    snackTypes snackCodes;
    int codes;
    cout << "enter code: ";
    cin >> codes;
    snackCodes = snackTypes(codes);
    cout << FindRate(snackCodes) << endl;

    return 0;
}


