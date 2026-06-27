import os
import pandas as pd
import numpy as np
import matplotlib.pyplot as plt
import seaborn as sns
from scipy.stats import spearmanr

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

# Determine the output folder for plots
# We want it to be in 'process' relative to the workspace root or the script location
script_dir = os.path.dirname(os.path.abspath(__file__)) if '__file__' in locals() else os.getcwd()
output_dir = os.path.join(script_dir, "plots") if os.path.basename(script_dir) == "process" else "process"
# If we are running from project root, put in process/ folder.
if os.path.exists("process"):
    output_dir = "process"
elif os.path.basename(script_dir) == "process":
    output_dir = script_dir
else:
    output_dir = "process"

if not os.path.exists(output_dir):
    os.makedirs(output_dir)

print(f"Output directory for plots: {output_dir}")

# 2. Map columns to cleaner names
age_col = df.columns[1]
exp_col = df.columns[2]
released_col = df.columns[3]
prog_col = df.columns[4]
hobby_col = df.columns[5]
comp_col = df.columns[6]
precomp_col = df.columns[9]
libs_col = df.columns[10]
llm_col = df.columns[11]
team_col = df.columns[12]
git_col = df.columns[13]
cycle_col = df.columns[14]
comment_freq_col = df.columns[16]
comment_qty_col = df.columns[17]
refactor_col = df.columns[20]
convention_col = df.columns[21]

# Convert columns to numeric, handling errors
df['Age'] = pd.to_numeric(df[age_col], errors='coerce')
df['Released'] = pd.to_numeric(df[released_col], errors='coerce')
df['Experience'] = pd.to_numeric(df[exp_col], errors='coerce')
df['Programming'] = pd.to_numeric(df[prog_col], errors='coerce')
df['Hobby'] = pd.to_numeric(df[hobby_col], errors='coerce')
df['Comp'] = pd.to_numeric(df[comp_col], errors='coerce')
df['Libs'] = pd.to_numeric(df[libs_col], errors='coerce')
df['LLM'] = pd.to_numeric(df[llm_col], errors='coerce')
df['Team'] = pd.to_numeric(df[team_col], errors='coerce')
df['Cycle'] = pd.to_numeric(df[cycle_col], errors='coerce')
df['CommentFreq'] = pd.to_numeric(df[comment_freq_col], errors='coerce')
df['CommentQty'] = pd.to_numeric(df[comment_qty_col], errors='coerce')

# Parse Refactoring/Optimization percentage
def clean_refactor(val):
    if pd.isna(val):
        return np.nan
    val_str = str(val).strip().replace('%', '')
    try:
        return float(val_str)
    except ValueError:
        import re
        nums = re.findall(r'\d+', val_str)
        if nums:
            return float(np.mean([float(n) for n in nums]))
        return np.nan

df['Refactor'] = df[refactor_col].apply(clean_refactor)

# 3. Categorize into G1, G2, G3 groups by age
# G1: Under 18 (<= 18), G2: 19-23, G3: 24+
def get_group(age):
    if pd.isna(age):
        return 'Unknown'
    elif age <= 18:
        return 'G1'
    elif 19 <= age <= 23:
        return 'G2'
    else:
        return 'G3'

df['Group'] = df['Age'].apply(get_group)


# ----------------------------------------------------
# HYPOTHESIS 1: Techniques used by age groups
# ----------------------------------------------------
print("Analyzing Hypothesis 1...")
# Techniques: Use Git, Use Precompiler/Scripts, Adhere to Conventions, Comment Frequently (>=5)
df['Uses_Git'] = df[git_col].notna() & (df[git_col].str.strip() != "")
df['Uses_Precompiler'] = df[precomp_col].apply(lambda x: 'plain mcfunction' not in str(x).lower() if pd.notna(x) else False)
df['Uses_Conventions'] = df[convention_col].apply(
    lambda x: pd.notna(x) and not any(term in str(x).lower() for term in ["don't know", "don't use", "don't adhere"])
)
df['Comments_Frequently'] = df['CommentFreq'] >= 5

# Calculate percentages by age group (excluding Unknown)
known_groups = df[df['Group'] != 'Unknown']
h1_data = known_groups.groupby('Group')[['Uses_Git', 'Uses_Precompiler', 'Uses_Conventions', 'Comments_Frequently']].mean() * 100
h1_data = h1_data.reset_index().melt(id_vars='Group', var_name='Technique', value_name='Percentage')

