fetch('components/footer-component.html')
.then(response => response.text())
.then(data => {
    // Crear un elemento temporal para parsear el HTML
    const temp = document.getElementsByClassName('footer');
    temp.innerHTML = data;
    
    // Ejecutar el script del componente
    const script = temp.querySelector('script');
    if (script) {
        eval(script.textContent);
    }
});