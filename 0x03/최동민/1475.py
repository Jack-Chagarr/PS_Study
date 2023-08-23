N = input()

num_array = [0] * 10
for num in N:
    num_array[int(num)] += 1

temp = (num_array[6] + num_array[9] + 1) // 2
num_array[6] = temp
num_array[9] = temp

print(max(num_array))
