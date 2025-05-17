#include <iostream>

using namespace std;

#include <fstream>
#include <string>
#include <cstring>
#include <cctype>
#include <iomanip>

double calculateExpenses(double homeLoan, double carLoan, double waterBill, double electricityBill, double gasBill, double* loanExpenses);

int main() {
	double homeLoan = 200.6, carLoan = 300.5, waterBill = 300.5, electricityBill = 300.5, gasBill = 300.5, loanExpenses, billExpenses;

	billExpenses = calculateExpenses(homeLoan, carLoan, waterBill, electricityBill, gasBill, &loanExpenses);
	cout << "loan Expenses: " << loanExpenses << endl;
	cout << "bill expenses: " << billExpenses;
}

double calculateExpenses(double homeLoan, double carLoan, double waterBill, double electricityBill, double gasBill, double* loanExpenses) {
	double billExpenses;

	*loanExpenses = homeLoan + carLoan;
	billExpenses = waterBill + electricityBill + gasBill;

	return billExpenses;

}