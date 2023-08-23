A = int(input())
B = int(input())
C = int(input())


def count_number(number):
    count = [0] * 10

    for num in str(number):
        count[int(num)] += 1

    for i in range(10):
        print(count[i])

    return


count_number(A * B * C)