# Map Group names for plot and legend
h1_data['Group'] = h1_data['Group'].map({
    'G1': 'G1 (<=18)',
    'G2': 'G2 (19-23)',
    'G3': 'G3 (24+)'
})

# Map technique names for plot
tech_labels = {
    'Uses_Git': 'Version Control (Git)',
    'Uses_Precompiler': 'Scripts/Precompilers',
    'Uses_Conventions': 'Coding Conventions',
    'Comments_Frequently': 'Comments Frequently (>=5)'
}
h1_data['Technique'] = h1_data['Technique'].map(tech_labels)

plt.figure(figsize=(9, 5.5))
ax = sns.barplot(x='Technique', y='Percentage', hue='Group', data=h1_data, 
                hue_order=['G1 (<=18)', 'G2 (19-23)', 'G3 (24+)'], palette='viridis')
plt.title("Adoption of Software Engineering Techniques by Age Group", pad=15)
plt.xlabel("Software Engineering Technique")
plt.ylabel("Adoption Rate (%)")
plt.ylim(0, 105)
# Add value labels on top of bars
for p in ax.patches:
    height = p.get_height()
    if height > 0:
        ax.annotate(f'{height:.1f}%', 
                    (p.get_x() + p.get_width() / 2., height + 1.5), 
                    ha='center', va='center', xytext=(0, 5), 
                    textcoords='offset points', fontsize=9)
plt.legend(title="Age Group", loc='upper right')
plt.tight_layout()
plt.savefig(os.path.join(output_dir, "h1_techniques.png"), dpi=300)
plt.close()


# ----------------------------------------------------
# HYPOTHESIS 2: Percentage with 0 released datapacks
# ----------------------------------------------------
print("Analyzing Hypothesis 2...")
# Compare G1, G2, G3 on percentage who released 0 datapacks
zero_dp_group = known_groups.groupby('Group').apply(
    lambda x: pd.Series({
        'Zero_Release_Pct': (x['Released'] == 0).mean() * 100,
        'Count_Zero': (x['Released'] == 0).sum(),
        'Total': len(x)
    })
).reset_index()

plt.figure(figsize=(7, 5))
ax = sns.barplot(x='Group', y='Zero_Release_Pct', data=zero_dp_group, order=['G1', 'G2', 'G3'], palette='magma')
plt.title("Percentage of Developers with 0 Released Datapacks", pad=15)
plt.xlabel("Age Group")
plt.ylabel("Developers with 0 Releases (%)")
plt.ylim(0, 30)

# Annotate with counts
for idx, row in zero_dp_group.iterrows():
    group_idx = ['G1', 'G2', 'G3'].index(row['Group'])
    val = row['Zero_Release_Pct']
    ax.text(group_idx, val + 1, f"{val:.1f}%\n({int(row['Count_Zero'])}/{int(row['Total'])})", 
            ha='center', va='bottom', fontsize=10, fontweight='bold')

plt.xticks([0, 1, 2], ['G1 (<=18)', 'G2 (19-23)', 'G3 (24+)'])
plt.tight_layout()
plt.savefig(os.path.join(output_dir, "h2_zero_released.png"), dpi=300)
plt.close()


# ----------------------------------------------------
# HYPOTHESIS 3: Released Datapacks vs Experience for G2 & G3
# ----------------------------------------------------
print("Analyzing Hypothesis 3...")
g23_df = df[df['Group'].isin(['G2', 'G3'])].dropna(subset=['Released', 'Experience'])

# Run Spearman correlation
rho, p_val = spearmanr(g23_df['Experience'], g23_df['Released'])

plt.figure(figsize=(8, 5.5))
# Add slight jitter to experience since it is on a 1-7 scale
sns.regplot(x='Experience', y='Released', data=g23_df, 
            x_jitter=0.15, scatter_kws={'alpha': 0.6, 'color': '#1f77b4'}, 
            line_kws={'color': '#d62728', 'linewidth': 2})
plt.title("Released Datapacks vs. Perceived Datapack Experience (G2 & G3)", pad=15)
plt.xlabel("Perceived Datapack Experience (1-7)")
plt.ylabel("Number of Datapacks Released")
plt.xlim(0.5, 7.5)
plt.xticks(range(1, 8))
# Place correlation coefficients on plot
plt.text(0.05, 0.95, f"Spearman's $\\rho$ = {rho:.3f}\n$p$-value = {p_val:.4f}\n$N$ = {len(g23_df)}", 
         transform=plt.gca().transAxes, fontsize=11, 
         bbox=dict(boxstyle="round,pad=0.3", facecolor="white", edgecolor="gray", alpha=0.8),
         verticalalignment='top')
