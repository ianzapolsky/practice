#*********************************
# problem_13.py -> Find the first 10 digits of the sum of the numbers in fifty_digit.txt
# by ianzapolsky
# 7/6/12
#********************************

class ProblemSolver():
    
    def read_file(self, file_name):
        num_list = []
        number_file = open(file_name, 'r')
        num = number_file.readline()
        while (num != ''):
            num = self.strip_num(num)
            num_list.append(int(num))
            num = number_file.readline()
        return num_list
    
    def strip_num(self, num):
        stripped_num = num.rstrip()
        return stripped_num

    def find_digits(self, num_list, range_lower, range_upper):
        big_num = 0
        for num in num_list:
            big_num += num
        big_digits = [int(i) for i in str(big_num)]
        digit_str = ''
        for i in xrange(range_lower, range_upper):
            digit_str += str(big_digits[i])
        return digit_str

if __name__ == '__main__':
    
    p = ProblemSolver()
    print p.find_digits(p.read_file('/Users/ianzapolsky/TEST/txt_files/fifty_digit.txt'), 0, 10)
    
