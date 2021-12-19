# baekjoon_9093
T = int(input())
li=[]

for _ in range(0, T):
  li.append(input())

for i in li:
  word = i.split()
  res = ""

  for j in word:
    for k in range(len(j)-1, -1, -1):
      res += j[k]
    res += " "
  print(res)