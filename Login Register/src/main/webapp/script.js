/**
 * 
 */

 function validateForm() {
    var userId = document.getElementById('userId').value.trim();
    var password = document.getElementById('password').value.trim();

    if (userId === '') {
        alert('Please enter your User ID');
        return false;
    }

    if (password === '') {
        alert('Please enter your Password');
        return false;
    }

    return true;
}
