'''

def canCut(height, rate, n, W, L, months):
    trees = 0
    for i in range(n):
        treeAvailable = height[i] + rate[i]*months
        if treeAvailable >= L:
            trees += treeAvailable
    return trees >= W

n, W, L = list(map(int, input().split()))
height, rate = [], []
for i in range(n):
    inp = list(map(int, input().split()))
    height.append(inp[0])
    rate.append(inp[1])


low, high = 0, int(1e20)
ans = 0
while low <= high:
    mid = low + ((high-low)>>1)
    if canCut(height, rate, n, W, L, mid):
        high = mid - 1
        ans = mid
    else:
        low = mid + 1
print(int(ans))

'''