document.addEventListener('DOMContentLoaded', () => {
    const loginButton = document.getElementById('login_button');
    loginButton.addEventListener('click', (event) => {
        event.preventDefault(); // Prevenir el comportamiento por defecto del formulario
        console.log('Login button clicked');
        const username = document.getElementById('username').value;
        const password = document.getElementById('password').value;
        
        const user = {
            username,
            password
        };
        location.href="http://localhost:9090/";

        /*
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
        });*/
    });
});