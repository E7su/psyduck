# ===================================================================
# True/False interval
n = int(input())
print(-15 < n <= 12 or 14 < n < 17 or 19 <= n)


# ===================================================================
# calc
x = input()
y = input()
op = input()

# replace words to ops
op = op.replace('mod', '%').replace('pow', '**').replace('div', '//')

# evaluate string as python code
try:
    print(eval("(%s) %s (%s)" % (x, op, y)))
except ZeroDivisionError:
    print("Деление на 0!")


# ===================================================================
# min max
x = sorted([int(input()), int(input()), int(input())])
print (x[2], x[0], x[1], sep="\n")


# ===================================================================
# lucky ticket
n = list(map(int, list(input())))
print('Счастливый' if sum(n[:3]) == sum(n[3:]) else 'Обычный')
 
			