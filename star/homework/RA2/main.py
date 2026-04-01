import itertools

def evaluate_condensed(a: bool, b: bool, c: bool, d: bool, e: bool) -> bool:

    return (a and (b or c)) or ((b or c) and (d and e))

if __name__ == "__main__":
    print("Combinations resulting in TRUE:")
    print("-" * 50)
    print(f"{'A':<6} | {'B':<6} | {'C':<6} | {'D':<6} | {'E':<6} || RESULT")
    print("-" * 50)

    possible_values = [False, True]
    all_combinations = itertools.product(possible_values, repeat=5)

    for combination in all_combinations:
        a, b, c, d, e = combination
        
        result = evaluate_condensed(a, b, c, d, e)
        
        if result:
            print(f"{str(a):<6} | {str(b):<6} | {str(c):<6} | {str(d):<6} | {str(e):<6} || {result}")