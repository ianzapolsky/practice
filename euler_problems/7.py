# 7.py

# Description: Find the 10001st prime number.
# Author: Ian Zapolsky (11/01/13)

import math
import sys

def findNthPrime(n):
    
    primes = [2]
    current = 3
    
    while len(primes) < n:
        if isPrime(current, primes): 
            primes.append(current)
        current += 2
    return primes[n-1]

def isPrime(check, primes):

    for prime in primes:
        if prime > math.sqrt(check):
            return True
        elif check%prime == 0:
            return False
    return True


if len(sys.argv) == 1:
    print "USAGE: python 7.py <n>"
else:
    n = int(sys.argv[1])
    print findNthPrime(n)

  


