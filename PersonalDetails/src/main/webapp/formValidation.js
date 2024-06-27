// formValidation.js

function validateForm() 
{
    var fname = document.getElementById('fname').value;
    var age = document.getElementById('age').value;
    var mNumber = document.getElementById('mNumber').value;
    var gender = document.querySelector('input[name="gender"]:checked');


    // Validation logic
    if (fname === '') {
        alert('Please enter your name.');
        return false;
    }
    if(age < 18)
    {
		alert('Age must be grater than 17.');
		return false;
	}
    if (age === '' || isNaN(age)) {
        alert('Please enter a valid age.');
        return false;
    }
    if (mNumber === '' || isNaN(mNumber)) {
        alert('Please enter a valid mobile number.');
        return false;
    }
    if (!gender)
    {
        alert('Please select your gender.');
        return false;
    }
    

    // If all validations pass, you can submit the form or perform other actions
    // Example: document.getElementById('myForm').submit();
    // Replace 'myForm' with the ID of your form
    return true;
}
