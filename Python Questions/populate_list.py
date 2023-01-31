"""Question:
    Write a function which is passed an integer, n, and returns a list of n lists such that:
    f(0) returns []
    f(1) returns [[1]]
    f(2) returns [[1], [1,2]]
    f(3) returns [[1], [1,2], [1,2,3]]"""

def populate_list(n:int)->list:

    """For loop is used generate the main list and provide the range
        for the other lists to be generated.
        List comprehension is used for the internal lists"""
    ans = []
    for i in range(1,n+1):
        ans.append([m for m in range(1,i+1)])

    return ans

if __name__ == "__main__":
    print(populate_list(5))