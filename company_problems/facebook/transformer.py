
class Node:

    def __init__(self, init_data):
        self.data = init_data
        self.left = None
        self.right = None

def buildBST():
    left = Node(1)
    root = Node(2)
    right = Node(3)
    root.left = left
    root.right = right
    return root

def transformBST(root):
    root.left = recurseLeft(root.left, root)
    root.right = recurseRight(root.right, root)
    while root.left is not None:
        root = root.left
    return root

def recurseLeft(cur, caller):
    if cur is None:
        return None
    cur.left = recurseLeft(cur.left, cur)
    cur.right = recurseRight(cur.right, cur)
    while cur.right is not None:
        cur = cur.right
    cur.right = caller
    return cur

def recurseRight(cur, caller):
    if cur is None:
        return None
    cur.left = recurseLeft(cur.left, cur)
    cur.right = recurseRight(cur.right, cur)
    while cur.left is not None:
        cur = cur.left
    cur.left = caller
    return cur

root = buildBST()
print root.left.data
print root.data
print root.right.data
root = transformBST(root)
print root.data
print root.right.data
print root.right.right.data

