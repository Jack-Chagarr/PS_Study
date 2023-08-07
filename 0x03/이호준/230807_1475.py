from math import ceil

n = input()
nums = list(range(10))
nums_cnt_dict = {key:0 for key in nums}
for c in n:
    if c == '9':
        nums_cnt_dict[6] += 1
    else:
        nums_cnt_dict[int(c)] += 1

nums_cnt_dict[6] = ceil(nums_cnt_dict[6] / 2)
nums_cnt_list = list(nums_cnt_dict.items())
nums_cnt_list.sort(key=lambda x: (x[1], x[0]), reverse=True)

print(nums_cnt_list[0][1])
