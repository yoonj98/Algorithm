# programmers 여행경로
def solution(tickets):
    answer = []
    routes = dict()

    for (start, end) in tickets:
        if start in routes:
            routes[start].append(end)
        else:
            routes[start] = [end]
            
    for r in routes.keys():
        routes[r].sort(reverse = True)

    st = ["ICN"]
    
    while st:
        top = st[-1]
        
        if (top not in routes) or (not routes[top]):
            answer.append(st.pop())  
        else:
            st.append(routes[top].pop())

    return answer[::-1]