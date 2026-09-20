def findMinStep(n):
    if n == 0:
        return 0

    temp = n
    digits = []

    # Extract digits without changing n
    while temp > 0:
        digits.append(temp % 10)
        temp //= 10

    min_steps = float('inf')

    for digit in digits:
        if digit != 0:  # Avoid subtracting 0
            min_steps = min(min_steps, 1 + findMinStep(n - digit))

    return min_steps
n = int(input())
print(findMinStep(n))