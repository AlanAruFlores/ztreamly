
document.addEventListener('DOMContentLoaded', () => {
    const registerButton = document.getElementById('login_button');
    registerButton.addEventListener('click', () => {
        console.log('Login button clicked');
        const username = document.getElementById('username').value;
        const password = document.getElementById('password').value;
        
        const user = {
            username,
            password
        };

        $.ajax({
            url: 'http://localhost:9090/api/users/login',
            type: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(user),
            success: (response) => {
                console.log('Success:', response);
                alert('Usuario logeado exitosamente!');
                location.href="http://localhost:9090/";
            },
            error: (error) => {
                console.log('Error:', error);
                alert('Error al logear al usuario: ' + error.responseText);
            }
        });
    });
});