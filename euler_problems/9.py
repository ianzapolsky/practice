# 9.py

import math

def find_sum_of_triple_that_sums_to_n(target):

    for m in range(2, int(math.sqrt(target))):
        for n in range(1, int(math.sqrt(target))):
            while m > n:
                a = (m*m) - (n*n)
                b = 2*m*n
                c = (m*m) + (n*n)

                if (a+b+c) == target:
                    return (a*b*c)
                break

print find_sum_of_triple_that_sums_to_n(1000)
