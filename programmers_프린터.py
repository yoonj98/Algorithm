# 프로그래머스 프린터
def solution(priorities, location):
    answer = 0

    arr1 = [c for c in range(len(priorities))] # index 
    arr2 = priorities.copy() # 값 

    i = 0
    while True:
        if arr2[i] < max(arr2[i+1:]):
            arr1.append(arr1.pop(i))
            arr2.append(arr2.pop(i))
        else:
            i += 1

        if arr2 == sorted(arr2, reverse=True):
            break

    return arr1.index(location) + 1