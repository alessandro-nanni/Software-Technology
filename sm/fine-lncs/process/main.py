import pandas as pd
import matplotlib.pyplot as plt
import numpy as np

# 1. Load the data
df = pd.read_csv("sm/fine-lncs/process/data.csv")

age_column = "What is your age? (optional)" 

# Filter the dataframe for the different age groups
# Converting the age column to numeric to safely filter out text or blank responses
df[age_column] = pd.to_numeric(df[age_column], errors='coerce')

df_19_or_older = df[df[age_column] >= 19]
df_under_18 = df[df[age_column] < 18] # Added filter for under 18

# 2. Define the exact questions to analyze
questions = [
    "Indicate your level of experience in the domain of datapack development.",
    "Indicate your familiarity with computer programming outside of minecraft datapacks",
    "How often do you develop datapacks as a hobby (with no financial compensation)?",
    "How often do you develop datapacks for financial compensation (for other people)?",
    "How often do you rely on libraries (player motion, string uuid, floating point math...) written by others?",
    "How often do you use LLMs (AI chatbots, agentic coding) to write datapack code?",
    "Do you release your datapacks in cycles (iteratively, excluding beta tests), or do you release them only once they are ready?",
    "How often do you comment your code?",
    "If you comment, how much do you comment your code?"
]

# 3. Calculate the averages
# Averages for ALL respondents
averages_all = [pd.to_numeric(df[q], errors='coerce').dropna().mean() for q in questions]

# Averages for respondents 19 or older
averages_19_plus = [pd.to_numeric(df_19_or_older[q], errors='coerce').dropna().mean() for q in questions]

# Averages for respondents under 18
averages_under_18 = [pd.to_numeric(df_under_18[q], errors='coerce').dropna().mean() for q in questions]

# 4. Set up the plot
plt.figure(figsize=(10, 8))
y_pos = np.arange(len(questions))

# 5. Create the zig-zag line charts
# Lighter line for all answers (using alpha=0.4 for transparency)
plt.plot(averages_all, y_pos, marker='o', linestyle='-', color='blue', alpha=1, markersize=8, linewidth=2, label='All Respondents')

# Darker line for 19+ answers (solid color and slightly thicker)
plt.plot(averages_19_plus, y_pos, marker='o', linestyle='-', color='green', alpha=0.5, markersize=8, linewidth=3, label='19 Years or Older')

# Contrasting line for under 18 answers (solid color and slightly thicker)
plt.plot(averages_under_18, y_pos, marker='o', linestyle='-', color='coral', alpha=0.5, markersize=8, linewidth=3, label='Under 18')

# Format the Y-axis: shorten strings so they don't overflow the screen
short_questions = [q[:65] + "..." if len(q) > 65 else q for q in questions]
plt.yticks(y_pos, short_questions)

# Invert Y-axis so the first question appears at the top
plt.gca().invert_yaxis() 

# 6. Set constraints and styles
plt.xlim(1, 7) # Lock the range from 1 to 7 as requested
plt.grid(True, axis='x', linestyle='--', alpha=0.7)

plt.xlabel('Average Score (1-7)', fontsize=12, fontweight='bold')
plt.title('Average Responses by Age Group', fontsize=14, fontweight='bold')

# Add a legend to explain the three lines
plt.legend(loc='lower right')

plt.tight_layout()

# Save the resulting chart
plt.savefig('sm/fine-lncs/process/survey_averages.png')