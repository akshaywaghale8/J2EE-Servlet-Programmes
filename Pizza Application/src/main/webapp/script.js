function validateForm(event) {
    event.preventDefault(); // Prevent form submission

    const nameInput = document.getElementById('name');
    const crustSelect = document.getElementById('crust');
    const toppingsCheckboxes = document.querySelectorAll('input[name="toppings"]:checked');
    const appetizerRadios = document.querySelectorAll('input[name="appetizer"]');
    const addressTextarea = document.getElementById('address');
    const cardTypeRadios = document.querySelectorAll('input[name="cardType"]');
    const cardNumberInput = document.getElementById('cardNumber');
    const conformCardNumberInput = document.getElementById('conformCardNumber');

    let isValid = true;

    // Validate name
    if (nameInput.value.trim() === '') {
        alert('Please enter your name.');
        isValid = false;
    }

    // Validate crust selection
    if (crustSelect.value === '') {
        alert('Please select a crust.');
        isValid = false;
    }

    // Validate toppings selection
    if (toppingsCheckboxes.length === 0) {
        alert('Please select at least one topping.');
        isValid = false;
    }

    // Validate appetizer selection
    let appetizerSelected = false;
    for (const radio of appetizerRadios) {
        if (radio.checked) {
            appetizerSelected = true;
            break;
        }
    }
    if (!appetizerSelected) {
        alert('Please select a free appetizer.');
        isValid = false;
    }

    // Validate address
    if (addressTextarea.value.trim() === '') {
        alert('Please enter your address.');
        isValid = false;
    }

    // Validate card type selection
    let cardTypeSelected = false;
    for (const radio of cardTypeRadios) {
        if (radio.checked) {
            cardTypeSelected = true;
            break;
        }
    }
    if (!cardTypeSelected) {
        alert('Please select a card type.');
        isValid = false;
    }

    // Validate card number
    const cardNumberPattern = /^[0-9]{12,19}$/;
    if (!cardNumberPattern.test(cardNumberInput.value)) {
        alert('Please enter a valid card number (12-19 digits).');
        isValid = false;
    }

    // Validate conform card number
    if (cardNumberInput.value !== conformCardNumberInput.value) {
        alert('Card number and conform card number do not match.');
        isValid = false;
    }

    if (isValid) {
        // Form is valid, submit the form
        document.getElementById('orderForm').submit();
    }
}