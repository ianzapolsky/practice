

class ProblemSolver():

    def solve_problem(self, fib_list):
        sum = 0
        for i in fib_list:
            if i%2 == 0:
                sum += i
        return sum

    def make_fib_list(self):
        fib_list = [1, 2]
        while (fib_list[len(fib_list)-1]+fib_list[len(fib_list)-2]) < 4000000:
            new_num = fib_list[len(fib_list)-1]+fib_list[len(fib_list)-2]
            fib_list.append(new_num)
        return fib_list

if __name__ == '__main__':

    p = ProblemSolver()
    fib_list = p.make_fib_list()
    print p.solve_problem(fib_list)
