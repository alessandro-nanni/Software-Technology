import pandas as pd
import matplotlib.pyplot as plt
import seaborn as sns

# 1. Load the data
df = pd.read_csv("sm/fine-lncs/process/data.csv")

# 2. Define the numerical column you want to analyze
# Replace this with your exact column name if different
column_name = "How many datapacks have you released?"

display_name = "Datapacks Released"

# Ensure the column is strictly numerical, converting any text issues to NaN
df[column_name] = pd.to_numeric(df[column_name], errors='coerce')

# 3. Calculate and display statistics
stats = df[column_name].describe()
print(f"--- Statistics for '{column_name}' ---")
print(stats)

# 4. Generate the visualization
# Create a figure with two subplots side-by-side
fig, axes = plt.subplots(1, 2, figsize=(12, 5))

# Plot A: Histogram with a Kernel Density Estimate (KDE) curve
sns.histplot(df[column_name].dropna(), kde=True, ax=axes[0], color='skyblue')
axes[0].set_title(f'Distribution of {display_name}')
axes[0].set_xlabel(display_name)
axes[0].set_ylabel("Frequency")

# Plot B: Boxplot to easily identify outliers and the interquartile range
sns.boxplot(x=df[column_name].dropna(), ax=axes[1], color='lightgreen')
axes[1].set_title(f'Boxplot of {display_name}')
axes[1].set_xlabel(display_name)

# Adjust layout and save as a PNG
plt.tight_layout()
plt.savefig('sm/fine-lncs/process/stats_plot.png')
print("\nPlot successfully saved as 'stats_plot.png'")