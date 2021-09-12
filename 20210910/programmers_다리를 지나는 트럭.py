# programmers_다리를 지나는 트럭
def solution(bridge_length, weight, truck_weights):
    res = 0
    truck = [0] * bridge_length
    while len(truck):
        res += 1
        truck.pop(0)
        if truck_weights:
            if sum(truck) + truck_weights[0] <= weight:
                truck.append(truck_weights.pop(0))
            else:
                truck.append(0)
    return res