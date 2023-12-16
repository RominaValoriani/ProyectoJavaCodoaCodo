
let nombre = document.querySelector("#nombre");
let apellido = document.querySelector("#apellido");

let email = document.querySelector("#email");
let dni = document.querySelector("#dni");


let temaCharla = document.querySelector("#temaCharla");




document.getElementById("miFormulario").addEventListener("submit", function(event) {
  
  event.preventDefault();

});
 

// funcion del boton 

function clickCharla() {
    let nombreValor = nombre.value.trim();
    let apellidoValor = apellido.value.trim();
    let dniValor = dni.value.trim();
    let temaCharlaValor = temaCharla.options[temaCharla.selectedIndex].text;
  
    if (nombreValor === '' || apellidoValor === '' || temaCharlaValor === '¿Selecciona el tema de tú charla?' || dniValor.length < 7 || dniValor.length > 8) {
      alert('Por favor, completa todos los campos y recuerda que el Dni tiene que tener entre 7 a 8 caracteres(numeros).');
      return;
    }
  
  
    let divCharla = document.createElement('div');
    divCharla.classList.add('card', 'mb-3');
  
    let cardHeader = document.createElement('div');
    cardHeader.classList.add('card-header', 'h5');
    cardHeader.textContent = nombreValor + ' ' + apellidoValor;
  
    let cardBody = document.createElement('div');
    cardBody.classList.add('card-body');
  
    let cardText = document.createElement('p');
    cardText.classList.add('card-text');
    cardText.textContent = 'Tema a charlar: ' + temaCharlaValor;
  
    let btnEditar = document.createElement('a');
    btnEditar.classList.add('btn', 'btn-warning');
    btnEditar.textContent = 'Editar';
    //editar contenido de la charla seleccionada
    btnEditar.addEventListener('click', function() {
      let selectCharla = document.createElement('select');
      selectCharla.classList.add('form-select', 'mb-3');
      selectCharla.id = 'selectCharla';
  
      let option1 = document.createElement('option');
      option1.value = 'Tecnología';
      option1.textContent = 'Tecnología';
      let option2 = document.createElement('option');
      option2.value = 'Innovación';
      option2.textContent = 'Innovación';
      let option3 = document.createElement('option');
      option3.value = 'Inteligencia Artificial';
      option3.textContent = 'Inteligencia Artificial';
  
      selectCharla.appendChild(option1);
      selectCharla.appendChild(option2);
      selectCharla.appendChild(option3);
  
      let btnConfirmar = document.createElement('button');
      btnConfirmar.classList.add('btn', 'btn-primary', 'mt-2');
      btnConfirmar.textContent = 'Confirmar';
  
      // Agregar evento al botón Confirmar para guardar la edición
      btnConfirmar.addEventListener('click', function() {
        let temaCharlaSeleccionado = selectCharla.value;
        cardBody.innerHTML = ''; 
  
        let cardText = document.createElement('p');
        cardText.classList.add('card-text');
        cardText.textContent = 'Tema a charlar: ' + temaCharlaSeleccionado;
  
        cardBody.appendChild(cardText);
        cardBody.appendChild(btnEditar);
        cardBody.appendChild(btnEliminar);
      });
  
      cardBody.innerHTML = '';
      cardBody.appendChild(selectCharla);
      cardBody.appendChild(btnConfirmar);
    });
  


    //
    let btnEliminar = document.createElement('a');
    btnEliminar.classList.add('btn', 'btn-danger', 'ms-1');
    btnEliminar.textContent = 'Eliminar';
     // Eliminar la charla
  btnEliminar.addEventListener('click', function() {
    divCharla.remove();
  });
  
    cardBody.appendChild(cardText);
    cardBody.appendChild(btnEditar);
    cardBody.appendChild(btnEliminar);
  
    divCharla.appendChild(cardHeader);
    divCharla.appendChild(cardBody);
  
    // Obtener el elemento contenedor donde quieres agregar el nuevo div
  let contenedorCharlas = document.getElementById('contenedorCharlas');

  // Agregar el nuevo div creado al principio del contenedor de charlas
  contenedorCharlas.insertBefore(divCharla, contenedorCharlas.firstChild);

  // Limpiar los campos del formulario después de agregar la charla
  document.getElementById("miFormulario").reset();

  }
  
  //
