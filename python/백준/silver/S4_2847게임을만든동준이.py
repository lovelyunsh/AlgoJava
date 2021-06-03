N = int(input())
arr = []
for _ in range(N):
    arr.append(int(input()))
cnt = 0
num = arr[N-1]
arr.reverse()
for i in arr[1:]:
    if(i >= num):
        cnt += i - num +1
        num = num-1
    else:
        num = i

print(cnt)


