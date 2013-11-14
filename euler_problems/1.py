# 1.py

# Description: Find the sum of all the multiples of 3 and 5 below 1000.
# Author: Ian Zapolsky (11/01/13)

class ProblemSolver():
    def solve_problem(self):
        sum = 0
        for i in range(0, 1000):
            if (i%3 == 0) or (i%5 == 0):
                sum += i
        return sum

if __name__ == '__main__':

    p = ProblemSolver()
    print p.solve_problem()
