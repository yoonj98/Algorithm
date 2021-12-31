# chr : ASCII > NUMBER
# ord : NUMBER > ASCII

alpha = input()
res = ""

for i in range(0, len(alpha)):
    if (alpha[i] == 'A') | (alpha[i] == 'B') | (alpha[i] == 'C'):
        res += chr(ord(alpha[i])+23)
    else:
        res += chr(ord(alpha[i])-3)
print(res)