
document.addEventListener('DOMContentLoaded', () => {
    const registerButton = document.getElementById('register_button');
    registerButton.addEventListener('click', () => {
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
            url: '/api/users',
            type: 'POST',
            data: user,
            success: (response) => {
                console.log(response);
            },
            error: (error) => {
                console.log(error);
            }
        });
    });
});