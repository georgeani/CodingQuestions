"""Question:
    Write a function in a language of your choice which, when passed two sorted arrays of integers
    returns an array of any numbers which appear in both. No value should appear in the returned
    array more than once."""


def sorted_arrays(array_1st:list, array_2nd:list) -> list:
    """We take the  list and convert them to arrays to remove any duplicate values
        once this has been completed. We convert them to set and use intersection to
        find the common values which are then parsed to a list and returned.
        Through this use we avoid the returned list to have duplicates. the list is sorted as the dictionaries
        may contain the same keys in different areas and thus in the intersection a non-sorted list is created"""
    array_1st = dict.fromkeys(array_1st)
    array_1st = set(array_1st.keys())
    array_2nd = dict.fromkeys(array_2nd)
    array_2nd = set(array_2nd.keys())

    common_key = array_1st.intersection(array_2nd)
    common_key = list(common_key)
    common_key.sort()

    return common_key

if __name__ == "__main__":
    array_1 = [1,23,5,8]
    array_1.sort()
    array_2 = [1,23,1,8]
    array_2.sort()
    print(sorted_arrays(array_1,array_2))