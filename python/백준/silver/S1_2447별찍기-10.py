from copy import deepcopy

start = []
start.append('***')
start.append('* *')
start.append('***')
N = int(input())

def recur(n, S) :
    if(n == N):
        for i in range(n):
            print(S[i])
        return
    newS = deepcopy(S)
    for i in range(n):
        newS[i] += S[i] * 2
        newS.append(S[i])
        newS[n+i] += ' '*n
        newS[n + i] += S[i]
    for i in range(n):
        newS.append(newS[i])
    recur(n*3,newS)

recur(3,start)