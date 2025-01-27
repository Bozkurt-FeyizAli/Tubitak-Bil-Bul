data = [
    ([4, 28, 3, 24, 14, 14, 7, 1, 12, 22, 14], 16),
    ([25, 26, 6, 25, 1, 1, 6, 15, 16, 6, 18], 8),
    ([14, 21, 28, 7, 21, 21, 14, 1, 1, 28, 29], 3),
    ([25, 6, 10, 1, 1, 1, 6, 5, 16, 10, 1], 7),
    ([21, 9, 1, 17, 24, 12, 28, 1, 18, 1, 17], 1),
    ([18, 12, 17, 2, 1, 22, 25, 9, 9, 17, 28], None),
    ([27, 21, 22, 6, 23, 1, 16, 14, 15, 22, 26], None),
    ([1, 1, 6, 28, 22, 15, 25, 1, 25, 1, 21], None),
    ([22, 15, 28, 15, 1, 12, 21, 21, 3, 12, 6], 1),
    ([1, 1, 10, 12, 12, 7, 24, 1, 6, 16, 9], 3),
    ([21, 5, 1, 20, 16, 6, 1, 12, 28, 2, 12], 23),
    ([12, 1, 17, 18, 2, 14, 15, 22, 10, 6, 21], 3),
    ([4, 9, 7, 29, 6, 6, 12, 1, 1, 28, 22], 9),
    ([1, 12, 6, 1, 28, 4, 14, 15, 17, 15, 1], 3),
    ([16, 16, 14, 17, 15, 25, 22, 12, 20, 12, 12], 17),
    ([22, 1, 6, 24, 12, 14, 1, 1, 18, 1, 16], 16),
    ([6, 16, 14, 12, 14, 25, 21, 15, 29, 15, 2], 23),
    ([28, 18, 18, 7, 18, 21, 12, 1, 1, 1, 6], 3),
    ([10, 9, 29, 6, 29, 18, 4, 5, 17, 5, 28], 19),
    ([1, 15, 1, 14, 1, 27, 1, 1, 24, 1, 15], 3),
    ([17, 25, 17, 6, 17, 1, 16, 9, 12, 9, 12], 14),
]

# Fonksiyon: Mod sonuçlarını kontrol et
def check_mod(data, mod_values):
    for numbers, expected_result in data:
        print(f"Numbers: {numbers}, Expected Result: {expected_result}")
        if expected_result is None:
            print("Result: None (No match expected)\n")
            continue

        for mod in mod_values:
            mod_results = [num % mod for num in numbers]
            if expected_result in mod_results:
                print(f"Match found with Mod {mod}: {mod_results}\n")
                break
        else:
            print("No match found.\n")

# Mod değerleri (denenecek)
mod_values = [23, 16, 15, 10]  # İstenirse genişletilebilir

# Çalıştır
check_mod(data, mod_values)
