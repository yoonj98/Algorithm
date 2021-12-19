# programmers 네트워크
def dfs(node, computers, visited):
    visited[node] = True 
    
    for i, neighbor in enumerate(computers[node]):
        if neighbor > 0 and i != node and visited[i] == False:
            dfs(i, computers, visited)
    return visited

def solution(n, computers):
    answer = 1
    visited = [False] * n
    startNode = 0
    
    while True: 
        visited = dfs(startNode, computers, visited)
        if False in visited:
            startNode = visited.index(False)
            answer += 1
        else:
            break

    return answer