plt.tight_layout()
plt.savefig(os.path.join(output_dir, "h3_released_vs_experience.png"), dpi=300)
plt.close()


# ----------------------------------------------------
# HYPOTHESIS 4: Commenting Alone vs. Team
# ----------------------------------------------------
print("Analyzing Hypothesis 4...")
df['WorkMode'] = df['Team'].apply(lambda x: 'Alone' if x == 0 else ('Team' if x > 0 else 'Unknown'))
comment_df = df[df['WorkMode'] != 'Unknown'].dropna(subset=['CommentFreq', 'CommentQty'])

# Reshape data for plotting
comment_melted = comment_df.melt(id_vars='WorkMode', value_vars=['CommentFreq', 'CommentQty'], 
                                  var_name='Metric', value_name='Score')
metric_labels = {
    'CommentFreq': 'Comment Frequency',
    'CommentQty': 'Comment Quantity/Depth'
}
comment_melted['Metric'] = comment_melted['Metric'].map(metric_labels)

plt.figure(figsize=(8, 5.5))
ax = sns.barplot(x='Metric', y='Score', hue='WorkMode', data=comment_melted, palette='Set2')
plt.title("Commenting Practices: Solo vs. Team Developers", pad=15)
plt.xlabel("")
plt.ylabel("Average Score (1-7)")
plt.ylim(1, 7.2)

# Value labels
for p in ax.patches:
    height = p.get_height()
    if height > 0:
        ax.annotate(f'{height:.2f}', 
                    (p.get_x() + p.get_width() / 2., height + 0.1), 
                    ha='center', va='center', xytext=(0, 5), 
                    textcoords='offset points', fontsize=10, fontweight='bold')

plt.legend(title="Work Mode")
plt.tight_layout()
plt.savefig(os.path.join(output_dir, "h4_commenting.png"), dpi=300)
plt.close()


# ----------------------------------------------------
# HYPOTHESIS 5: Refactor % vs Release Cycle (G2 & G3)
# ----------------------------------------------------
print("Analyzing Hypothesis 5...")
g23_refac_cycle = df[df['Group'].isin(['G2', 'G3'])].dropna(subset=['Refactor', 'Cycle'])
rho_rc, p_val_rc = spearmanr(g23_refac_cycle['Refactor'], g23_refac_cycle['Cycle'])

plt.figure(figsize=(8, 5.5))
sns.regplot(x='Refactor', y='Cycle', data=g23_refac_cycle, 
            y_jitter=0.15, scatter_kws={'alpha': 0.6, 'color': '#2ca02c'}, 
            line_kws={'color': '#d62728', 'linewidth': 2})
plt.title("Iterative Release Cycles vs. Refactoring Effort (G2 & G3)", pad=15)
plt.xlabel("Time Spent on Optimization/Refactoring (%)")
plt.ylabel("Iterative Release Cycle Score (1-7)")
plt.ylim(0.5, 7.5)
plt.text(0.05, 0.95, f"Spearman's $\\rho$ = {rho_rc:.3f}\n$p$-value = {p_val_rc:.3f} (n.s.)\n$N$ = {len(g23_refac_cycle)}", 
         transform=plt.gca().transAxes, fontsize=11, 
         bbox=dict(boxstyle="round,pad=0.3", facecolor="white", edgecolor="gray", alpha=0.8),
         verticalalignment='top')
plt.tight_layout()
plt.savefig(os.path.join(output_dir, "h5_refactor_vs_cycle.png"), dpi=300)
plt.close()


# ----------------------------------------------------
# HYPOTHESIS 6: Experience vs. Level of Abstraction
# ----------------------------------------------------
print("Analyzing Hypothesis 6...")
def map_abstraction(val):
    if pd.isna(val):
        return np.nan
    val = str(val).strip()
    if 'plain mcfunction' in val:
        return 0
    elif 'External scripts' in val:
        return 1
    elif 'Precompiler' in val:
        return 2
    return np.nan

df['Abstraction'] = df[precomp_col].apply(map_abstraction)
abs_df = df.dropna(subset=['Experience', 'Abstraction'])

# Map values to labels
abs_labels = {
    0.0: '0: Plain mcfunction',
    1.0: '1: Custom scripts',
    2.0: '2: Precompilers'
}
abs_df['Abstraction_Label'] = abs_df['Abstraction'].map(abs_labels)

