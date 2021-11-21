# baejoon 1966
testCase = int(input())

for _ in range(testCase):
    N, M = map(int,input().split())

    printList = list(map(int,input().split()))
    checkList = [0 for _ in range(N)] 
    checkList[M] = 1 # 문서위치

    cnt=0
    while True:
        if printList[0] == max(printList):
            cnt+=1

            if checkList[0] != 1:
                del printList[0]
                del checkList[0]
            else:
                print(cnt)
                break
        else:
            printList.append(printList[0])
            checkList.append(checkList[0])
            del printList[0]
            del checkList[0]