class TaxCalculator:
    def CalculateTaxRate(state):
        if state == "KS":
            return "6.15"
        elif state == "MS":
            return "7%"
        elif state in ["IA", "FL"]:
            return "6%"
        elif state in ["LA", "GA"]:
            return "4%"
        else:
            return "3%"
        
class Main:
    def main():
        state = input("Enter state code: ").upper()
        taxRate = TaxCalculator.CalculateTaxRate(state)
        print(f"Tax rate for {state} is {taxRate}")

if __name__ == "__main__":
    Main.main()