plt.figure(figsize=(8, 5.5))
# Boxplot for distributions
sns.boxplot(x='Abstraction_Label', y='Experience', data=abs_df, 
            order=['0: Plain mcfunction', '1: Custom scripts', '2: Precompilers'], 
            palette='Pastel1', showmeans=True, 
            meanprops={"marker":"s","markerfacecolor":"red", "markeredgecolor":"red"})
# Overlay individual points with jitter for transparency
sns.stripplot(x='Abstraction_Label', y='Experience', data=abs_df, 
              order=['0: Plain mcfunction', '1: Custom scripts', '2: Precompilers'], 
              color='black', alpha=0.4, jitter=0.2, size=5)

# Add correlation info
rho_abs, p_val_abs = spearmanr(abs_df['Experience'], abs_df['Abstraction'])
plt.text(0.05, 0.05, f"Spearman's $\\rho$ = {rho_abs:.3f}\n$p$-value < 0.001\n$N$ = {len(abs_df)}", 
         transform=plt.gca().transAxes, fontsize=11, 
         bbox=dict(boxstyle="round,pad=0.3", facecolor="white", edgecolor="gray", alpha=0.8),
         verticalalignment='bottom')

plt.title("Perceived Experience vs. Level of Code Abstraction", pad=15)
plt.xlabel("Level of Abstraction")
plt.ylabel("Perceived Datapack Experience (1-7)")
plt.ylim(0.5, 7.5)
plt.tight_layout()
plt.savefig(os.path.join(output_dir, "h6_experience_vs_abstraction.png"), dpi=300)
plt.close()


# ----------------------------------------------------
# HYPOTHESIS 7: Compensation-Driven vs. Hobbyist
# ----------------------------------------------------
print("Analyzing Hypothesis 7...")
# Define mostly work for compensation as Comp >= 4
df['Paid_Dev'] = df['Comp'].apply(lambda x: 'Paid (Comp >= 4)' if x >= 4 else 'Hobbyist (Comp < 4)')
comp_clean = df.dropna(subset=['Comp'])

fig, axes = plt.subplots(1, 3, figsize=(16, 5))

# Plot A: Refactoring Time %
refac_group = comp_clean.groupby('Paid_Dev')['Refactor'].mean().reset_index()
sns.barplot(x='Paid_Dev', y='Refactor', data=refac_group, ax=axes[0], palette='Blues')
axes[0].set_title("Average Refactoring Time (%)")
axes[0].set_xlabel("")
axes[0].set_ylabel("Refactoring Effort (%)")
for p in axes[0].patches:
    height = p.get_height()
    axes[0].annotate(f'{height:.1f}%', (p.get_x() + p.get_width() / 2., height + 0.8), 
                     ha='center', va='center', fontsize=10, fontweight='bold')

# Plot B: Released Datapacks
released_group = comp_clean.groupby('Paid_Dev')['Released'].mean().reset_index()
sns.barplot(x='Paid_Dev', y='Released', data=released_group, ax=axes[1], palette='Oranges')
axes[1].set_title("Average Released Datapacks")
axes[1].set_xlabel("")
axes[1].set_ylabel("Released Datapacks")
for p in axes[1].patches:
    height = p.get_height()
    axes[1].annotate(f'{height:.1f}', (p.get_x() + p.get_width() / 2., height + 0.3), 
                     ha='center', va='center', fontsize=10, fontweight='bold')

# Plot C: Commenting Frequency
comment_group = comp_clean.groupby('Paid_Dev')['CommentFreq'].mean().reset_index()
sns.barplot(x='Paid_Dev', y='CommentFreq', data=comment_group, ax=axes[2], palette='Greens')
axes[2].set_title("Average Comment Frequency (1-7)")
axes[2].set_xlabel("")
axes[2].set_ylabel("Comment Frequency Score")
axes[2].set_ylim(1, 7)
for p in axes[2].patches:
    height = p.get_height()
    axes[2].annotate(f'{height:.2f}', (p.get_x() + p.get_width() / 2., height + 0.1), 
                     ha='center', va='center', fontsize=10, fontweight='bold')

plt.suptitle("Work Patterns: Paid vs. Hobbyist Datapack Developers", y=0.98, weight='bold')
plt.tight_layout()
plt.savefig(os.path.join(output_dir, "h7_compensation.png"), dpi=300)
plt.close()

print("All plots successfully generated!")
