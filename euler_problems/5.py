# 5.py

# Description: What is the smallest positive number that is evenly divisible
# by all of the numbers 1 to 20?
# Author: Ian Zapolsky (10/31/13)
# Assumptions: Number will need to be even...

def returnPrimeFactors(num, primes):
    
    factors = []
    if num == 1:
        factors.append(1)
        return factors
    else:
        while num > 1:
            for prime in primes:
                if num % prime == 0:
                    factors.append(prime)
                    num = num/prime
                    break
        return factors

def returnFactorSet(start, stop, primes):

    factor_set = []
    for num in range(start, stop+1):
        factor_set.append(returnPrimeFactors(num, primes))
    return factor_set

def count(arr, prime):

    count = 0
    for num in arr:
        if num == prime:
            count += 1
    return count

def returnSmallestDivisible(factor_set, upper_bound, primes):

    factors = []
    for prime in primes:
        if prime > upper_bound:
            break
        max_fact = 0
        for f in factor_set:
            max_fact = max(max_fact, count(f, prime))
        while max_fact > 0:
            factors.append(prime)
            max_fact -= 1
    return factors

def processSum(factors):
    result = 1
    for factor in factors:
        result *= factor
    return result


small_primes = [2,3,5,7,11,13,17,19,23,29,31,37,41,43,47]
factor_set = returnFactorSet(1, 20, small_primes)
final_factors = returnSmallestDivisible(factor_set, 20, small_primes)
print final_factors
print processSum(final_factors)

