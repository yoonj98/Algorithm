# programmers_소수만들기
from itertools import combinations
import math

def prime(n):
    sqrt = math.sqrt(n)

    if sqrt < 2:
        return False

    for i in range(2, int(sqrt+1)):
        if n % i == 0:
            return False
    return  True

def solution(num):
    res = 0
    li = list(combinations(num, 3))

    for n1, n2, n3 in li:
        if prime(n1+n2+n3):
            res += 1

    return res