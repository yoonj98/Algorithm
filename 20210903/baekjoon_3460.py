# baekjoon_3460

T = int(input())
li = []
res = []

for i in range(0, T):
  li.append(int(input()))

for i in li:
  tmp = i
  s = ""
  while(tmp != 0):
    s += str(tmp % 2)
    tmp /= 2
    tmp = int(tmp)
  res.append(s)

for i in res:
  s = ""
  for j in range(0, len(i)):
    if i[j] == "1":
      s += str(j)
      s += " "
  print(s)