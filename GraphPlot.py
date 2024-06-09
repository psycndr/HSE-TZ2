import matplotlib.pyplot as plt
import pandas as pd

data = pd.read_csv('src/main/output/results.csv')

sizes = data['Size'].to_numpy()
times_sum = data['TimeSum'].to_numpy()

plt.figure(figsize=(14, 8))

plt.plot(sizes, times_sum, label='Time for _sum', marker='o')

plt.xlabel('Size of input data')
plt.ylabel('Execution time (ms)')
plt.title('Execution time vs Size of input data')
plt.legend()
plt.grid(True)
plt.xscale('log')
plt.yscale('log')

plt.xticks(sizes)

plt.show()