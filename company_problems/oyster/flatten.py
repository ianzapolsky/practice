# recursively flatten a list of integers and nested lists of integers
# asked in phone interview on 2/13/14 with oyster
# Ian Zapolsky (2/13/14)


def flatten(list_to_flatten):
  flattened_list = []
  for element in list_to_flatten:
    if isinstance(element, list):
      nested_list = flatten(element)
      for i in nested_list:
        flattened_list.append(i)
    else:
      flattened_list.append(element)
  return flattened_list


test = [1,2,3,[4,5,],[6,7,[8,9,[10]]],11]
print flatten(test)
