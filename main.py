import numpy as np
import pandas as pd
import matplotlib.pyplot as plt

# =========================
# LÄS IN FIL, låt detta vara orört
# =========================

file = "OBS.csv" # ändra till ditt filnamn

df = pd.read_csv(file, sep=";", header=None, encoding="utf-8")

# hitta kolumn med "YYYY-MM"
ym = df[2]
T = df[3].astype(float).values

# =========================
# SKAPA TIDSVARIABEL
# =========================

year = ym.str[:4].astype(int)
month = ym.str[5:7].astype(int)
t = year + (month - 1)/12
t = t.values

# =========================
# Skapa matrisen (ersätts i uppgiften)
# =========================

omega = 2 * np.pi # 1 år period
X = np.ones((len(t), 4)) # dummy/start-matris, ersätts i uppgiften


# =========================
# UPPGIFT
# =========================

X = np.column_stack((np.ones(len(t)), t, np.sin(omega * t), np.cos(omega * t)))

M = X.T @ X
y = X.T @ T

beta = np.linalg.solve(M, y)

a, b, A, B = beta

T_sin = X @ beta

c = np.sqrt(A**2 + B**2)
t_s = (1/omega) * np.arctan2(-B, A)


print("\nLinjär + sinus:")
print(f"a = {a:.3f}, b = {b:.5f}")
print(f"A = {A:.3f}, B = {B:.3f}")

print(f"Amplitud c = {c:.3f}")
print(f"Fas t_s = {t_s:.3f} år")
print(f"Fas t_s = {t_s * 12:.3f} månader")

# =========================
# PLOT
# =========================

plt.figure(figsize=(10,6))

plt.plot(t, T, 'o', label="Data")
plt.plot(t, T_sin, label="Linjär + sinus")

plt.xlabel("Tid (år)")
plt.ylabel("Temperatur (°C)")
plt.title("Laboration 3")
plt.legend()
plt.grid()
plt.show()