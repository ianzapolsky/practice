# count_sort.py
# implementation of counting sort
# ian zapolsky

# counting sort, a O(n) sort non-comparison based sorting algorithm
# params: a=list to be sorted, k=highest integer in input range
def count_sort(a, k):

  # create work array c
  c = [0] * (k+1)

  # create output array b
  b = [0] * (len(a))

  # store the number of occurences of each element in a in c
  for i in range(len(a)):
    c[a[i]] += 1

  # now change c[i] to contain the number of elements <= i 
  for i in range(1, k+1):
    c[i] += c[i-1]

  # now output the results of our work into b
  for i in reversed(range(1, len(a))):
    b[c[a[i]]-1] = a[i]
    c[a[i]] -= 1

  return b

def find_in_range(a, k, range_a, range_b):
  
  # begin preprocessing
  # create work array c in the same way we do for counting sort
  c = [0] * (k+1)
  for i in range(len(a)):
    c[a[i]] += 1
  for i in range(1, k+1):
    c[i] += c[i-1]

  # end preprocessing

  # find the number of elements that lie between range_a and range_b, inclusive
  print str(c[range_b] - c[range_a - 1])+' elements between '+str(range_a)+' and '+str(range_b)


a = [1,2,3,4,5,3,4,2,2,0,0]
k = 5
print count_sort(a,k)
find_in_range(a,k,3,4)
     
