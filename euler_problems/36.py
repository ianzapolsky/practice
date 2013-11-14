# 36.py

# Description: List all numbers, less than one million, which are palindromic 
# in base 10 and base 2.
# Author: Ian Zapolsky

def toBinaryString(num):
    
    binaryString = ''
    while (num > 0):
        binaryString += str(num % 2)
        num /= 2

    return binaryString[::-1]

def isPalindrome(string):
    
    if string == string[::-1]:
        return True
    return False

def sumPalindromesLessThanN(n):
    
    result = 0

    for x in range(1,n):
        if isPalindrome(str(x)) and isPalindrome(toBinaryString(x)):
            result += x
    return result

print sumPalindromesLessThanN(1000000)

    
    
