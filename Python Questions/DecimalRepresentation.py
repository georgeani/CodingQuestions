"""Question:
    Write a function in a language of your choice which, when passed a positive integer returns
    true if the decimal representation of that integer contains no odd digits and otherwise returns
    false."""

def decimal_representation(integer: int) -> bool:
    """The number is converted to float which is the decimal representation in Python.
        The number is then converted to a string and looped. If string the has one odd element
        the loop stops and a False value is returned. Else a true values is returned at the end."""
    if integer<=0:
        return False

    dec = float(integer)
    dec = str(dec)

    for de in dec:
        if de != ".":
            if int(de)%2!=0:
                return False
    return True


if __name__ == "__main__":
    print(decimal_representation(int("1"+"2"*10 + "5"*10)))