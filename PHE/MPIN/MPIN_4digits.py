def get_digits(n):
    return [int(d) for d in str(n)]

def is_subarray(arr1, arr2):
    str1 = ''.join(map(str, arr1))
    str2 = ''.join(map(str, arr2))
    return str1 in str2

def is_repetitive(arr):
    return all(x == arr[0] for x in arr)

def is_sequential(arr):
    diffs = [arr[i] - arr[i - 1] for i in range(1, len(arr))]
    return all(x == diffs[0] for x in diffs)

def check_mpin(mpin, dob, marriage_aniv, veh_no):
    mpin_digits = get_digits(mpin)
    dob_digits = get_digits(dob)
    aniv_digits = get_digits(marriage_aniv)
    veh_digits = get_digits(veh_no)

    if len(str(dob)) != 8:
        return "Error: DOB must be of 8 digits"
    if len(str(marriage_aniv)) != 8:
        return "Error: Marriage Anniversary must be of 8 digits"
    if len(str(veh_no)) != 4:
        return "Error: Vehicle Number must be of 4 digits"
    if len(mpin_digits) != 4:
        return "Error: MPIN must be of 4 digits"

    weak_mpins = {
        1234, 0, 1111, 2222, 3333, 4444, 5555, 6666, 7777, 8888, 9999,
        1122, 1212, 4321, 5678, 4567, 3690, 1478, 8080, 1010, 9191, 9876, 7890
    }

    if mpin in weak_mpins:
        return "WEAK PASSWORD"

    if is_subarray(mpin_digits, dob_digits):
        return "Password is Weak because it consists of your DOB"
    if is_subarray(mpin_digits, aniv_digits):
        return "Password is Weak because it consists of your Marriage Anniversary"
    if mpin_digits == veh_digits:
        return "Password is Weak because it consists of your Vehicle Number"
    if is_repetitive(mpin_digits):
        return "Password is Weak because it is repetitive"
    if is_sequential(mpin_digits):
        return "Password is Weak because it is in an order"

    return "Strong Password"

if _name_ == "_main_":
    try:
        dob = int(input("Enter your DOB in DDMMYYYY format: "))
        marriage_aniv = int(input("Enter your Marriage Anniversary in DDMMYYYY format: "))
        veh_no = int(input("Enter your Vehicle Number (last 4 digits): "))
        mpin = int(input("Enter an MPIN (4 digits): "))

        print(check_mpin(mpin, dob, marriage_aniv, veh_no))
    except ValueError:
        print("Error: Please enter only numeric values.")
