# 18.py

# Description: Find the maximum sum path of some triangle with n rows
# Author: Ian Zapolsky

import sys

def input_triangle():

    if len(sys.argv) != 2:
        print "usage: 18.py <triangle file>"
        sys.exit()

    triangle_file = open(sys.argv[1])
    triangle_array = []
    rows = 0
    
    for line in triangle_file:
        rows += 1
        for num in line.rsplit(' '):
            triangle_array.append(int(num))
    
    find_max_path(rows, triangle_array)

    return triangle_array[0]

    
def find_max_path(rows, triangle_array):

    if rows == 0:
        return
    else:
        for i in range(row_index(rows-1), row_index(rows)):
            triangle_array[i] = max(triangle_array[i]+triangle_array[i+rows-1],
                                    triangle_array[i]+triangle_array[i+rows])      
   
    find_max_path(rows-1, triangle_array)


def row_index(row):
    return row*(row-1)/2


print input_triangle()        
