document.addEventListener("DOMContentLoaded", function () {
    const loanAmountInput = document.getElementById('loan-amount');
    const interestRateInput = document.getElementById('interest-rate');
    const loanTenureInput = document.getElementById('loan-tenure');

    const loanAmountDisplay = document.getElementById('loan-amount-display');
    const interestRateDisplay = document.getElementById('interest-rate-display');
    const loanTenureDisplay = document.getElementById('loan-tenure-display');

    const emiResult = document.getElementById('emi-result');

    // EMI calculation function
    function updateEMI() {
        let loanAmount = parseFloat(loanAmountInput.value);
        let annualInterestRate = parseFloat(interestRateInput.value);
        let loanTenure = parseInt(loanTenureInput.value);

        let monthlyInterestRate = (annualInterestRate / 12) / 100;
        let numberOfMonths = loanTenure * 12;

        // EMI Formula: [P × r × (1 + r)^n] / [(1 + r)^n – 1]
        let emi = loanAmount * monthlyInterestRate * Math.pow(1 + monthlyInterestRate, numberOfMonths) /
                  (Math.pow(1 + monthlyInterestRate, numberOfMonths) - 1);

        loanAmountDisplay.textContent = `₹${loanAmount.toLocaleString()}`;
        interestRateDisplay.textContent = `${annualInterestRate}%`;
        loanTenureDisplay.textContent = `${loanTenure} yr`;
        emiResult.textContent = emi.toFixed(2);
    }

    // Event listeners
    loanAmountInput.addEventListener('input', updateEMI);
    interestRateInput.addEventListener('input', updateEMI);
    loanTenureInput.addEventListener('input', updateEMI);

    // Initial calculation on page load
    updateEMI();
});
