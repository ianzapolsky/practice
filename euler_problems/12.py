#**********************************
# problem_12.py -> find the first triangle number with > 500 divisors
# by ianzapolsky
# 7/6/12
#**********************************

class ProblemSolver():

    def list_triangle_nums(self):
        triangle_nums = []
        trail = [1]
        count = 0
        next_trail_val = 2
        while len(self.determine_factors(trail[len(trail)-1])) <=501:
            triangle_nums.append(sum(trail))
            for i in reversed(xrange(1, next_trail_val+1)):
                count += i
            trail.append(count)
            next_trail_val = next_trail_val + 1
            count = 0
        return trail

    def determine_factors(self, num):
        factors = []
        for i in xrange(1, num):
            if num%i == 0:
                factors.append(i)
        return factors

if __name__ == '__main__':

    p = ProblemSolver()
    print p.list_triangle_nums()

    
