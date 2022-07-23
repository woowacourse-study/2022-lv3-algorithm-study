import sys

readLine = sys.stdin.readline


def solution(start, end):
    next_stations = set([start])

    answer = 0
    while next_stations:
        stations = set() | next_stations
        next_stations = set()

        for station in stations:
            if station == end:
                return answer
            if station < 1 or station_count < station:
                continue
            if visited[station]:
                continue
            visited[station] = True
            next_stations.update([station - 1, station + 1])
            next_stations.update(teleports[station])
        answer += 1

    return answer


if __name__ == "__main__":
    station_count, teleport_count = map(int, readLine().split())
    start, end = map(int, readLine().split())

    visited = [False] * (station_count + 1)
    teleports = {i: [] for i in range(station_count + 1)}
    for _ in range(teleport_count):
        a, b = map(int, readLine().split())
        teleports[a].append(b)
        teleports[b].append(a)

    answer = solution(start, end)
    print(answer)
