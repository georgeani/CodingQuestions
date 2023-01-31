"""Question:
    Define a generator which generates the positive integers up to and including a supplied value
    which are divisible by another supplied positive integer and use it to calculate the sum of all
    positive integers less than 102030 which are divisible by 3
    """

def generator(maximum_val:int, divisor:int) -> int:
    """If the divisor (second integer supplied) is 0 then 0 will be returned as 0 has no multiples.
            List comprehension is used generate the numbers that are multiples of m
            but below the limit.
            The multiples are evaluated if are divisible by 3 and do not
            exceed 102030. If the requirements are met, they are added in the list.
            Summing happens before the output is returned."""

    if divisor ==0:
        return 0

    return sum([i for i in range(0,maximum_val+1,divisor) if i%3==0 and i<102030])

if __name__ == "__main__":
    print(generator(102035,3))