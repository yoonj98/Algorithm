li = []

for _ in range(0, 9):
    li.append(int(input()))
    
print(max(li))

for i in range(0, 9):
    if li[i] == max(li):
        print(i+1)