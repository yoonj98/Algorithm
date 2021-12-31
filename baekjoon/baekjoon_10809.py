# baekjoon_10809
from string import ascii_lowercase

# alpha_list = list(map(chr, range(97, 123))) 
# alpha_list = list(map(chr, range(ord('a'), ord('z')+1)))
alpha_list = list(ascii_lowercase)

s = input()
res = ""

for i in alpha_list:
  res += str(s.find(i))
  res += " "

print(res)