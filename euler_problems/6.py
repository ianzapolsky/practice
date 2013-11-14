
def sum_of_squares(threshold):
    val = 0
    for x in range(1, threshold+1):
        val += x*x
    return val

def square_of_sum(threshold):
    val = 0
    for x in range(1, threshold+1):
        val += x
    return val*val

sum_o_squares = sum_of_squares(100)
square_o_sums = square_of_sum(100)
print (square_o_sums - sum_o_squares)
