
document.addEventListener('DOMContentLoaded', () => {
    const registerButton = document.getElementById('register_button');
    registerButton.addEventListener('click', () => {
        console.log('Register button clicked');
        const username = document.getElementById('username').value;
        const password = document.getElementById('password').value;
        const email = document.getElementById('email').value;
        const phone = document.getElementById('phone').value;
        const birthdate = document.getElementById('birthdate').value;
        const country = document.getElementById('country').value;
        
        const user = {
            username,
            password,
            email,
            phone,
            birthdate,
            country
        };

        $.ajax({
            url: 'http://localhost:9090/api/users/',
            type: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(user),
            success: (response) => {
                console.log('Success:', response);
                alert('Usuario registrado exitosamente!');
            },
            error: (error) => {
                console.log('Error:', error);
                alert('Error al registrar usuario: ' + error.responseText);
            }
        });
    });
});