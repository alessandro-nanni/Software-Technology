import numpy as np
from scipy.linalg import expm

# Define your variables (replace with your actual values)
p_a = 4
p_b = 2
p_c = 1
t = 0.4

# Define the matrix A
A = np.array([
    [-p_a - p_b - p_c, p_a + p_c, p_b, 0],
    [0, -p_b, 0, p_b],
    [0, 0, -p_c, p_c],
    [0, 0, 0, 0]
])

# Compute the matrix exponential e^(tA)
exp_tA = expm(t * A)

# Define the row vector v
v = np.array([1, 0, 0, 0])

# Compute the dot product v * e^(tA)
result = v.dot(exp_tA)

print("Resulting vector:")
print(result)