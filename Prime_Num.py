# 소수 판별 O(N)
def is_prime(n):
    for i in range(2, n):
        if n % i == 0 :
            return False
    return True

# 소수 판별 O(N^0.5)
import math
def is_prime_num(n):
    for i in range(2, int(math.sqrt(n))+1):
        if n % i == 0:
            return False
    return True

print(is_prime(4))
print(is_prime(7))
print(is_prime_num(4))
print(is_prime_num(7))


# 에라토스테네스의 체 O(NloglogN)
import math

n = 1000 # 2부터 1000까지의 모든 수에 대해 소수 판별
array = [True for i in range(n+1)]

for i in range(2, int(math.sqrt(n)) + 1):
    if array[i] == True: # i가 소수인 경우, i를 제외한 i의 모든 배수를 삭제
        j = 2
        while i * j <= n:
            array[i*j] = False
            j += 1

for i in range(2, n+1):
    if array[i]:
        print(i, end = ' ')