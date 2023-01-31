"""Question:
    Write a program in a language of your choice to calculate the sum of the first 100 even-valued
    Fibonacci numbers"""

def calc_even_fibonacci() -> int:
    """Trying to calculate the Fibonacci sequence recursively will not be beneficial
        as such the use of a formula is necessary to achieve faster results.
        Since we are looking for even fibonacci numbers we will use the EFn = 4EFn-1 + EFn-2
        formula, with seed values EF0 = 0 and EF1 = 2.
        This formula only calculates even-valued Fibonacci numbers.
        Dynamic Programming is used to accelerate the process of calculation.
        As no recursion needs to take place and
        future even Fibonacci numbers are more easily calculated"""

    fib = [0,2]

    for i in range(2,100+1):
        fib.append(4*fib[i-1]+fib[i-2])

    return sum(fib)

if __name__ == "__main__":
    print(calc_even_fibonacci())
