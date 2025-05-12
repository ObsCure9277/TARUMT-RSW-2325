


# =============================================================================
# #account.py
balance = 10.0

def setBalance(bal):
    global balance
    balance=bal
    print ("The balance in the function: ", balance)
 

# =============================================================================

# class Account(object): # “object” is a keyword in python. Account is a class
#     interest_rate = 0.03 # interest_rate is an attribute or slot
    
#     # a constructor with attributes that contain default values
#     def __init__(self, account_no = "none", balance = 0.0):
#         print ("A new account is created")
#         self.account_no = account_no
#         self.balance = balance + balance * self.interest_rate
        
#     def setBalance(self,bal):
#         self.balance = bal + bal*self.interest_rate
        
#     def __str__(self): #to print the Account attributes in string
#         return "The new balance %s is: %.2f" % (self.account_no, self.balance)

# # ##############################################################

# class Bank_Account(Account): #Bank_Account is-a Account class
    
#     interest_rate = 0.028 #interest rate is different from the parent class
    
#     #constructor with local attribute customer_name, two inherited from the superclass
#     def __init__(self, account_no, balance, customer_name):
#         super(Bank_Account, self).__init__(account_no, balance) 
#         self.account_no = account_no
#         self.balance = balance + balance * self.interest_rate
#         self.customer_name = customer_name
        
#     def __str__(self): #to print the Bank_Account attributes in string
#         return "Account No: %s\nCustomer Name: %s\nThe new balance is: %.2f" %(self.account_no, self.customer_name, self.balance)
      
    
# # =============================================================================
# #######################################################################

    

        


