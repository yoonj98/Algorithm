# 백준 12845 : 모두의 마블

n = int(input())

list1 = list(map(int, input().split()))
list1.sort(reverse= True)

result = 0

result += list1[0] + list1[1]
level = max(list1[0], list1[1])

for i in range(2, n):
    result +=level + list1[i]
    
print(result)