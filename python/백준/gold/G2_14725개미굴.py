N = int(input())
dict = {}
for i in range(N):
    inputarr = list(input().split())
    target_dict = dict
    for j in inputarr[1:]:
        if j not in target_dict:
            target_dict[j] = {}
        target_dict = target_dict[j]

def getresult(target, n):
    target_key = sorted(target.keys())
    for s in target_key :
        print('--'*n+s)
        getresult(target[s],n+1)

getresult(dict,0)
