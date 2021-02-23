from collections import deque
R , C , N = map(int,input().split())
map = []
N-= 1
for i in range(R):
    S = input()
    list = []
    for j in range(C):
        if(S[j] == '.'):
            list.append(0)
        else:
            list.append(2)
    map.append(list)
dr = [1,-1,0,0]
dc = [0,0,1,-1]
job = 0

que = deque()
for t in range(N):
    if(job == 0):
        for i in range(R):
            for j in range(C):
                if(map[i][j] == 0):
                    map[i][j] = 3
                else :
                    map[i][j] -= 1
        job = 1
    else :
        for i in range(R):
            for j in range(C):
                if(map[i][j] != 0):
                    map[i][j] -=1
                    if(map[i][j] == 0):
                        que.append([i,j])
        while(que):
            list = que.popleft()
            for i in range(4):
                row = list[0] + dr[i]
                col = list[1] + dc[i]
                if(row <0 or col <0 or row>= R or col >= C):
                    continue
                map[row][col] = 0
        job = 0

result = ''
for i in range(R):
    for j in range(C):
        if(map[i][j] == 0):
            result += '.'
        else :
            result += 'O'
    result+='\n'
print(result)