
def evaluate_condensed(a: bool, b: bool, c: bool, d: bool, e: bool) -> bool:

    return (a and (b or c)) or ((b or c) and (d and e))

print(evaluate_condensed(True,False,False,True,False))