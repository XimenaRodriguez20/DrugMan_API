let stompCliente = null;

const onConnectSocket = () => {
    stompCliente.subscribe('/tema/pacman', (mensaje) => {
        mostrarMensaje(mensaje.body);
    });
    pedirMensajes();
};

const onWebSocketClose = () => {
    if (stompCliente !== null) {
        stompCliente.deactivate();
    }
};

const conectarWS = () => {
    onWebSocketClose();
    stompCliente = new StompJs.Client({
        webSocketFactory: () => new WebSocket('ws://localhost:5000/pacman-websocket')
    });
    stompCliente.onConnect = onConnectSocket;
    stompCliente.onWebSocketClose = onWebSocketClose;
    stompCliente.activate();
};

const enviarMensaje = () => {
    let txtNombre = document.getElementById('txtNombre');
    let txtMensaje = document.getElementById('txtMensaje');

    stompCliente.publish({
        destination: '/app/move',
        body: JSON.stringify({
            email: txtCorreo.value,
            name: txtNombre.value,
            points: txtMensaje.value
        })
    });
};

const mostrarMensaje = (mensaje) => {
    const body = JSON.parse(mensaje);
     console.log(body);
    listar(body.name, body.points);

};

document.addEventListener('DOMContentLoaded', () => {
    const btnEnviar = document.getElementById('btnEnviar');
    btnEnviar.addEventListener('click', (e) => {
        e.preventDefault();
        enviarMensaje();
    });
    conectarWS();
});

const pedirMensajes = () => {
    const xhr = new XMLHttpRequest();
    // Establecer el método HTTP de la solicitud
    xhr.open("GET", "http://localhost:5000/user");
    // Enviar la solicitud
    xhr.send();
    // Recibir la respuesta
    xhr.onload = function() {
        // Obtener la respuesta
        const response = xhr.responseText;
        // Interpretar la respuesta como un array de strings
        var mensajeJSON = JSON.parse(response);
        var claves = Object.keys(mensajeJSON);
        // Mostrar los elementos
        var jugar;
        for (const item of claves) {
            jugador = mensajeJSON[item];
            listar(jugador.name, jugador.points);
        }
    };
};

function listar(nombre, puntaje) {
    var bandera = false;
    const myUl = document.querySelector("#ULMensajes");  // Obtener el elemento <ul>
    const liElements = myUl.querySelectorAll("li");     //Lista de elementos <li> de myUl

    for (const liElement of liElements) {
        // Obtener el ID del elemento <li>
        const id = liElement.getAttribute("id");
        if (id == nombre){
            liElement.innerHTML = `<strong>${nombre}</strong>: ${puntaje}`;
            bandera = true;
            break;
        }
        // Mostrar el ID del elemento <li>
        console.log("ID: " + id);
    }
    if (bandera) {
        console.log("Si existe el id del elemento");
    } else {
        const mensajeLI = document.createElement('li');  // Crea el elemento que se mostrara en pantalla
        mensajeLI.classList.add('list-group-item');
        mensajeLI.setAttribute("id", nombre);           // Asigna como id el nombre del jugador
        mensajeLI.innerHTML = `<strong>${nombre}</strong>: ${puntaje}`;
        ULMensajes.appendChild(mensajeLI);
    }

}
