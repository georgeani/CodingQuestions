"""Question:
    Write a function in a language of your choice which, when passed a decimal digit X, returns the
    value of X+XX+XXX+XXXX. E.g. if the supplied digit is 3 it should return 3702
    (3+33+333+3333)."""

def increase_size(x):
    """The question asks to return this value X+XX+XXX+XXXX where X is the supplied digit.
        This approach relies on the idea that the number of occurrences increases at the end.
         A loop is used to calculate the number of occurrences of X. The number of occurrences are
         represented by ones, meaning that if you had XX, this would be 11.
         This is as if you were to multiply by X with 1111, you would get the XXXX.
         As the loop runs the number of occurrences decreases.
         Thus, we get an X, the smaller value, at the end.
         We then sum the array to get the result.
         The main advantage of this approach is that it can be dynamic by assigning max_val as a
         method parameter.
         """


    ans = []
    max_val = 4

    for m in range(0,max_val):
        ans.append(float('1'*(max_val-m))*x)

    print(ans)
    return sum(ans)

if __name__ =="__main__":
    print(increase_size(3.0))
    print(1234*3)