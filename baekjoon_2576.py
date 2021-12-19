# baekjoon_2576
li=[]

for i in range(0, 7):
  li.append(int(input()))

li = sorted(li)

res = 0
min_value = 0

for i in range(0, 7):
  if li[i] % 2 != 0:
    if res == 0:
      min_value = li[i]
    res += li[i]

if res == 0:
  print(-1)
else:
  print(res)
  print(min_value)