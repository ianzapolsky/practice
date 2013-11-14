#****************************
# problem_20.py -> Find the sum of the digits in n!
# by ianzapolsky
# 7/6/12
#****************************

class ProblemSolver():
    
    def find_factorial(self, n):
        factorial = 1
        for i in reversed(xrange(1, n+1)):
            factorial = factorial*i
        return factorial

    def find_sum(self, factorial):
        int_list = [int(i) for i in str(factorial)]
        sum = 0
        for i in int_list:
            sum += i
        return sum

if __name__ == '__main__':
    
    p = ProblemSolver()
    factorial = p.find_factorial(100)
    print p.find_sum(factorial)
