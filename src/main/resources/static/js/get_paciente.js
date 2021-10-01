window.addEventListener("load", function(){
    if(window.location.pathname == "/pacientes.html")
        mostrarTodos();
});

async function mostrarTodos(){

        await fetch('/pacientes',{
                method: 'GET',
                headers: {
                    'Accept': 'application/json',
                    'Content-Type': 'application/json'
                }
            })
            .then(function (response) {
                return response.json()
            })
            .then(function (pacientes) {
                let pacienteHtml = "";

                for (const paciente of pacientes) {
                    console.log(paciente);

                  pacienteHtml += '<tr id="pacienteId' + paciente.id + '">' +
                      '<td>' + paciente.id + '</td>' +
                      '<td class="td_first_name">' + paciente.nombre.toUpperCase() + '</td>' +
                      '<td class="td_last_name">' + paciente.apellido.toUpperCase() + '</td>' +
                      '<td class="td_dni">' + paciente.dni + '</td>' +
                      '<td class=\"td_fechaIngreso\">' + paciente.fechaAlta + '</td>' +
                      '<td class="td_id_domicilio">' + paciente.domicilio.id + ", "+ paciente.domicilio.calle + ", " + paciente.domicilio.numero + ". " + paciente.domicilio.localidad + ". " + paciente.domicilio.provincia +'</td>' +
                      '<td>' +
                      '</td>' +
                    '</tr>';
                }
                document.querySelector('#pacienteTable tbody').innerHTML = pacienteHtml;
                mostrarPorId();
                
            })
            .catch(function (error) {
                console.log(error);
            })
}

function mostrarPorId(){

    const btns = document.querySelectorAll(".edit");

    btns.forEach(item => {
        item.addEventListener("click", (e) => {
            const [,id] = e.target.id.split("_")

             fetch(('/pacientes/' + id),{
                method: 'GET',
                headers: {
                    'Accept': 'application/json',
                    'Content-Type': 'application/json'
                }
            })
            .then(function (response) {
                return response.json()
            })
            .then(function (paciente) {

                let [fechaCompleta,] = paciente.fechaIngreso.split("T");
                let [anio, mes, dia] = fechaCompleta.split("-");
                let fecha = dia + "/" + mes + "/" + anio;

                document.querySelector("#id-paciente").value = paciente.id;
                document.querySelector("#nombre").value = paciente.nombre;
                document.querySelector("#apellido").value = paciente.apellido;
                document.querySelector("#dni").value = paciente.dni;
                document.querySelector("#fecha-ingreso").value = fecha;
                document.querySelector("#id").value = paciente.domicilio.id;
                document.querySelector("#calle").value = paciente.domicilio.calle;
                document.querySelector("#numero").value = paciente.domicilio.numero;
                document.querySelector("#localidad").value = paciente.domicilio.localidad;
                document.querySelector("#provincia").value = paciente.domicilio.provincia;
                editarPaciente();

            })
            .catch(function (error) {
                console.log(error);
            })
        })
    })
}

