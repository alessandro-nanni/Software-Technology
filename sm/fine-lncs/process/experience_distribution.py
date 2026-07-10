import os
import pandas as pd
import numpy as np
import matplotlib.pyplot as plt
import seaborn as sns

# Set seaborn theme for professional academic styling
sns.set_theme(style="whitegrid", context="paper", palette="muted")
plt.rcParams.update({
    'font.size': 11,
    'axes.labelsize': 12,
    'axes.titlesize': 13,
    'xtick.labelsize': 10,
    'ytick.labelsize': 10,
    'figure.titlesize': 14
})

# 1. Load the data using robust paths
possible_paths = [
    "material/Software Development Processes and Management techniques applied to Minecraft Datapacks.csv",
    "process/data.csv",
    "../material/Software Development Processes and Management techniques applied to Minecraft Datapacks.csv",
    "../process/data.csv",
    r"c:\Users\Ale\Documents\GitHub\Software-Technology\sm\fine-lncs\material\Software Development Processes and Management techniques applied to Minecraft Datapacks.csv"
]
csv_path = None
for p in possible_paths:
    if os.path.exists(p):
        csv_path = p
        break

if csv_path is None or not os.path.exists(csv_path):
    print("Error: Survey CSV data file not found!")
    exit(1)

print(f"Loading data from: {csv_path}")
df = pd.read_csv(csv_path)

# Determine the output folder for plots (matches analyze_questions.py convention)
output_dir = "process" if os.path.exists("process") else os.path.dirname(os.path.abspath(__file__))
if not os.path.exists(output_dir):
    os.makedirs(output_dir)

print(f"Output directory for plots: {output_dir}")

# 2. Map Q2 & Q4 columns to numeric
exp_col = df.columns[2]   # Q2: datapack experience
prog_col = df.columns[4]  # Q4: general programming familiarity

df['Datapack_Experience'] = pd.to_numeric(df[exp_col], errors='coerce')
df['Programming_Familiarity'] = pd.to_numeric(df[prog_col], errors='coerce')

data = df.dropna(subset=['Datapack_Experience', 'Programming_Familiarity'])

# 3. Compute descriptive stats and the share rating themselves "very experienced" (>=5 on 1-7 scale)
threshold = 5
exp_pct_high = (data['Datapack_Experience'] >= threshold).mean() * 100
prog_pct_high = (data['Programming_Familiarity'] >= threshold).mean() * 100
exp_mean, exp_median = data['Datapack_Experience'].mean(), data['Datapack_Experience'].median()
prog_mean, prog_median = data['Programming_Familiarity'].mean(), data['Programming_Familiarity'].median()

print(f"Q2 (Datapack Experience): M={exp_mean:.2f}, Mdn={exp_median:.1f}, {exp_pct_high:.1f}% rated >= {threshold}")
print(f"Q4 (Programming Familiarity): M={prog_mean:.2f}, Mdn={prog_median:.1f}, {prog_pct_high:.1f}% rated >= {threshold}")

# 4. Build a paired distribution plot (Q2 vs Q4 on the 1-7 scale)
melted = data.melt(value_vars=['Datapack_Experience', 'Programming_Familiarity'],
                    var_name='Question', value_name='Rating')
label_map = {
    'Datapack_Experience': 'Q2: Datapack Development Experience',
    'Programming_Familiarity': 'Q4: General Programming Familiarity'
}
melted['Question'] = melted['Question'].map(label_map)

fig, axes = plt.subplots(1, 2, figsize=(12, 5.5))

# Plot A: Overlaid distributions
sns.histplot(data=melted, x='Rating', hue='Question', bins=range(1, 9), multiple='dodge',
             shrink=0.85, discrete=True, ax=axes[0], palette=['#1f77b4', '#ff7f0e'])
axes[0].set_title("Distribution of Self-Reported Experience (Q2 & Q4)", pad=12)
axes[0].set_xlabel("Rating (1-7)")
axes[0].set_ylabel("Number of Respondents")
axes[0].set_xticks(range(1, 8))
axes[0].legend_.set_title(None)

# Plot B: Box + strip plot with the >=5 "very experienced" threshold marked
sns.boxplot(data=melted, x='Question', y='Rating', ax=axes[1], palette=['#1f77b4', '#ff7f0e'],
            showmeans=True, meanprops={"marker": "s", "markerfacecolor": "white", "markeredgecolor": "black"})
sns.stripplot(data=melted, x='Question', y='Rating', ax=axes[1], color='black', alpha=0.3, jitter=0.2, size=4)
axes[1].axhline(threshold, color='red', linestyle='--', linewidth=1.5, alpha=0.7)
axes[1].text(1.02, threshold, f'"Very experienced"\nthreshold ({threshold}+)', color='red', fontsize=9,
             va='center', ha='left', transform=axes[1].get_yaxis_transform())
axes[1].set_title("Spread of Self-Reported Experience", pad=12)
axes[1].set_xlabel("")
axes[1].set_ylabel("Rating (1-7)")
axes[1].set_ylim(0.5, 7.5)
axes[1].set_xticklabels(['Q2: Datapack\nExperience', 'Q4: Programming\nFamiliarity'])

plt.suptitle("Self-Reported Experience Levels of Survey Respondents", y=1.0, weight='bold')
plt.tight_layout()
plt.savefig(os.path.join(output_dir, "experience_distribution.png"), dpi=300, bbox_inches='tight')
plt.close()

print("Plot successfully saved as 'experience_distribution.png'")
