# 4.py

# Description: Find the largest palindrome made from the product of two 3-digit
# numbers.
# Author: Ian Zapolsky (10/31/13)

def biggest_p():
    
    biggest_pal = 0

    for x in range(100, 1000):
        for y in range(100, 1000):
            if is_pal(x*y) and (x*y) > biggest_pal:
                biggest_pal = (x*y)
            y -= 1
        x -= 1
    return biggest_pal

def is_pal(x):

    if str(x) == str(x)[::-1]:
        return True
    return False

print biggest_p()
